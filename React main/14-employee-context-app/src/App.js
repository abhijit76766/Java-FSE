import React, { useState } from "react";
import ThemeContext from "./ThemeContext";
import EmployeesList from "./EmployeesList";

const employees = [
  { id: 1, name: "Abhijit Sharma", designation: "SDE" },
  { id: 2, name: "Priya Nair", designation: "QA Engineer" },
  { id: 3, name: "Rahul Verma", designation: "DevOps Engineer" }
];

function App() {
  const [theme, setTheme] = useState("light");

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee Management</h1>
        <button onClick={() => setTheme(theme === "light" ? "dark" : "light")}>
          Toggle Theme
        </button>
        <EmployeesList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
