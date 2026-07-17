SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE LogError(
  p_procedure_name IN VARCHAR2,
  p_error_message IN VARCHAR2
) AS
  PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
  INSERT INTO ErrorLog (ErrorID, ProcedureName, ErrorMessage, LogDate)
  VALUES (ErrorLogSeq.NEXTVAL, p_procedure_name, p_error_message, SYSDATE);
  COMMIT;
END;
/

-- Scenario 1: Safe fund transfer with rollback and error logging.
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_account_id IN Accounts.AccountID%TYPE,
  p_to_account_id IN Accounts.AccountID%TYPE,
  p_amount IN NUMBER
) AS
  v_source_balance Accounts.Balance%TYPE;
BEGIN
  IF p_amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be positive');
  END IF;

  SELECT Balance
  INTO v_source_balance
  FROM Accounts
  WHERE AccountID = p_from_account_id
  FOR UPDATE;

  IF v_source_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_amount,
      LastModified = SYSDATE
  WHERE AccountID = p_from_account_id;

  UPDATE Accounts
  SET Balance = Balance + p_amount,
      LastModified = SYSDATE
  WHERE AccountID = p_to_account_id;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20003, 'Destination account not found');
  END IF;

  COMMIT;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    ROLLBACK;
    LogError('SafeTransferFunds', 'Source account not found');
  WHEN OTHERS THEN
    ROLLBACK;
    LogError('SafeTransferFunds', SQLERRM);
END;
/

-- Scenario 2: Update salary and log invalid employee IDs.
CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id IN Employees.EmployeeID%TYPE,
  p_percentage IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percentage / 100)
  WHERE EmployeeID = p_employee_id;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20004, 'Employee ID does not exist');
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    LogError('UpdateSalary', SQLERRM);
END;
/

-- Scenario 3: Insert a customer and handle duplicate IDs.
CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id IN Customers.CustomerID%TYPE,
  p_name IN Customers.Name%TYPE,
  p_dob IN Customers.DOB%TYPE,
  p_balance IN Customers.Balance%TYPE
) AS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    LogError('AddNewCustomer', 'Customer ID already exists: ' || p_customer_id);
  WHEN OTHERS THEN
    ROLLBACK;
    LogError('AddNewCustomer', SQLERRM);
END;
/
