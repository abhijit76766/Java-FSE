# PL SQL Solutions

Solutions for the Digital Nurture Java FSE PL/SQL programming exercises.

## Files

- `00_schema_and_sample_data.sql` - Creates the base schema, helper tables, sequences, and sample data.
- `01_control_structures.sql` - Loan discount, VIP flag update, and loan due reminders.
- `02_error_handling.sql` - Safe fund transfer, salary update, and customer insert with exception handling.
- `03_stored_procedures.sql` - Monthly interest, employee bonus, and account transfer procedures.
- `04_functions.sql` - Age, monthly installment, and sufficient balance functions.
- `05_triggers.sql` - Customer modified timestamp, transaction audit, and transaction validation triggers.
- `06_cursors.sql` - Explicit cursor solutions for statements, annual fees, and loan rate updates.
- `07_packages.sql` - Customer, employee, and account operation packages.

## Suggested Run Order

1. Run `00_schema_and_sample_data.sql`.
2. Run the exercise script you want to test.
3. Enable output first when using SQL*Plus or SQL Developer:

```sql
SET SERVEROUTPUT ON;
```

The scripts use Oracle PL/SQL syntax and are written to be readable for hands-on submission.
