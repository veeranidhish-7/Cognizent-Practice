import React from 'react';
import styles from './CohortDetails.module.css';

// Displays a single cohort's details.
// - "box" class comes from the CSS Module (applied via className)
// - h3 heading color is set dynamically using the inline style prop:
//     green when the cohort is "ongoing", blue for anything else
function CohortDetails(props) {
  const { name, status, startDate, endDate } = props;
  const headingColor = status.toLowerCase() === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: headingColor }}>{name}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{status}</dd>
        <dt>Start Date</dt>
        <dd>{startDate}</dd>
        <dt>End Date</dt>
        <dd>{endDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
