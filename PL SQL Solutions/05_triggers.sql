SET SERVEROUTPUT ON;

-- Scenario 1: Update customer LastModified before each customer update.
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2: Log every inserted transaction to AuditLog.
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    AuditID,
    TransactionID,
    AccountID,
    TransactionType,
    Amount,
    AuditDate
  ) VALUES (
    AuditLogSeq.NEXTVAL,
    :NEW.TransactionID,
    :NEW.AccountID,
    :NEW.TransactionType,
    :NEW.Amount,
    SYSDATE
  );
END;
/

-- Scenario 3: Enforce deposit and withdrawal rules before insertion.
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance Accounts.Balance%TYPE;
BEGIN
  IF :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20030, 'Transaction amount must be positive');
  END IF;

  SELECT Balance
  INTO v_balance
  FROM Accounts
  WHERE AccountID = :NEW.AccountID;

  IF UPPER(:NEW.TransactionType) = 'WITHDRAWAL' AND :NEW.Amount > v_balance THEN
    RAISE_APPLICATION_ERROR(-20031, 'Withdrawal amount exceeds account balance');
  ELSIF UPPER(:NEW.TransactionType) NOT IN ('DEPOSIT', 'WITHDRAWAL') THEN
    RAISE_APPLICATION_ERROR(-20032, 'Transaction type must be Deposit or Withdrawal');
  END IF;
END;
/
