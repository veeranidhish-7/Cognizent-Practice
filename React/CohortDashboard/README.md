# CohortDashboard

Lab: Style react components using CSS Modules and inline style props.

## IMPORTANT NOTE
The lab document referenced "the attached react application" as a
starter project to download, unzip, and style — but that starter zip
was not included with the uploaded docs. This project is a
reconstruction: a small cohort dashboard that matches the description
in the lab (shows ongoing and completed cohorts), built from scratch
so the styling exercise below has something real to work against.

If you have the actual starter zip, send it and this can be redone
against the real base project instead.

## What's implemented (per the lab steps)
- src/CohortDetails.module.css
  - .box class: width 300px, display inline-block, 10px margin all
    round, 10px top/bottom padding, 20px left/right padding, 1px
    black border, 10px border-radius
  - <dt> tag selector: font-weight 500
- src/CohortDetails.js
  - imports the CSS Module
  - applies the "box" class to the container div via className
  - applies inline `style` to the <h3> heading: green when the
    cohort's status is "ongoing", blue otherwise
- src/App.js
  - renders a list of sample cohorts (mix of ongoing/completed) using
    the CohortDetails component

## How to run
1. Unzip this folder.
2. Open the folder in VS Code (or open a terminal inside it).
3. Install dependencies:
   npm install
4. Start the app:
   npm start
5. Browser opens automatically at http://localhost:3000
