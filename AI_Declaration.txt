CSE489-Final Project

Student Name: MD. SHIHAB SHARAR
ID: 22241028

====================================================
AI USAGE STATEMENT
====================================================

For this project, I used Claude (by Anthropic) as an AI assistant throughout
the development of CareerCraft. I want to explain honestly how I used it and
what my own role was in the process.

I started by giving Claude a full description of my idea, including the app
concept, the database design I had already drafted, the page structure I
wanted, and the machine learning idea behind the career discovery feature.
This context is what let Claude actually understand my vision and help me
turn it into a working plan, instead of just guessing what I wanted. Early
on, Claude also pointed out a real problem in my own planning documents,
that I had described the database using Firestore language while the
schema I had written was actually in PostgreSQL format. This helped me lock
in one consistent backend before any real coding started.

Before building anything, Claude and I went back and forth with questions
and answers to clear up decisions I was not fully sure about, like which
backend to use, how to structure the Android project, and how to handle the
machine learning model on a phone without needing internet access. I made
the final calls on these decisions, but Claude helped me understand the
trade-offs of each option so I could choose properly.

After the planning was settled, we did not build the whole app at once.
Instead, we worked through it in small segments, one feature at a time,
starting with the database, then authentication, then onboarding, then the
freelancer side, then the client side, then contracts and chat, and finally
portfolio. For every segment, Claude gave me the code, I added it into my
own project in Android Studio, and I actually ran and tested it myself
before we moved to the next part. Several times, something did not work
correctly on the first try, for example a Gradle build error, a missing
database policy, or a navigation bug, and I reported the exact error message
back to Claude so we could find the real cause instead of guessing. This
back-and-forth testing process happened after almost every feature, which is
how I made sure the app was actually working and not just written.

Claude also helped me generate the app's wireframes in Figma, train and
convert the machine learning model, and prepare supporting documents like
this one and my presentation materials.

To summarize, my own role was providing the original idea, the requirements,
the final decisions, and the actual hands-on testing of every feature inside
Android Studio. Claude's role was helping me design the architecture, writing
the code based on what I asked for, answering my technical questions, and
helping me debug issues using the real error logs I provided. I did not just
copy code without understanding it, I reviewed and tested each part of the
app myself before accepting it as done.