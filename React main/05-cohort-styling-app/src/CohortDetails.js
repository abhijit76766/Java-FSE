import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails({ cohort }) {
  const titleColor = cohort.status === "ongoing" ? "green" : "blue";

  return (
    <div className={styles.box}>
      <h3 style={{ color: titleColor }}>{cohort.code}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
