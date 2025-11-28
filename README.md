# My Personal Project

## Music Practice Logger 

### Music Practice Logger is an application designed for musicians, allowing them to track daily practice sessions. Users log practice with metadata such as **date**, **comments**, **instruments**, **pieces**, **duration** and **focus area**. The app collects practice time and tracks streaks. Teachers can view each student's session information. The primary reason I chose this concept for my term project is my long-standing connection to music. I have been taking piano lessons since I was seven years old and have also had the opportunity to teach piano, which gave me insight into the challenges students face when practicing. I believe that creating a tool to track and reflect on practice sessions could significantly support learners by making their progress more visible, structured, and motivating.

## Main reasons someone would want to use a Music Practice Logger app (User Sotry):
- As a user, I want to be able to add a PracticeSession to my PracticeLog, including details like the pieces practiced.
-As a user, I want to view my practice sessions.
- As a user, I want to be able to view statistics (extracted from the practice session, such as duration of practice) from my PracticeLog to see how my progress changes over time.
- As a user, I want to be able to organize my repertoire into different categories (e.g., classical, jazz, exercises).
- As a user, I want to be able to add comments and reflections after each practice session so I can remember what to focus on next time.
- As a user, I want to be able to set specific goals for each practice session (e.g., "practice scales for 15 minutes" or "learn measures 10–20").
- As a user, when I select the quit option from the application menu, I want to be reminded to save my practice session to file and have the option to do so or not.
- As a user, I want to be able to be able to load my practice log list from file (if I so choose) and resume exactly where I left off at some earlier time.

## Instructions for End User
- You can view the panel that displays the Xs that have already been added to the Y by clicking on the "view" button.
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking on the "Add session" button.
- You can generate the second required action related to the user story "viewing the added Xs to a Y" by clicking the "View sessions" button.
- A visual component will be shown based on the user input in the view sessions tab.
- You can save the state of my application by clicking the "Save" button.
- You can reload the state of my application by clicking the "load" button.

### Phase 4: Task 2
- Mon Nov 24 20:59:44 PST 2025
- Session added to log
- Mon Nov 24 20:59:44 PST 2025
- Practice log loaded from file

## Phase 4: Task 3
- The design can be improved by strengthening UI - model separation and reducing the responsibilities of PracticeLog. Currently, the GUI panels directly reference the PracticeLog, which creates unnecessary coupling.Instead, the UI should interact with the model only through public methods so that all dependencies flow from UI to model, keeping the model independent. Also, PracticeLog is doing too much by storing sessions, logging events, and performing calculations, which violates the SRP. Moving summary or analytic logic (such as total practice time and session counts) into a PracticeStatistics class would make the model more cohesive and easier to maintain. 


