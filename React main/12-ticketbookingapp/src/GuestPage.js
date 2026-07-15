import React from "react";

function GuestPage() {
  const flights = [
    { id: 1, from: "Bhopal", to: "Delhi", time: "08:00 AM" },
    { id: 2, from: "Delhi", to: "Mumbai", time: "11:30 AM" },
    { id: 3, from: "Mumbai", to: "Bangalore", time: "03:15 PM" }
  ];

  return (
    <div>
      <h2>Available Flights (Guest View)</h2>
      <ul>
        {flights.map((f) => (
          <li key={f.id}>
            {f.from} → {f.to} at {f.time}
          </li>
        ))}
      </ul>
      <p>Login to book a ticket.</p>
    </div>
  );
}

export default GuestPage;
