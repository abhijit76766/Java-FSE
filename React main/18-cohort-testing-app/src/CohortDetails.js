import React from "react";

function CohortDetails({ cohort }) {
  return (
    <div className="box">
      <h3>{cohort.code}</h3>
      <p>Status: {cohort.status}</p>
      <p>Trainer: {cohort.trainer}</p>
    </div>
  );
}

export default CohortDetails;
