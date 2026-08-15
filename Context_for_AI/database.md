# Supabase Schema Diagram Setup Guide

## Step-by-Step Instructions

## Step 1: Set Up Supabase Project

---

## Step 2: Access SQL Editor

1. Once project is ready, click **"SQL Editor"** in left sidebar
2. Click **"New Query"** button
3. You'll see a blank SQL editor

---

## Step 3: Create All Tables

Copy and paste this SQL script into the editor:

```sql
-- ============================================
-- CAREERCRAFT - COMPLETE SCHEMA
-- All tables with relationships
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
-- CREATE INDEXES FOR PERFORMANCE
-- ============================================

-- Users indexes
CREATE INDEX idx_users_role ON users(role);
CREATE INDEX idx_users_rating ON users(rating_score);

-- Jobs indexes
CREATE INDEX idx_jobs_client ON jobs(client_id);
CREATE INDEX idx_jobs_category ON jobs(category);
CREATE INDEX idx_jobs_status ON jobs(status);
CREATE INDEX idx_jobs_deadline ON jobs(deadline);

-- Proposals indexes
CREATE INDEX idx_proposals_job ON proposals(job_id);
CREATE INDEX idx_proposals_freelancer ON proposals(freelancer_id);
CREATE INDEX idx_proposals_status ON proposals(status);

-- Contracts indexes
CREATE INDEX idx_contracts_freelancer ON contracts(freelancer_id);
CREATE INDEX idx_contracts_client ON contracts(client_id);
CREATE INDEX idx_contracts_status ON contracts(status);

-- Messages indexes
CREATE INDEX idx_messages_contract ON messages(contract_id);
CREATE INDEX idx_messages_sender ON messages(sender_id);
CREATE INDEX idx_messages_receiver ON messages(receiver_id);
CREATE INDEX idx_messages_created ON messages(created_at);

-- Reviews indexes
CREATE INDEX idx_reviews_reviewee ON reviews(reviewee_id);
CREATE INDEX idx_reviews_reviewer ON reviews(reviewer_id);
CREATE INDEX idx_reviews_rating ON reviews(rating);

-- Notifications indexes
CREATE INDEX idx_notifications_user ON notifications(user_id);
CREATE INDEX idx_notifications_read ON notifications(read);

-- ============================================
-- TRIGGERS FOR UPDATED_AT
-- ============================================

-- Function to update timestamp
CREATE OR REPLACE FUNCTION update_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Apply triggers
CREATE TRIGGER update_users_updated_at
    BEFORE UPDATE ON users
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER update_jobs_updated_at
    BEFORE UPDATE ON jobs
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER update_proposals_updated_at
    BEFORE UPDATE ON proposals
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER update_contracts_updated_at
    BEFORE UPDATE ON contracts
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at();

CREATE TRIGGER update_portfolio_updated_at
    BEFORE UPDATE ON portfolio
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at();

-- ============================================
-- INSERT SAMPLE DATA
-- ============================================

-- Sample Assessment Questions
INSERT INTO assessment_questions (question, type, min_value, max_value, feature_mapping, icon, display_order) VALUES
('How comfortable are you with technology and computers?', 'slider', 1, 10, 'technical_aptitude', 'computer', 1),
('How would you rate your communication skills?', 'slider', 1, 10, 'communication_skill', 'chat', 2),
('Do you prefer working alone or in teams?', 'slider', 1, 10, 'prefers_team_work', 'people', 3),
('How important is physical activity in your daily work?', 'slider', 1, 10, 'physical_endurance', 'fitness', 4),
('Do you enjoy working outdoors?', 'slider', 1, 10, 'prefers_outdoor_work', 'sunny', 5),
('How many hours can you dedicate daily?', 'slider', 1, 12, 'preferred_hours_per_day', 'clock', 6),
('What is your highest qualification?', 'multiple_choice', NULL, NULL, 'qualification_level', 'school', 7),
('Where do you prefer to work?', 'multiple_choice', NULL, NULL, 'work_location_preference', 'location', 8),
('What is your salary expectation?', 'multiple_choice', NULL, NULL, 'salary_expectation', 'money', 9);

-- Sample Users
INSERT INTO users (email, display_name, role, user_type, bio, skills, rating_score, profile_complete, profile_percent) VALUES
('client1@example.com', 'John Client', 'client', 'expert', 'Hiring manager looking for talent', ARRAY['Hiring', 'Management'], 8.5, TRUE, 100),
('freelancer1@example.com', 'Jane Developer', 'freelancer', 'beginner', 'Passionate about coding', ARRAY['Java', 'Python', 'Android'], 7.2, TRUE, 100),
('freelancer2@example.com', 'Mike Designer', 'freelancer', 'expert', 'UI/UX designer with 5 years experience', ARRAY['Figma', 'Photoshop', 'Sketch'], 9.1, TRUE, 100);

-- Sample Job
INSERT INTO jobs (client_id, title, category, description, required_skills, pay_min, pay_max, duration, location_type, status) VALUES
((SELECT user_id FROM users WHERE email = 'client1@example.com'), 
 'Android App Development', 
 'Technology', 
 'We need an experienced Android developer to build a freelance marketplace app. The app should have user authentication, job posting, real-time messaging, and rating system.', 
 ARRAY['Java', 'Android Studio', 'Firebase'], 
 2000.00, 3500.00, 
 '3 months', 
 'Remote', 
 'open');

-- Sample Proposal
INSERT INTO proposals (job_id, freelancer_id, cover_letter, proposed_rate, estimated_timeline, status) VALUES
((SELECT job_id FROM jobs LIMIT 1),
 (SELECT user_id FROM users WHERE email = 'freelancer1@example.com'),
 'I have 3 years of Android development experience. I''ve built multiple apps with Firebase integration. I can deliver this project within the timeline.',
 2800.00,
 '2.5 months',
 'pending');

-- Sample Contract
INSERT INTO contracts (job_id, proposal_id, freelancer_id, client_id, duration, pay_amount, status) VALUES
((SELECT job_id FROM jobs LIMIT 1),
 (SELECT proposal_id FROM proposals LIMIT 1),
 (SELECT user_id FROM users WHERE email = 'freelancer1@example.com'),
 (SELECT user_id FROM users WHERE email = 'client1@example.com'),
 '3 months',
 2800.00,
 'active');

-- Sample Message
INSERT INTO messages (contract_id, sender_id, receiver_id, content) VALUES
((SELECT contract_id FROM contracts LIMIT 1),
 (SELECT user_id FROM users WHERE email = 'client1@example.com'),
 (SELECT user_id FROM users WHERE email = 'freelancer1@example.com'),
 'Welcome to the project! Let me know if you have any questions.');

-- Sample Portfolio
INSERT INTO portfolio (freelancer_id, title, category, description, images) VALUES
((SELECT user_id FROM users WHERE email = 'freelancer1@example.com'),
 'E-Commerce App',
 'Mobile Development',
 'Built a full-featured e-commerce app with payment integration',
 ARRAY['https://via.placeholder.com/400', 'https://via.placeholder.com/400']);

-- Sample Review
INSERT INTO reviews (contract_id, reviewer_id, reviewee_id, rating, feedback) VALUES
((SELECT contract_id FROM contracts LIMIT 1),
 (SELECT user_id FROM users WHERE email = 'client1@example.com'),
 (SELECT user_id FROM users WHERE email = 'freelancer1@example.com'),
 8,
 'Excellent work, highly recommend!');

-- Sample Notification
INSERT INTO notifications (user_id, type, title, body, data) VALUES
((SELECT user_id FROM users WHERE email = 'freelancer1@example.com'),
 'acceptance',
 'You''ve been hired!',
 'Congratulations! You''ve been selected for the Android App Development project.',
 '{"jobId": "sample-job-id", "contractId": "sample-contract-id"}');

-- ============================================
-- VIEWS FOR COMMON QUERIES
-- ============================================

-- View: Freelancer Profile with Rating
CREATE VIEW freelancer_profiles AS
SELECT 
    u.user_id,
    u.display_name,
    u.photo_url,
    u.bio,
    u.skills,
    u.rating_score,
    u.total_reviews,
    u.career_path,
    u.profile_percent,
    COUNT(DISTINCT p.portfolio_id) as portfolio_count,
    COUNT(DISTINCT c.contract_id) as total_contracts
FROM users u
LEFT JOIN portfolio p ON u.user_id = p.freelancer_id
LEFT JOIN contracts c ON u.user_id = c.freelancer_id
WHERE u.role = 'freelancer'
GROUP BY u.user_id;

-- View: Active Contracts with Details
CREATE VIEW active_contracts AS
SELECT 
    c.contract_id,
    c.job_id,
    j.title as job_title,
    c.freelancer_id,
    f.display_name as freelancer_name,
    c.client_id,
    cl.display_name as client_name,
    c.start_date,
    c.duration,
    c.pay_amount,
    c.status
FROM contracts c
JOIN jobs j ON c.job_id = j.job_id
JOIN users f ON c.freelancer_id = f.user_id
JOIN users cl ON c.client_id = cl.user_id
WHERE c.status IN ('active', 'in-progress');

-- View: Job Details with Application Count
CREATE VIEW job_details_with_applicants AS
SELECT 
    j.job_id,
    j.title,
    j.client_id,
    u.display_name as client_name,
    j.category,
    j.pay_min,
    j.pay_max,
    j.duration,
    j.location_type,
    j.status,
    COUNT(p.proposal_id) as total_applicants,
    COUNT(CASE WHEN p.status = 'pending' THEN 1 END) as pending_applicants,
    COUNT(CASE WHEN p.status = 'accepted' THEN 1 END) as accepted_applicants
FROM jobs j
LEFT JOIN proposals p ON j.job_id = p.job_id
JOIN users u ON j.client_id = u.user_id
GROUP BY j.job_id, j.title, j.client_id, u.display_name, j.category, 
         j.pay_min, j.pay_max, j.duration, j.location_type, j.status;

-- View: User Rating History
CREATE VIEW user_rating_history AS
SELECT 
    u.user_id,
    u.display_name,
    u.rating_score as current_rating,
    r.review_id,
    r.rating as review_rating,
    r.feedback,
    r.created_at as review_date,
    rv.display_name as reviewer_name
FROM users u
LEFT JOIN reviews r ON u.user_id = r.reviewee_id
LEFT JOIN users rv ON r.reviewer_id = rv.user_id
ORDER BY r.created_at DESC;

-- ============================================
-- FUNCTIONS FOR COMMON OPERATIONS
-- ============================================

-- Function: Update user rating after new review
CREATE OR REPLACE FUNCTION update_user_rating()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE users
    SET 
        rating_score = (
            SELECT AVG(rating)::DECIMAL(3,1)
            FROM reviews
            WHERE reviewee_id = NEW.reviewee_id
        ),
        total_reviews = (
            SELECT COUNT(*)
            FROM reviews
            WHERE reviewee_id = NEW.reviewee_id
        )
    WHERE user_id = NEW.reviewee_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger: Update rating when new review is added
CREATE TRIGGER update_rating_after_review
    AFTER INSERT ON reviews
    FOR EACH ROW
    EXECUTE FUNCTION update_user_rating();

-- Function: Complete contract
CREATE OR REPLACE FUNCTION complete_contract(contract_id_param UUID)
RETURNS VOID AS $$
DECLARE
    contract_record contracts%ROWTYPE;
BEGIN
    SELECT * INTO contract_record FROM contracts WHERE contract_id = contract_id_param;
    
    IF contract_record.freelancer_completed AND contract_record.client_completed THEN
        UPDATE contracts
        SET 
            status = 'completed',
            completion_date = NOW(),
            chat_active = FALSE
        WHERE contract_id = contract_id_param;
    END IF;
END;
$$ LANGUAGE plpgsql;

-- Function: Archive old notifications
CREATE OR REPLACE FUNCTION archive_old_notifications()
RETURNS VOID AS $$
BEGIN
    DELETE FROM notifications
    WHERE created_at < NOW() - INTERVAL '30 days'
    AND read = TRUE;
END;
$$ LANGUAGE plpgsql;

-- ============================================
-- ROW LEVEL SECURITY POLICIES (RLS)
-- ============================================

-- Enable RLS on all tables
ALTER TABLE users ENABLE ROW LEVEL SECURITY;
ALTER TABLE jobs ENABLE ROW LEVEL SECURITY;
ALTER TABLE proposals ENABLE ROW LEVEL SECURITY;
ALTER TABLE contracts ENABLE ROW LEVEL SECURITY;
ALTER TABLE messages ENABLE ROW LEVEL SECURITY;
ALTER TABLE portfolio ENABLE ROW LEVEL SECURITY;
ALTER TABLE reviews ENABLE ROW LEVEL SECURITY;
ALTER TABLE notifications ENABLE ROW LEVEL SECURITY;

-- Users policies
CREATE POLICY users_select_policy ON users
    FOR SELECT USING (true);

CREATE POLICY users_update_policy ON users
    FOR UPDATE USING (auth.uid() = user_id);

-- Jobs policies
CREATE POLICY jobs_select_policy ON jobs
    FOR SELECT USING (true);

CREATE POLICY jobs_insert_policy ON jobs
    FOR INSERT WITH CHECK (auth.uid() = client_id);

CREATE POLICY jobs_update_policy ON jobs
    FOR UPDATE USING (auth.uid() = client_id);

-- Proposals policies
CREATE POLICY proposals_select_policy ON proposals
    FOR SELECT USING (true);

CREATE POLICY proposals_insert_policy ON proposals
    FOR INSERT WITH CHECK (auth.uid() = freelancer_id);

CREATE POLICY proposals_update_policy ON proposals
    FOR UPDATE USING (auth.uid() = freelancer_id OR auth.uid() IN (
        SELECT client_id FROM jobs WHERE job_id = proposals.job_id
    ));

-- Contracts policies
CREATE POLICY contracts_select_policy ON contracts
    FOR SELECT USING (auth.uid() = freelancer_id OR auth.uid() = client_id);

CREATE POLICY contracts_update_policy ON contracts
    FOR UPDATE USING (auth.uid() = freelancer_id OR auth.uid() = client_id);

-- Messages policies
CREATE POLICY messages_select_policy ON messages
    FOR SELECT USING (auth.uid() = sender_id OR auth.uid() = receiver_id);

CREATE POLICY messages_insert_policy ON messages
    FOR INSERT WITH CHECK (auth.uid() = sender_id);

-- Portfolio policies
CREATE POLICY portfolio_select_policy ON portfolio
    FOR SELECT USING (true);

CREATE POLICY portfolio_insert_policy ON portfolio
    FOR INSERT WITH CHECK (auth.uid() = freelancer_id);

CREATE POLICY portfolio_update_policy ON portfolio
    FOR UPDATE USING (auth.uid() = freelancer_id);

-- Reviews policies
CREATE POLICY reviews_select_policy ON reviews
    FOR SELECT USING (true);

CREATE POLICY reviews_insert_policy ON reviews
    FOR INSERT WITH CHECK (auth.uid() = reviewer_id);

-- Notifications policies
CREATE POLICY notifications_select_policy ON notifications
    FOR SELECT USING (auth.uid() = user_id);

CREATE POLICY notifications_update_policy ON notifications
    FOR UPDATE USING (auth.uid() = user_id);

-- ============================================
-- DISPLAY SCHEMA DIAGRAM INFORMATION
-- ============================================

-- View all tables
SELECT table_name, table_type
FROM information_schema.tables
WHERE table_schema = 'public'
ORDER BY table_name;

-- View all relationships
SELECT 
    tc.table_name as source_table,
    kcu.column_name as source_column,
    ccu.table_name as target_table,
    ccu.column_name as target_column
FROM information_schema.table_constraints tc
JOIN information_schema.key_column_usage kcu
    ON tc.constraint_name = kcu.constraint_name
JOIN information_schema.constraint_column_usage ccu
    ON ccu.constraint_name = tc.constraint_name
WHERE tc.constraint_type = 'FOREIGN KEY'
    AND tc.table_schema = 'public'
ORDER BY tc.table_name;

-- Count records in each table
SELECT 
    'users' as table_name, COUNT(*) as record_count FROM users
UNION ALL
SELECT 'jobs', COUNT(*) FROM jobs
UNION ALL
SELECT 'proposals', COUNT(*) FROM proposals
UNION ALL
SELECT 'contracts', COUNT(*) FROM contracts
UNION ALL
SELECT 'messages', COUNT(*) FROM messages
UNION ALL
SELECT 'portfolio', COUNT(*) FROM portfolio
UNION ALL
SELECT 'reviews', COUNT(*) FROM reviews
UNION ALL
SELECT 'notifications', COUNT(*) FROM notifications
UNION ALL
SELECT 'assessment_questions', COUNT(*) FROM assessment_questions
ORDER BY table_name;
```

