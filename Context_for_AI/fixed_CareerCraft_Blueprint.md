# CareerCraft — App Blueprint (v2, Locked Tech Stack)

## 0. What Changed From v1

The original draft mixed two incompatible backends: the database schema was written in PostgreSQL/Supabase style (`UUID`, `CHECK` constraints, foreign keys, SQL views, RLS policies using `auth.uid()`), while the page-flow sections referred to "Firestore" throughout. This version resolves that conflict and locks in one consistent stack, decided as follows:

| Layer | Decision |
|---|---|
| Frontend | Kotlin + **Jetpack Compose** (not XML/View system) |
| Backend / Database | **Supabase** (PostgreSQL, Auth, Storage, Realtime) — matches the schema as originally written |
| ML Inference | scikit-learn **Random Forest → m2cgen → native Kotlin**, zero network latency, no TensorFlow Lite conversion step |
| Distribution | **Signed APK export**, shared directly / via Firebase App Distribution — no formal "web hosting" needed for an Android app |

Reasoning recap: Firebase's Cloud Storage was removed from its free Spark plan in February 2026 and now requires a credit-card-linked Blaze plan even for $0 usage — which conflicts with the "free of cost" requirement given the app must store user images. Supabase Storage remains free with no card required, and its Postgres backend requires zero rework of the schema already designed. Everything below assumes this stack.

---

## 1. Project Overview

CareerCraft is an Android app for freelance career discovery. Instead of dropping users straight into a job marketplace, it first helps **beginner** freelancers figure out which of four broad career paths suits them (Technology & Remote Work, Creative & Design, Physical & Labor, Service & Public Facing), using a short on-device questionnaire and a locally trained classifier. **Expert** freelancers skip the questionnaire and pick categories directly. Once a path is chosen, a Smart Job Feed prioritizes matching jobs. Clients post jobs, review proposals, and hire; once hired, a contract locks in messaging (auto-read-only on completion) and a mutual −10 to +10 rating system.

This is an academic-scope project: one Android client app (Kotlin/Compose), one Supabase project as the backend, a locally trained ML component bundled into the APK, and no cost beyond developer time.

---

## 2. User Roles & Core Flow

- **Freelancer — Beginner**: Sign up → Visual Skill Assessment (10 questions) → on-device model prediction → top 3 job suggestions with match % → accept or override → Freelancer Dashboard.
- **Freelancer — Expert**: Sign up → manual Category Selection → Freelancer Dashboard.
- **Client**: Sign up → Client Dashboard → post jobs → review proposals → hire → contract → chat → mutual completion → rating.

Full navigation trees, per-screen field lists, button colors, and validation rules carry over unchanged from the original spec (Sections 1–6 of the source document) — only the underlying implementation technology changes, not the UX. Keep those sections as your UI reference; nothing in them assumed Firestore or XML specifically.

---

## 3. Database Architecture (Supabase / PostgreSQL)

The schema below is unchanged from the original design — it was already valid PostgreSQL and needs no rewrite, only a Supabase project to run it in.

