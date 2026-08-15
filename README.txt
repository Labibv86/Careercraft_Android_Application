CSE489-Final Project

Student Name: MD. SHIHAB SHARAR
ID: 22241028

====================================================
PROJECT OVERVIEW
====================================================

CareerCraft is an Android app that I built for this course. It is a freelance
marketplace app, but it has one extra thing that makes it different from a
normal job app. Before a beginner freelancer starts looking for jobs, the app
asks them a short set of questions and then uses a machine learning model to
suggest a career path that fits them. My goal was to help new freelancers who
do not know which type of work to choose, and also give experienced
freelancers and clients a normal, clean way to post jobs, apply, hire, chat,
and rate each other after the work is done.

The app has two types of users, Freelancer and Client. Freelancers can be
Beginner or Expert. Beginners go through the career assessment. Experts pick
their categories directly. Clients post jobs and hire freelancers from the
people who apply.

I kept the design very simple on purpose. The whole app only uses black,
white, grey, and deep grey colors. I did this so the app looks clean and
professional, and so the user always knows which button is the main action
on each screen.

====================================================
FEATURES IMPLEMENTED
====================================================

1. Authentication
    - Sign up and log in with email and password using Supabase Auth.
    - The app remembers the session, so a user does not need to log in every
      time they open the app.

2. Onboarding
    - Role selection (Freelancer or Client).
    - Experience level selection for freelancers (Beginner or Expert).
    - A 9-question skill assessment for beginners, with sliders and
      multiple-choice questions.
    - Manual category picker for experts and for anyone not satisfied with
      their ML result.

3. Machine Learning Career Match
    - I trained a Random Forest Classifier using scikit-learn on a custom
      dataset of 4,000 synthetic samples (1,000 per career category).
    - I converted the trained model into native code using a tool called
      m2cgen, so the model runs directly on the phone. It does not need
      internet access and gives an answer instantly.
    - The model predicts one of four categories (Technology, Creative,
      Physical, Service) and the app shows the top 3 job suggestions with a
      match percentage.

4. Freelancer Features
    - Dashboard showing career path, rating, and profile status.
    - Smart Job Feed that shows open jobs, sorted so jobs matching the
      freelancer's career path appear first.
    - Job detail page and a proposal form to apply for a job.
    - My Proposals page with tabs for Pending, Accepted, Rejected, and
      Withdrawn, with a working Withdraw button (only usable before a client
      makes a decision).
    - My Jobs page for freelancers, showing every job they were hired for.
      Each job has a color dot: green for ongoing, red for past deadline, and
      grey for finished. The list is sorted in that same order.
    - Portfolio page where freelancers can upload images and add project
      details. Images are stored using Supabase Storage.

5. Client Features
    - Dashboard showing active jobs, applications received, and active
      contracts.
    - Post Job form with title, category, description, required skills, pay
      range, duration, and location type.
    - My Jobs page and an Applicants page to view everyone who applied.
    - A Hire button that accepts one proposal, rejects the other pending
      ones, and creates a contract, all at the same time.

6. Contracts and Chat
    - Once a client hires someone, a contract is created automatically and a
      chat becomes available immediately for both sides, with a default
      message saying they are now connected. Neither side has to start the
      chat manually.
    - Real-time-style messaging tied to the contract.
    - Mark Complete button on both sides. The contract only closes once both
      the freelancer and the client have marked it complete. After that, the
      chat becomes read-only.

7. Rating System
    - After a contract is completed, both sides are asked to rate each
      other on a scale of -10 to +10, with an optional feedback message.
      I used this scale instead of a normal 5-star system because it gives a
      more detailed picture of how the work went.

====================================================
DATABASE USAGE
====================================================

I used Supabase as my backend, which is a hosted PostgreSQL database with
built-in authentication, file storage, and instant APIs. I chose Supabase
because it uses a real relational database, so I could use foreign keys,
constraints, and joins, which fit this project much better than a NoSQL
database would have.

My database has 9 main tables:
- users (stores both freelancers and clients, with role and rating)
- assessment_questions (the 9 questions used in the skill assessment)
- jobs (job postings created by clients)
- proposals (applications submitted by freelancers)
- contracts (created automatically when a client hires someone)
- messages (chat messages, tied to a contract)
- portfolio (freelancer project entries with image links)
- reviews (the -10 to +10 ratings after a contract ends)
- notifications (planned for future use)

