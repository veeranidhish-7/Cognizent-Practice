import React from 'react';
import CohortDetails from './CohortDetails';

const cohorts = [
  {
    id: 1,
    name: 'React Fundamentals',
    status: 'ongoing',
    startDate: '01-Jun-2026',
    endDate: '30-Jul-2026'
  },
  {
    id: 2,
    name: 'Java Full Stack',
    status: 'completed',
    startDate: '01-Jan-2026',
    endDate: '28-Feb-2026'
  },
  {
    id: 3,
    name: 'Cloud Fundamentals',
    status: 'ongoing',
    startDate: '15-Jun-2026',
    endDate: '15-Aug-2026'
  },
  {
    id: 4,
    name: 'Python for Data Science',
    status: 'completed',
    startDate: '01-Mar-2026',
    endDate: '30-Apr-2026'
  }
];

function App() {
  return (
    <div>
      <h1>Academy Cohort Dashboard</h1>
      {cohorts.map((cohort) => (
        <CohortDetails
          key={cohort.id}
          name={cohort.name}
          status={cohort.status}
          startDate={cohort.startDate}
          endDate={cohort.endDate}
        />
      ))}
    </div>
  );
}

export default App;
