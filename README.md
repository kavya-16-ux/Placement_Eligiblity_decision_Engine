# Placement Eligibility Decision Engine

An end-to-end placement qualification platform featuring a Core Java object-oriented rule evaluation engine alongside a modern, responsive web interface with persistent job catalog management.

---

## 📌 Project Overview

This project evaluates candidate eligibility for campus and off-campus placements by matching candidate credentials against dynamic company hiring criteria. It models rule evaluation using classical Object-Oriented Programming (OOP) design patterns in Java and provides an interactive browser-based dashboard to test candidate eligibility in real time.

---

## ✨ Features

### Core Java Rule Engine
- **Encapsulated Domain Models**: `Candidate` and `Job` models use private state variables accessed via constructors and public getter methods.
- **Abstract Rule Hierarchy**: An extensible `EligibilityRule` abstraction decouples individual validation algorithms from the execution engine.
- **Polymorphic Rule Evaluation**: Dynamic iteration and pass/fail aggregation across an array of concrete rules.
- **Comprehensive Decision Criteria**:
  - **Percentage Rule**: Verifies whether candidate aggregate meets or exceeds the minimum cut-off percentage.
  - **Backlog Rule**: Checks whether active backlogs stay within the allowed limit.
  - **Graduation Year Rule**: Confirms graduation year matches the required hiring cohort.
  - **Skill Rule**: Validates candidate skills against all required job competencies.
- **Dynamic Multi-Job Processing**: CLI runtime handles dynamic inputs for multiple company openings and candidate job selection.

### Web Interface & Persistence
- **Responsive Dark-Mode UI**: Built with semantic HTML5 and clean CSS3 grid layouts.
- **Dynamic Company Catalog**: Preloaded with major IT hiring profiles (Infosys, TCS, Wipro, Accenture, Capgemini, IBM, Cognizant).
- **Custom Job Registration**: Built-in modal form allowing recruiters or candidates to register custom companies and criteria on the fly.
- **Local Persistence (`localStorage`)**: Custom-created job openings persist across browser refreshes and sessions.
- **Live Rule Breakdown**: Visual PASS/FAIL status badges for each evaluated criterion and instant eligibility verdict banners.

---

## 🧱 OOP Design Principles Applied

| OOP Principle | Implementation Details |
| :--- | :--- |
| **Encapsulation** | `Candidate` and `Job` fields are declared `private`, accessible only through constructors and `public` getter methods. |
| **Abstraction** | `EligibilityRule` declares abstract methods `getRuleName()` and `check(Candidate, Job)`, hiding rule computation details from callers. |
| **Inheritance & Polymorphism** | `PercentageRule`, `BacklogRule`, `GraduationYearRule`, and `SkillRule` inherit from `EligibilityRule`, executed polymorphically through an array loop in `EligibilityChecker`. |
| **Aggregation (HAS-A)** | `Candidate` has skills (`String[]`), `Job` has required skills (`String[]`), and `EligibilityChecker` has a collection of rules (`EligibilityRule[]`). |

---

## 📁 Project Structure

```plaintext
Placement_Eligiblity_decision_Engine/
├── .gitignore
├── README.md
├── src/
│   ├── Candidate.java           # Candidate entity and skill search helper
│   ├── Job.java                 # Job profile requirements and specifications
│   ├── EligibilityRule.java     # Abstract parent class for all evaluation rules
│   ├── PercentageRule.java      # Subclass: Percentage cut-off evaluation
│   ├── BacklogRule.java         # Subclass: Backlog count validation
│   ├── GraduationYearRule.java  # Subclass: Cohort year verification
│   ├── SkillRule.java           # Subclass: Multi-skill matching check
│   ├── EligibilityChecker.java  # Rule engine orchestrating dynamic rule checks
│   └── Main.java                # CLI runtime controller and formatted console output
└── frontend/
    ├── index.html               # Web UI layout, candidate form, and job modal
    ├── style.css                # Dark theme styling, badges, and layout grid
    └── script.js                # Frontend rule evaluator and localStorage persistence