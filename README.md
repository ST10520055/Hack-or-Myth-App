# 📱 Life Hack or Urban Myth?
**Mobile Application Development 2026 Assignment**


## 📄 Comprehensive Project Report

### 1. Purpose of the Application
The "Life Hack or Urban Myth?" app is an educational tool designed to challenge users' common sense regarding viral internet trends. By presenting a series of statements, the app aims to:
* Educate users on the validity of common "hacks."
* Promote critical thinking about online information.
* Provide a fun, gamified learning experience with instant feedback.

### 2. Design Considerations
* **User Experience (UX):** A 3-screen linear flow (Welcome -> Quiz -> Results) ensures simplicity and prevents user confusion.
* **Visual Feedback:** The app uses dynamic text updates to provide immediate explanations after every answer, reinforcing the learning objective.
* **Responsive Layout:** Built using `ConstraintLayout` to ensure the UI elements (buttons and text) scale correctly across different Android screen sizes and orientations.
* **Navigation:** Managed via explicit `Intents`, passing data (scores) between activities to maintain state.

### 3. Utilization of GitHub & Version Control
This project follows professional development workflows by using Git for version control.
* **Regular Commits:** Each feature (Welcome Screen, Quiz Logic, Score Screen) was committed separately to track progress.
* **Remote Synchronization:** The project is hosted on GitHub to ensure code safety and accessibility.

### 4. GitHub Actions & Automated Testing
To ensure the app's stability, **GitHub Actions** is utilized:
* **Automated Build:** Every "Push" to the main branch triggers an automated build using the `build.yml` workflow.
* **Verification:** This process checks for syntax errors, resource linking issues in the `AndroidManifest.xml`, and Gradle configuration errors before the code is finalized.

---

## 🛠 Technical Details
* **Language:** Kotlin
* **Minimum SDK:** API 24
* **Main Components:**
    * `MainActivity`: Handles the entry point and introductory text.
    * `QuizActivity`: Manages the list of `Flashcards`, score tracking, and logic.
    * `ScoreActivity`: Displays final results and a comprehensive review list.


---

## 🗺️ Application Journey & Logic Flow

### 📍 Phase 1: The Welcome Gate (`MainActivity`)
**Heading: Onboarding & Entry Logic**
* **Purpose:** To introduce the user to the concept and provide a clear starting point.
* **The Logic:** This screen uses an **Explicit Intent** to bridge the gap between the introduction and the first challenge.
* **Interesting Fact:** First impressions matter! By calling `finish()` after starting the next activity, we ensure the user is fully committed to the quiz and cannot accidentally navigate back to the splash screen during the game.

### 🧠 Phase 2: The Flashcard Engine (`QuizActivity`)
**Heading: Interactive Learning & State Management**
* **Purpose:** The core gameplay where users test their knowledge on viral hacks.
* **The Logic:** This is the "brain" of the operation. It manages a dynamic list of `Flashcard` data objects and tracks a running score in the background.
* **Interesting Fact:** Data bundling is key here. Once the final card is flipped, the activity packs the user's score into an Intent "backpack" (Extras) to carry it safely to the finish line.

### 🏆 Phase 3: The Grand Finale (`ScoreActivity`)
**Heading: Results, Feedback, and Knowledge Review**
* **Purpose:** To celebrate the user's performance and provide educational closure.
* **The Logic:** It unpacks the score from the previous activity and uses a conditional "Feedback System" to provide a personalized message.
* **Interesting Fact:** The app isn't just about winning; it's about learning. The "Review" feature triggers an AlertDialog that lists all correct answers, satisfying the assignment requirement for a comprehensive review.

---

## 📸 Interface Preview
> "Who knew half of what we see online isn't true? Here is a look at the app putting common sense to the ultimate test!"

| 1. The Welcome Gate <img width="353" height="578" alt="image" src="https://github.com/user-attachments/assets/c193a69b-8deb-468a-91da-de9a47aa2668"/>




 | 2. The Quiz Engine <img width="378" height="553" alt="image" src="https://github.com/user-attachments/assets/90b7a54b-ddc1-4540-a8bc-9af81e53df2e" />



 
| 3. The Final Score <img width="350" height="579" alt="image" src="https://github.com/user-attachments/assets/1caeacfb-7c11-4644-a37c-208cd0b01df8" /> 



---


## 👤 Author Information
Heading: Project Developer Profile

Name: Tasveer Rampersad

Student Number: ST10520055

Module: Mobile Application Development (IMAD5112)

Academic Year: 2026