```sql
-- ============================================
-- CAREERCRAFT — COMPLETE DATABASE SCHEMA (Supabase / Postgres)
-- ============================================

-- 1. USERS TABLE
CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email TEXT UNIQUE NOT NULL,
    display_name TEXT NOT NULL,
    photo_url TEXT,
    role TEXT NOT NULL CHECK (role IN ('freelancer', 'client')),
    user_type TEXT NOT NULL CHECK (user_type IN ('beginner', 'expert')),
    bio TEXT,
    skills TEXT[],
    rating_score DECIMAL(3,1) DEFAULT 0.0 CHECK (rating_score >= -10 AND rating_score <= 10),
    total_reviews INTEGER DEFAULT 0,
    selected_categories TEXT[],
    assessment_completed BOOLEAN DEFAULT FALSE,
    predicted_class INTEGER CHECK (predicted_class BETWEEN 0 AND 3),
    career_path TEXT,
    profile_complete BOOLEAN DEFAULT FALSE,
    profile_percent INTEGER DEFAULT 0 CHECK (profile_percent BETWEEN 0 AND 100),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- 2. ASSESSMENT QUESTIONS TABLE
CREATE TABLE assessment_questions (
    question_id SERIAL PRIMARY KEY,
    question TEXT NOT NULL,
    type TEXT NOT NULL CHECK (type IN ('slider', 'multiple_choice')),
    min_value INTEGER,
    max_value INTEGER,
    feature_mapping TEXT NOT NULL,
    icon TEXT,
    options TEXT[],
    display_order INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);

-- 3. JOBS TABLE
CREATE TABLE jobs (
    job_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    client_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    title TEXT NOT NULL,
    category TEXT NOT NULL CHECK (category IN ('Technology', 'Creative', 'Physical', 'Service')),
    description TEXT NOT NULL,
    required_skills TEXT[] NOT NULL,
    pay_min DECIMAL(10,2) NOT NULL,
    pay_max DECIMAL(10,2) NOT NULL,
    duration TEXT NOT NULL,
    location_type TEXT NOT NULL CHECK (location_type IN ('Remote', 'Hybrid', 'On-site')),
    location TEXT,
    status TEXT DEFAULT 'open' CHECK (status IN ('open', 'in-progress', 'completed', 'cancelled')),
    deadline TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- 4. PROPOSALS TABLE
CREATE TABLE proposals (
    proposal_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    job_id UUID NOT NULL REFERENCES jobs(job_id) ON DELETE CASCADE,
    freelancer_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    cover_letter TEXT NOT NULL,
    proposed_rate DECIMAL(10,2) NOT NULL,
    estimated_timeline TEXT NOT NULL,
    portfolio_items TEXT[],
    status TEXT DEFAULT 'pending' CHECK (status IN ('pending', 'accepted', 'rejected', 'withdrawn')),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(job_id, freelancer_id)
);

-- 5. CONTRACTS TABLE
CREATE TABLE contracts (
    contract_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    job_id UUID NOT NULL REFERENCES jobs(job_id) ON DELETE CASCADE,
    proposal_id UUID NOT NULL REFERENCES proposals(proposal_id) ON DELETE CASCADE,
    freelancer_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    client_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    status TEXT DEFAULT 'active' CHECK (status IN ('active', 'completed', 'read-only', 'archived')),
    start_date TIMESTAMP DEFAULT NOW(),
    completion_date TIMESTAMP,
    duration TEXT NOT NULL,
    pay_amount DECIMAL(10,2) NOT NULL,
    chat_active BOOLEAN DEFAULT TRUE,
    freelancer_completed BOOLEAN DEFAULT FALSE,
    client_completed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- 6. MESSAGES TABLE
CREATE TABLE messages (
    message_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_id UUID NOT NULL REFERENCES contracts(contract_id) ON DELETE CASCADE,
    sender_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    receiver_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    content TEXT NOT NULL,
    read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW()
);

-- 7. PORTFOLIO TABLE
CREATE TABLE portfolio (
    portfolio_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    freelancer_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    title TEXT NOT NULL,
    category TEXT NOT NULL,
    description TEXT,
    images TEXT[] NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- 8. REVIEWS TABLE
CREATE TABLE reviews (
    review_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_id UUID NOT NULL REFERENCES contracts(contract_id) ON DELETE CASCADE,
    reviewer_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    reviewee_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    rating INTEGER NOT NULL CHECK (rating >= -10 AND rating <= 10),
    feedback TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(contract_id, reviewer_id)
);

-- 9. NOTIFICATIONS TABLE
CREATE TABLE notifications (
    notification_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    type TEXT NOT NULL CHECK (type IN ('proposal', 'acceptance', 'rejection', 'message', 'completion', 'rating')),
    title TEXT NOT NULL,
    body TEXT NOT NULL,
    data JSONB,
    read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================
-- INDEXES
-- ============================================
CREATE INDEX idx_users_role ON users(role);
CREATE INDEX idx_users_rating ON users(rating_score);
CREATE INDEX idx_jobs_client ON jobs(client_id);
CREATE INDEX idx_jobs_category ON jobs(category);
CREATE INDEX idx_jobs_status ON jobs(status);
CREATE INDEX idx_jobs_deadline ON jobs(deadline);
CREATE INDEX idx_proposals_job ON proposals(job_id);
CREATE INDEX idx_proposals_freelancer ON proposals(freelancer_id);
CREATE INDEX idx_proposals_status ON proposals(status);
CREATE INDEX idx_contracts_freelancer ON contracts(freelancer_id);
CREATE INDEX idx_contracts_client ON contracts(client_id);
CREATE INDEX idx_contracts_status ON contracts(status);
CREATE INDEX idx_messages_contract ON messages(contract_id);
CREATE INDEX idx_messages_sender ON messages(sender_id);
CREATE INDEX idx_messages_receiver ON messages(receiver_id);
CREATE INDEX idx_messages_created ON messages(created_at);
CREATE INDEX idx_reviews_reviewee ON reviews(reviewee_id);
CREATE INDEX idx_reviews_reviewer ON reviews(reviewer_id);
CREATE INDEX idx_reviews_rating ON reviews(rating);
CREATE INDEX idx_notifications_user ON notifications(user_id);
CREATE INDEX idx_notifications_read ON notifications(read);

-- ============================================
-- TRIGGERS
-- ============================================
CREATE OR REPLACE FUNCTION update_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_users_updated_at BEFORE UPDATE ON users FOR EACH ROW EXECUTE FUNCTION update_updated_at();
CREATE TRIGGER update_jobs_updated_at BEFORE UPDATE ON jobs FOR EACH ROW EXECUTE FUNCTION update_updated_at();
CREATE TRIGGER update_proposals_updated_at BEFORE UPDATE ON proposals FOR EACH ROW EXECUTE FUNCTION update_updated_at();
CREATE TRIGGER update_contracts_updated_at BEFORE UPDATE ON contracts FOR EACH ROW EXECUTE FUNCTION update_updated_at();
CREATE TRIGGER update_portfolio_updated_at BEFORE UPDATE ON portfolio FOR EACH ROW EXECUTE FUNCTION update_updated_at();

-- RATING UPDATE TRIGGER
CREATE OR REPLACE FUNCTION update_user_rating()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE users
    SET
        rating_score = (SELECT AVG(rating)::DECIMAL(3,1) FROM reviews WHERE reviewee_id = NEW.reviewee_id),
        total_reviews = (SELECT COUNT(*) FROM reviews WHERE reviewee_id = NEW.reviewee_id)
    WHERE user_id = NEW.reviewee_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_rating_after_review AFTER INSERT ON reviews FOR EACH ROW EXECUTE FUNCTION update_user_rating();

-- CONTRACT COMPLETION FUNCTION
CREATE OR REPLACE FUNCTION complete_contract(contract_id_param UUID)
RETURNS VOID AS $$
DECLARE
    contract_record contracts%ROWTYPE;
BEGIN
    SELECT * INTO contract_record FROM contracts WHERE contract_id = contract_id_param;
    IF contract_record.freelancer_completed AND contract_record.client_completed THEN
        UPDATE contracts
        SET status = 'completed', completion_date = NOW(), chat_active = FALSE
        WHERE contract_id = contract_id_param;
    END IF;
END;
$$ LANGUAGE plpgsql;

-- NOTIFICATION CLEANUP FUNCTION
CREATE OR REPLACE FUNCTION archive_old_notifications()
RETURNS VOID AS $$
BEGIN
    DELETE FROM notifications WHERE created_at < NOW() - INTERVAL '30 days' AND read = TRUE;
END;
$$ LANGUAGE plpgsql;

-- ============================================
-- VIEWS
-- ============================================
CREATE VIEW freelancer_profiles AS
SELECT u.user_id, u.display_name, u.photo_url, u.bio, u.skills, u.rating_score, u.total_reviews,
       u.career_path, u.profile_percent,
       COUNT(DISTINCT p.portfolio_id) as portfolio_count,
       COUNT(DISTINCT c.contract_id) as total_contracts
FROM users u
LEFT JOIN portfolio p ON u.user_id = p.freelancer_id
LEFT JOIN contracts c ON u.user_id = c.freelancer_id
WHERE u.role = 'freelancer'
GROUP BY u.user_id;

CREATE VIEW active_contracts AS
SELECT c.contract_id, c.job_id, j.title as job_title, c.freelancer_id, f.display_name as freelancer_name,
       c.client_id, cl.display_name as client_name, c.start_date, c.duration, c.pay_amount, c.status
FROM contracts c
JOIN jobs j ON c.job_id = j.job_id
JOIN users f ON c.freelancer_id = f.user_id
JOIN users cl ON c.client_id = cl.user_id
WHERE c.status IN ('active', 'in-progress');

CREATE VIEW job_details_with_applicants AS
SELECT j.job_id, j.title, j.client_id, u.display_name as client_name, j.category, j.pay_min, j.pay_max,
       j.duration, j.location_type, j.status,
       COUNT(p.proposal_id) as total_applicants,
       COUNT(CASE WHEN p.status = 'pending' THEN 1 END) as pending_applicants,
       COUNT(CASE WHEN p.status = 'accepted' THEN 1 END) as accepted_applicants
FROM jobs j
LEFT JOIN proposals p ON j.job_id = p.job_id
JOIN users u ON j.client_id = u.user_id
GROUP BY j.job_id, j.title, j.client_id, u.display_name, j.category, j.pay_min, j.pay_max, j.duration, j.location_type, j.status;

-- ============================================
-- ROW LEVEL SECURITY (Supabase)
-- ============================================
ALTER TABLE users ENABLE ROW LEVEL SECURITY;
ALTER TABLE jobs ENABLE ROW LEVEL SECURITY;
ALTER TABLE proposals ENABLE ROW LEVEL SECURITY;
ALTER TABLE contracts ENABLE ROW LEVEL SECURITY;
ALTER TABLE messages ENABLE ROW LEVEL SECURITY;
ALTER TABLE portfolio ENABLE ROW LEVEL SECURITY;
ALTER TABLE reviews ENABLE ROW LEVEL SECURITY;
ALTER TABLE notifications ENABLE ROW LEVEL SECURITY;
ALTER TABLE assessment_questions ENABLE ROW LEVEL SECURITY;

CREATE POLICY users_select_policy ON users FOR SELECT USING (true);
CREATE POLICY users_update_policy ON users FOR UPDATE USING (auth.uid() = user_id);

CREATE POLICY jobs_select_policy ON jobs FOR SELECT USING (true);
CREATE POLICY jobs_insert_policy ON jobs FOR INSERT WITH CHECK (auth.uid() = client_id);
CREATE POLICY jobs_update_policy ON jobs FOR UPDATE USING (auth.uid() = client_id);

CREATE POLICY proposals_select_policy ON proposals FOR SELECT USING (true);
CREATE POLICY proposals_insert_policy ON proposals FOR INSERT WITH CHECK (auth.uid() = freelancer_id);
CREATE POLICY proposals_update_policy ON proposals FOR UPDATE USING (
    auth.uid() = freelancer_id OR auth.uid() IN (SELECT client_id FROM jobs WHERE job_id = proposals.job_id)
);

CREATE POLICY contracts_select_policy ON contracts FOR SELECT USING (auth.uid() = freelancer_id OR auth.uid() = client_id);
CREATE POLICY contracts_update_policy ON contracts FOR UPDATE USING (auth.uid() = freelancer_id OR auth.uid() = client_id);

CREATE POLICY messages_select_policy ON messages FOR SELECT USING (auth.uid() = sender_id OR auth.uid() = receiver_id);
CREATE POLICY messages_insert_policy ON messages FOR INSERT WITH CHECK (auth.uid() = sender_id);

CREATE POLICY portfolio_select_policy ON portfolio FOR SELECT USING (true);
CREATE POLICY portfolio_insert_policy ON portfolio FOR INSERT WITH CHECK (auth.uid() = freelancer_id);
CREATE POLICY portfolio_update_policy ON portfolio FOR UPDATE USING (auth.uid() = freelancer_id);

CREATE POLICY reviews_select_policy ON reviews FOR SELECT USING (true);
CREATE POLICY reviews_insert_policy ON reviews FOR INSERT WITH CHECK (auth.uid() = reviewer_id);

CREATE POLICY notifications_select_policy ON notifications FOR SELECT USING (auth.uid() = user_id);
CREATE POLICY notifications_update_policy ON notifications FOR UPDATE USING (auth.uid() = user_id);

CREATE POLICY assessment_questions_select_policy ON assessment_questions FOR SELECT USING (true);
```

