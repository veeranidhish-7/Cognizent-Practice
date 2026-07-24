import React from 'react';
import '../Stylesheets/mystyle.css';

// Functional component that accepts Name, School, Total and goal
// (goal = number of subjects/tests the Total marks were scored out of)
// and calculates + displays the average score.
function CalculateScore(props) {
  const { name, school, total, goal } = props;
  const average = (total / goal).toFixed(2);

  return (
    <div className="score-card">
      <h2>Student Score Card</h2>
      <p>Name: {name}</p>
      <p>School: {school}</p>
      <p>Total Marks: {total}</p>
      <p>Number of Subjects: {goal}</p>
      <p>
        Average Score: <span className="score-value">{average}</span>
      </p>
    </div>
  );
}

export default CalculateScore;
