## CareerCraft — Android Freelancing Platform

**Overview:** Developed a full-stack Android freelancing marketplace app that connects clients with freelancers through an ML-powered career discovery system, featuring dual user roles, smart job matching, contract management, and a dummy payment gateway.

**Tech Stack:**
- **Language:** Kotlin
- **Frontend:** Jetpack Compose (declarative UI), Navigation Compose, Material 3, Coil (image loading)
- **Backend:** Supabase (PostgreSQL, Auth, Storage, Realtime), Row-Level Security (RLS) policies
- **ML:** scikit-learn Random Forest classifier transpiled to native Kotlin via m2cgen for on-device, zero-latency career prediction
- **Architecture:** MVVM (Model-View-ViewModel) with Repository pattern and Kotlin Coroutines/Flow
- **Tools:** Android Studio, Gradle (Kotlin DSL), Git, Supabase SQL Editor

**Key Features:**
- On-device ML career assessment with 4-class prediction for beginner freelancers
- Dual dashboards (Freelancer/Client) with role-based flows
- Smart Job Feed with category-based prioritization
- Full contract lifecycle: proposals → hiring → chat → completion → mutual rating
- Real-time text chat with profile pictures and public profile integration
- Public profiles with bio, skills, portfolio, reviews, and contact info
- Dummy VISA/MasterCard payment system with Luhn validation and transaction history
- Portfolio management with Supabase Storage image uploads
- 10-point mutual rating system with automated score updates via PostgreSQL triggers