**Auth note:** `auth.uid()` is populated automatically by Supabase Auth once a user signs in — no manual wiring needed, it comes from the JWT Supabase issues.

---

## 4. Image & File Handling — Supabase Storage

- Create two Storage buckets: `avatars` (profile photos) and `portfolio-images` (portfolio galleries, job-related attachments if needed later).
- Bucket-level policies mirror the table RLS: a user can upload/overwrite only their own avatar; portfolio images are publicly readable but writable only by their owning `freelancer_id`.
- Store only the returned public/signed URL string in the relevant `TEXT` / `TEXT[]` column (`photo_url`, `images`) — never store binary blobs in the database itself.
- Client-side: compress/resize images before upload (keeps you comfortably inside the 1 GB free storage and 5 GB egress caps).

---

## 5. App Structure — Jetpack Compose

Replace every "Screen" from the original navigation spec with a `@Composable` function, driven by **Navigation Compose** (`NavHost` + `NavController`) rather than Activity/Fragment navigation. Suggested top-level composables (catchy, purpose-clear naming):

| Composable | Purpose |
|---|---|
| `SplashGate` | Auth check → routes to `LoginScreen` or role dashboard |
| `LoginScreen`, `SignUpScreen` | Supabase Auth email/password + Google OAuth |
| `RoleSelectScreen` | Freelancer vs Client |
| `ExperienceLevelScreen` | Beginner vs Expert |
| `SkillAssessmentFlow` | Card-based Q&A, one composable per question type (`SliderQuestionCard`, `ChipQuestionCard`) |
| `CareerMatchResultsScreen` | Top-3 results from the on-device model |
| `CategoryPickerScreen` | Manual category selection (expert path + override path) |
| `FreelancerHomeScreen`, `ClientHomeScreen` | Dashboards |
| `SmartJobFeedScreen`, `JobDetailScreen`, `ProposalFormScreen`, `MyProposalsScreen` | Freelancer job flow |
| `PostJobScreen`, `MyJobsScreen`, `JobApplicantsScreen` | Client job flow |
| `ContractDetailScreen`, `ChatScreen`, `ChatListScreen` | Contract + messaging |
| `PortfolioGridScreen`, `PortfolioFormScreen` | Portfolio management |
| `RatingScreen`, `NotificationCenterScreen`, `ProfileSettingsScreen` | Shared |

