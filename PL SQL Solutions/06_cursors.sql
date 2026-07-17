SET SERVEROUTPUT ON;

-- Scenario 1: Generate monthly statements using an explicit cursor.
DECLARE
  CURSOR GenerateMonthlyStatements IS
    SELECT c.CustomerID,
           c.Name,
           a.AccountID,
           t.TransactionDate,
           t.TransactionType,
           t.Amount
    FROM Customers c
    JOIN Accounts a ON a.CustomerID = c.CustomerID
    JOIN Transactions t ON t.AccountID = a.AccountID
    WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
    ORDER BY c.CustomerID, t.TransactionDate;
BEGIN
  FOR rec IN GenerateMonthlyStatements LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Customer: ' || rec.Name ||
      ', Account: ' || rec.AccountID ||
      ', Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY') ||
      ', Type: ' || rec.TransactionType ||
      ', Amount: ' || rec.Amount
    );
  END LOOP;
END;
/

-- Scenario 2: Deduct annual maintenance fee from all accounts.
DECLARE
  CURSOR ApplyAnnualFee IS
    SELECT AccountID, Balance
    FROM Accounts
    FOR UPDATE;

  v_annual_fee CONSTANT NUMBER := 100;
BEGIN
  FOR rec IN ApplyAnnualFee LOOP
    UPDATE Accounts
    SET Balance = Balance - v_annual_fee,
        LastModified = SYSDATE
    WHERE CURRENT OF ApplyAnnualFee;

    DBMS_OUTPUT.PUT_LINE('Annual fee applied to account ' || rec.AccountID);
  END LOOP;

  COMMIT;
END;
/

-- Scenario 3: Update loan interest rates based on a new policy.
DECLARE
  CURSOR UpdateLoanInterestRates IS
    SELECT LoanID, LoanAmount
    FROM Loans
    FOR UPDATE;
BEGIN
  FOR rec IN UpdateLoanInterestRates LOOP
    UPDATE Loans
    SET InterestRate =
      CASE
        WHEN rec.LoanAmount >= 20000 THEN InterestRate + 0.50
        ELSE InterestRate + 0.25
      END
    WHERE CURRENT OF UpdateLoanInterestRates;

    DBMS_OUTPUT.PUT_LINE('Interest policy updated for loan ' || rec.LoanID);
  END LOOP;

  COMMIT;
END;
/
