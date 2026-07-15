import React from "react";
import { useParams } from "react-router-dom";
import TrainersMock from "./TrainersMock";

function TrainerDetails() {
  const { id } = useParams();
  const trainer = TrainersMock.find((t) => t.TrainerId === Number(id));

  if (!trainer) {
    return <p>Trainer not found</p>;
  }

  return (
    <div>
      <h2>{trainer.Name}</h2>
      <p>Email: {trainer.Email}</p>
      <p>Phone: {trainer.Phone}</p>
      <p>Technology: {trainer.Technology}</p>
      <p>Skills: {trainer.Skills.join(", ")}</p>
    </div>
  );
}

export default TrainerDetails;