Use `WindowSizeClass` / adaptive layouts (not fixed `dp` breakpoints) so layouts reflow instead of hard-coding phone-only dimensions — this satisfies the "flexible, not hardcoded" and "any screen size / rotation" requirements directly.

Color tokens (single source of truth, e.g. `Color.kt`): `Orange #FF6B00` (primary actions), `White #FFFFFF`, `Grey #9E9E9E`, `Black #000000`, `Red #D32F2F` (destructive only).

---

## 6. ML System — On-Device Inference via m2cgen

**Training (offline, on your dev machine, not on the phone):**
1. Generate/curate the 4,000-sample synthetic dataset (1,000 per class, 10 features) exactly as originally designed.
2. Train a `RandomForestClassifier` (scikit-learn) — 100 trees, 80/20 train-test split, as originally planned.
3. Validate on the held-out 20% test set; confirm balanced accuracy across all 4 classes.
4. Run **m2cgen** against the trained model to transpile it directly into a Kotlin file, e.g.:
   ```bash
   pip install m2cgen
   python -c "import m2cgen as m2c, joblib; \
       model = joblib.load('career_rf_model.pkl'); \
       print(m2c.export_to_kotlin(model))" > CareerModel.kt
   ```
5. Drop the generated `CareerModel.kt` into the app's `ml/` package. It exposes a plain function (feature array in → class probabilities out) with **no external ML runtime dependency** — no TensorFlow Lite `.tflite` file, no interpreter, no model-loading step, no conversion-fidelity risk.

