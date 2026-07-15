# Exercise 16 - mailregisterapp

`register.js` defines a `Register` form component with name, email
and password fields. Validation runs in `handleSubmit` (event submit)
and `handleChange` keeps controlled inputs in sync (event handle):
name >= 5 chars, email must contain `@` and `.`, password >= 8 chars.
Errors are displayed inline; a successful submission shows an alert.
