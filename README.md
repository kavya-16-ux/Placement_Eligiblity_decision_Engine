# Placement Eligibility Decision Engine

A Core Java project that checks whether a candidate is eligible for a selected job.

## Features

- Runtime candidate input
- Runtime candidate skills
- Runtime job input
- Multiple jobs using arrays
- Runtime job selection
- Percentage eligibility
- Backlog eligibility
- Graduation year eligibility
- Skill eligibility
- Final readable eligibility result

## OOP Concepts Used

- Encapsulation
- Abstraction
- Inheritance
- Method Overriding
- Polymorphism
- HAS-A Relationship

## Project Structure

- Main.java - controls application flow
- Candidate.java - stores candidate data and skills
- Job.java - stores job requirements and required skills
- EligibilityRule.java - abstract parent for all eligibility rules
- PercentageRule.java - checks percentage
- BacklogRule.java - checks backlogs
- GraduationYearRule.java - checks graduation year
- SkillRule.java - checks required skills
- EligibilityChecker.java - executes all rules

## Compile

javac src/*.java

## Run

java -cp src Main