**Runtime (on-device):**
- `SkillAssessmentFlow` collects the 10 answers → `FeatureVectorBuilder` maps them (with the same categorical encodings used in training) into a `DoubleArray` → passed straight into the generated `CareerModel` function → returns class probabilities → top-3 job titles + match % displayed on `CareerMatchResultsScreen`.
- This is genuinely zero-latency and fully offline, since the "model" is now just compiled Kotlin arithmetic, not a loaded ML artifact.

**Fallback:** keep the rule-based scoring system from the original design as a secondary code path — useful for testing/demo purposes and as a documented "graceful degradation" story, even though m2cgen removes the original failure mode (TFLite failing to load) it was meant to guard against.

**Write-up framing:** you can accurately describe this as "a Random Forest classifier trained on a custom 4,000-sample dataset, compiled to native code for on-device inference" — which satisfies the academic goal of demonstrating a trained model running inside the app without the TFLite conversion risk.

---

## 7. Distribution Plan — Signed APK

No web hosting is needed for the app itself (only Supabase needs to be "hosted," and that's managed for you). Steps:

1. In Android Studio: **Build → Generate Signed App Bundle / APK**, choose APK, create a new keystore (keep it — you'll need the same one for any future update).
2. Select `release` build variant, ensure `minifyEnabled`/R8 is configured sensibly for a project this size (can leave off if it complicates debugging).
3. Output APK can be:
   - Shared directly as a file (email/drive link) for grading/demo, or
   - Uploaded to **Firebase App Distribution** (free, unrelated to the Storage billing change) so testers install via a link without manual sideloading, or
   - Installed straight from Android Studio onto a connected device/emulator for live demonstration.
4. Play Store listing is optional and not required for an academic submission; it costs a one-time $25 if you ever want it.

---

## 8. Supabase Project — Setup & Maintenance Notes

- Create the project at supabase.com (free tier: 500 MB database, 1 GB file storage, 50K MAU, no card required).
- Run the schema in Section 3 via the SQL editor.
- Free-tier projects **auto-pause after 7 days with no database requests**. Set up one lightweight keep-alive so it's never paused during development or grading:
  - A GitHub Actions scheduled workflow (every 3–4 days) that hits any table via the REST API, **or**
  - An UptimeRobot monitor pinging your Supabase REST endpoint.
- Stay aware of the 500 MB database / 1 GB storage ceiling — comfortably enough for an academic-scope dataset, but compress portfolio images client-side before upload to conserve it.

---

## 9. File & Folder Naming Conventions

Keep names short, purpose-evident, and consistently cased. Suggested top-level structure:

```
app/
 ├─ ui/
 │   ├─ auth/          (LoginScreen.kt, SignUpScreen.kt, RoleSelectScreen.kt)
 │   ├─ assessment/     (SkillAssessmentFlow.kt, SliderQuestionCard.kt, ChipQuestionCard.kt)
 │   ├─ dashboard/      (FreelancerHomeScreen.kt, ClientHomeScreen.kt)
 │   ├─ jobs/           (SmartJobFeedScreen.kt, JobDetailScreen.kt, PostJobScreen.kt)
 │   ├─ contracts/      (ContractDetailScreen.kt, ChatScreen.kt)
 │   ├─ portfolio/      (PortfolioGridScreen.kt, PortfolioFormScreen.kt)
 │   └─ theme/          (Color.kt, Type.kt, Theme.kt)
 ├─ ml/                 (CareerModel.kt — generated by m2cgen, FeatureVectorBuilder.kt)
 ├─ data/
 │   ├─ supabase/       (SupabaseClient.kt, AuthRepository.kt, JobsRepository.kt, ...)
 │   └─ models/         (UserProfile.kt, Job.kt, Contract.kt, ...)
 └─ navigation/         (NavGraph.kt)
```

A separate `PROJECT_FILE_GUIDE.md` documenting what each file does (including the Supabase connection/config file) should be written once implementation is underway — this blueprint is the pre-build reference; the file guide is the post-build one you mentioned wanting.

---

## 10. Summary of Locked Decisions

- **Backend:** Supabase (Postgres, Auth, Storage, Realtime) — free, no card, matches the existing schema exactly.
- **Frontend:** Kotlin + Jetpack Compose, adaptive layouts for rotation/screen-size flexibility.
- **ML:** scikit-learn Random Forest → m2cgen → native Kotlin, zero-latency, no TFLite.
- **Distribution:** Signed APK, shared directly or via Firebase App Distribution.
- **Ongoing cost:** $0, provided the Supabase keep-alive ping is in place.

This document supersedes the tech-stack contradictions in the original draft. Everything else in the original file (UI copy, page-by-page field lists, navigation trees, dataset feature tables, color coding) remains valid as-is and doesn't need to change.