---

## Step 4: Run the Script

1. Click **"Run"** button at the bottom of the editor
2. Wait for execution (takes 10-15 seconds)
3. You should see: **"Success. No rows returned"** message

---

## Step 5: Verify Tables Created

1. Click **"Table Editor"** in left sidebar
2. You should see all 9 tables:
   - users
   - jobs
   - proposals
   - contracts
   - messages
   - portfolio
   - reviews
   - notifications
   - assessment_questions

---

## Step 6: View Schema Diagram

1. Click **"Database"** in left sidebar
2. Click **"Schema Diagram"** tab
3. You'll see a visual representation showing:
   - All tables with their columns
   - Relationships between tables (foreign keys)
   - Primary keys highlighted

---

## Step 7: Understanding the Diagram

### Key Relationships (Foreign Keys)

| Source Table | Foreign Key | Target Table |
|--------------|-------------|--------------|
| jobs | client_id | users.user_id |
| proposals | job_id | jobs.job_id |
| proposals | freelancer_id | users.user_id |
| contracts | job_id | jobs.job_id |
| contracts | proposal_id | proposals.proposal_id |
| contracts | freelancer_id | users.user_id |
| contracts | client_id | users.user_id |
| messages | contract_id | contracts.contract_id |
| messages | sender_id | users.user_id |
| messages | receiver_id | users.user_id |
| portfolio | freelancer_id | users.user_id |
| reviews | contract_id | contracts.contract_id |
| reviews | reviewer_id | users.user_id |
| reviews | reviewee_id | users.user_id |
| notifications | user_id | users.user_id |