I also used:
- Row Level Security (RLS) policies on every table, so users can only see or
  change the data they are allowed to. For example, a user can only update
  their own profile, and only the sender of a message can insert it.
- Database Triggers, for example one that automatically recalculates a
  user's average rating every time a new review is added.
- Database Functions, for actions that need to happen safely as one single
  step. The best example is hire_freelancer(), which accepts a proposal,
  rejects the other proposals for that job, updates the job status, and
  creates the contract, all inside one function. I did this so the data
  never ends up half-updated if something goes wrong midway.
- Supabase Storage, for storing the actual portfolio images, with policies
  so a user can only upload or delete their own images.

====================================================
ARCHITECTURE USED
====================================================

I built the Android app using Kotlin and Jetpack Compose for the entire
user interface, instead of the older XML layout system. I chose Compose
because it made it easier to build a UI that adjusts to different screen
sizes and rotations without hardcoding sizes.

For the app structure, I used the MVVM pattern (Model-View-ViewModel),
which is a close cousin of MVC:

- Model layer: simple Kotlin data classes that describe the shape of data,
  like Job, Contract, or UserProfileData. These files have no logic inside
  them.
- Repository layer: files like JobRepository, ClientRepository, and
  ContractRepository. These are the only files allowed to talk to Supabase
  directly.
- ViewModel layer: one ViewModel per screen. This is where I kept the
  screen's state (loading, success, error) and the logic for what happens
  when a button is pressed.
- View layer: the actual Compose screens. These only display what the
  ViewModel gives them, they do not call the database directly.

I followed the same order every time I added a new feature: Model first,
then Repository, then ViewModel, then the Screen.

For navigation between screens, I used Jetpack Navigation Compose, with one
central file that lists every screen as a route.

For the machine learning part, the trained scikit-learn model was converted
to plain Java code, which Kotlin can call directly since Android supports
mixing Java and Kotlin in the same project. This means the model prediction
happens with zero network calls.

The final app is exported as a signed APK for installation and testing,
since a student academic project does not need to be published on the Play
Store.

====================================================
CHALLENGES FACED
====================================================

1. Mismatched original design documents
   My original planning documents described the database using Firestore
   language, but the actual schema I had already written was in PostgreSQL
   format. I had to catch this early and commit fully to Supabase, since
   Firestore does not support foreign keys or the kind of relational queries
   my schema needed.

2. Gradle and toolchain issues
   Since I used a very recent version of Android Studio, I ran into some new
   changes I did not expect at first, like AGP 9 no longer needing a
   separate Kotlin plugin, and a known Gradle Kotlin DSL bug where writing
   java.util.Properties() directly does not work and needs a proper import
   statement instead. I also had to raise my compileSdk version because one
   of my dependencies required a newer Android API level than I had set.

3. Missing Row Level Security policies
   A few times, a table had RLS turned on but was missing a specific policy
   (for example, insert policies on the users and assessment_questions
   tables). Since RLS blocks everything by default with no policy, this
   caused queries to silently return zero rows instead of a clear error,
   which took some investigation to track down.

4. Keeping the ML model small enough for mobile
   My first trained model (100 trees) converted into a Java file that was
   almost 7 million characters long, which is far too large for a mobile
   app and would likely have failed to compile. I had to reduce the forest
   size to 20 trees and a smaller depth, which brought the file down to a
   reasonable size while keeping the accuracy around 92%.

5. Navigation and state bugs from copy-paste
   A few bugs came from partially applied changes, like a route still
   pointing to a placeholder pattern such as "{contractId}" instead of the
   real value, or a screen not refreshing its data after coming back from
   another screen. These were tricky because the app would run without
   crashing at first, and only show a problem in a specific user flow, so I
   had to test each feature from both the freelancer and client side to
   catch them.

6. Designing the "hire" action safely
   Hiring a freelancer needed to update four different things at once
   (accept one proposal, reject the others, update the job, and create the
   contract). Doing this as separate steps from the app was risky, since a
   failure halfway through could leave the data inconsistent. I solved this
   by moving that logic into a single database function instead of handling
   it purely in the app.

Overall, this project taught me how to connect a full Android app to a real
relational backend, how to bring a trained machine learning model into a
mobile app without any server calls, and how important it is to test every
user flow from both roles, not just one, since some bugs only show up when
two different users interact with the same data at the same time.