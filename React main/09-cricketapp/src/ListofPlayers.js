import React from "react";

const players = [
  { name: "Rohit Sharma", score: 85 },
  { name: "Virat Kohli", score: 92 },
  { name: "Shubman Gill", score: 45 },
  { name: "KL Rahul", score: 60 },
  { name: "Hardik Pandya", score: 30 },
  { name: "Ravindra Jadeja", score: 55 },
  { name: "Jasprit Bumrah", score: 12 },
  { name: "Mohammed Shami", score: 8 },
  { name: "Suryakumar Yadav", score: 78 },
  { name: "Axar Patel", score: 40 },
  { name: "Kuldeep Yadav", score: 15 }
];

function ListofPlayers() {
  // map() to render all players
  const allPlayers = players.map((p, index) => (
    <li key={index}>
      {p.name} - {p.score}
    </li>
  ));

  // arrow function + filter() to get players below 70
  const lowScorers = players.filter((p) => p.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>{allPlayers}</ul>

      <h3>Players with score below 70</h3>
      <ul>
        {lowScorers.map((p, index) => (
          <li key={index}>
            {p.name} - {p.score}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
