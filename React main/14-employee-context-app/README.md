# Exercise 14 - Employee Management (Context API)

The original starter project (props-based theme passing) was
distributed as a separate downloadable zip attachment, not included
in the uploaded lab docs. This solution recreates the app already
converted to Context API as requested:

- `ThemeContext.js` — `createContext('light')`, exported as default.
- `App.js` — wraps the JSX in `ThemeContext.Provider`, supplying the
  `theme` state value; no longer passes `theme` as a prop to
  `EmployeesList`.
- `EmployeesList.js` — no longer receives/forwards `theme` as a prop.
- `EmployeeCard.js` — imports `ThemeContext`, reads it with
  `useContext(ThemeContext)`, and uses it for the button's className.
