import React from "react";

const office = {
  name: "Prime Business Hub",
  rent: 55000,
  address: "MG Road, Bhopal"
};

const officeList = [
  { id: 1, name: "Prime Business Hub", rent: 55000, address: "MG Road, Bhopal" },
  { id: 2, name: "Skyline Towers", rent: 72000, address: "Arera Colony, Bhopal" },
  { id: 3, name: "Corporate Point", rent: 48000, address: "New Market, Bhopal" }
];

function App() {
  return (
    <div>
      {/* Heading element created via JSX */}
      <h1>Office Space Rental</h1>

      {/* Attribute to display office image */}
      <img
        src="https://via.placeholder.com/400x200?text=Office+Space"
        alt="office space"
        width="400"
      />

      {/* Single office object details */}
      <h2>Featured Office</h2>
      <p>Name: {office.name}</p>
      <p>Address: {office.address}</p>
      <p style={{ color: office.rent < 60000 ? "red" : "green" }}>
        Rent: {office.rent}
      </p>

      {/* List of office objects, looped through */}
      <h2>All Office Spaces</h2>
      <ul>
        {officeList.map((item) => (
          <li key={item.id}>
            {item.name} - {item.address} -{" "}
            <span style={{ color: item.rent < 60000 ? "red" : "green" }}>
              Rent: {item.rent}
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
