SET SERVEROUTPUT ON;

-- Scenario 1: Apply a 1 percent loan interest discount for customers above 60.
BEGIN
  FOR rec IN (
    SELECT l.LoanID, c.CustomerID, c.Name, c.DOB, l.InterestRate
    FROM Customers c
    JOIN Loans l ON l.CustomerID = c.CustomerID
  ) LOOP
    IF TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;

      DBMS_OUTPUT.PUT_LINE('Discount applied to loan ' || rec.LoanID || ' for ' || rec.Name);
    END IF;
  END LOOP;

  COMMIT;
END;
/

-- Scenario 2: Promote customers with balance above 10000 to VIP.
BEGIN
  FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE',
          LastModified = SYSDATE
      WHERE CustomerID = rec.CustomerID;

      DBMS_OUTPUT.PUT_LINE(rec.Name || ' promoted to VIP');
    END IF;
  END LOOP;

  COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due within the next 30 days.
BEGIN
  FOR rec IN (
    SELECT c.Name, l.LoanID, l.EndDate
    FROM Customers c
    JOIN Loans l ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ' || rec.LoanID || ' for ' || rec.Name ||
      ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/
