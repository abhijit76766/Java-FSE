import React from "react";

function IndianPlayers() {
  // Destructuring to split odd/even team players
  const team = ["Rohit", "Virat", "Gill", "Rahul", "Pandya", "Jadeja"];
  const [odd1, even1, odd2, even2, odd3, even3] = team;
  const oddTeamPlayers = [odd1, odd2, odd3];
  const evenTeamPlayers = [even1, even2, even3];

  // Merging two arrays using the spread (merge) feature of ES6
  const T20players = ["Rohit", "Virat", "Rahul"];
  const RanjiTrophyPlayers = ["Prithvi Shaw", "Sarfaraz Khan", "Yashasvi Jaiswal"];
  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Indian Players</h2>
      <p>Odd Team Players: {oddTeamPlayers.join(", ")}</p>
      <p>Even Team Players: {evenTeamPlayers.join(", ")}</p>

      <h3>T20 + Ranji Trophy Players (merged)</h3>
      <p>{allPlayers.join(", ")}</p>
    </div>
  );
}

export default IndianPlayers;