### Primary Keys
- users.user_id
- jobs.job_id
- proposals.proposal_id
- contracts.contract_id
- messages.message_id
- portfolio.portfolio_id
- reviews.review_id
- notifications.notification_id
- assessment_questions.question_id

---

## Step 8: Add Sample Data (Already Included)

The script already includes sample data:
- 3 sample users
- 1 sample job
- 1 sample proposal
- 1 sample contract
- 1 sample message
- 1 sample portfolio item
- 1 sample review
- 1 sample notification
- 9 assessment questions

---

## Step 9: Generate ER Diagram Image (Optional)

To get a downloadable diagram:

1. Click **"Schema Diagram"** tab
2. Use browser screenshot tool or print to PDF
3. Or use an external tool with the generated schema

---

## Step 10: Export Schema (Optional)

If you want to share the schema:

1. Click **"SQL Editor"** 
2. Click **"New Query"**
3. Run this to export all table definitions:

```sql
-- Generate complete schema script
SELECT 
    'CREATE TABLE ' || table_name || ' (' || 
    string_agg(column_name || ' ' || data_type || 
    CASE WHEN is_nullable = 'NO' THEN ' NOT NULL' ELSE '' END, ', ') || 
    ');' as create_statement
FROM information_schema.columns
WHERE table_schema = 'public'
GROUP BY table_name
ORDER BY table_name;
```

4. Copy and save the output

---

## Step 11: Configure Authentication (If Needed)

For testing authentication:

1. Click **"Authentication"** in left sidebar
2. Click **"Providers"** tab
3. Enable Email/Password provider
4. Enable Google provider (optional)

---

## Troubleshooting

### Error: "relation already exists"
- Delete all tables manually using SQL Editor:
```sql
DROP TABLE IF EXISTS notifications, reviews, messages, contracts, proposals, jobs, portfolio, assessment_questions, users CASCADE;
```
- Run the script again

### Error: "permission denied"
- Make sure you're using the default `postgres` role
- Grant permissions:
```sql
GRANT ALL ON ALL TABLES IN SCHEMA public TO postgres;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public TO postgres;
```

### Diagram not showing relationships
- Verify foreign keys exist:
```sql
SELECT 
    tc.table_name, kcu.column_name, ccu.table_name AS foreign_table_name
FROM information_schema.table_constraints tc
JOIN information_schema.key_column_usage kcu
    ON tc.constraint_name = kcu.constraint_name
JOIN information_schema.constraint_column_usage ccu
    ON ccu.constraint_name = tc.constraint_name
WHERE tc.constraint_type = 'FOREIGN KEY';
```

---

