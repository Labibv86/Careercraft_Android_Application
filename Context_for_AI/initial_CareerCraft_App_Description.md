

**\# CareerCraft App Description: Freelance Career Discovery** 

\#\# Introduction

In the rapidly evolving landscape of freelance work, millions of aspiring professionals find themselves at a crossroads—possessing skills and ambition but lacking clarity on which career path to pursue. CareerCraft emerges as a transformative solution that bridges this critical gap. Unlike conventional freelancing platforms that merely connect workers with employers, CareerCraft introduces an intelligent career discovery system that guides users toward their ideal professional trajectory before they even begin their freelance journey. By combining psychological assessment, machine learning predictions, and a robust contract management system, CareerCraft creates an ecosystem where both beginners and experts can thrive while maintaining accountability through a comprehensive rating mechanism.

\#\# The Dual User Experience

CareerCraft serves two distinct user types, each with tailored experiences that respect their unique needs. Freelancers form the platform's foundation, representing professionals seeking meaningful work opportunities. Clients constitute the second pillar, comprising businesses and individuals looking to hire skilled talent for their projects. This dual structure creates a balanced marketplace where supply and demand interact seamlessly.

Upon signing up, freelancers encounter a pivotal decision point—declaring themselves as either beginners or experts. This distinction shapes their entire onboarding journey. Beginners gain access to the platform's signature career guidance system, a structured assessment designed to uncover their natural inclinations, skills, and work preferences. Experts, conversely, bypass this guided exploration and directly select their preferred job categories, respecting their existing professional clarity and experience.

\#\# The Intelligent Career Discovery Engine

At the heart of CareerCraft lies its machine learning-powered career discovery engine, specifically designed to assist beginners who may feel overwhelmed by the vast array of freelance opportunities. Users complete a comprehensive yet engaging assessment featuring dynamically generated questions covering technical aptitude, communication skills, teamwork preferences, physical endurance, outdoor work inclination, and daily availability. These questions appear as visually appealing cards with sliding selectors, creating an interactive experience that feels more like self-discovery than a test.

The system then processes these responses through a pre-trained machine learning model, mapping user characteristics to one of four broad career categories: Technology and Remote Work, Creative and Design, Physical and Labor, or Service and Public Facing. Rather than simply displaying abstract classifications, CareerCraft presents concrete job suggestions within each category—ten specific career paths that align with the user's profile. For instance, a user showing high technical aptitude and preference for independent work might see suggestions for Software Engineering, Mobile App Development, or Data Science. Each suggestion includes a match percentage and required skills, providing immediate clarity on what the path entails.

\#\# Smart Job Matching and Discovery

Once freelancers establish their career direction, CareerCraft's Smart Job Feed curates relevant opportunities tailored to their chosen path. The feed intelligently prioritizes jobs matching the freelancer's category, ensuring that users encounter the most relevant opportunities first. This personalization extends throughout the platform, creating an experience that feels uniquely designed for each individual.

Experts who bypass the assessment phase enjoy equal access to this intelligent filtering, manually selecting their preferred categories upon onboarding. This flexibility acknowledges that experienced professionals already understand their strengths and simply need efficient access to suitable opportunities. The platform thus accommodates users at every stage of their professional journey.

\#\# Client Experience and Contract Management

Clients experience CareerCraft as an intuitive recruitment platform where they can post detailed job contracts specifying title, category, description, required skills, pay range, duration, and location preferences. Each posting attracts qualified applicants, creating a competitive yet fair environment. Clients review proposals from interested freelancers, examining cover letters, proposed rates, and estimated timelines before making their selection.

When a client selects a freelancer, the platform automatically creates a contract and notifies all other applicants of their rejection. This transparent process maintains professionalism and ensures all parties understand their status promptly. Contracts can only be initiated through formal proposals, preventing ad-hoc arrangements and maintaining documentation integrity.

\#\# Communication and Contractual Integrity

CareerCraft implements a sophisticated communication system where messaging is exclusively tied to active contracts. This design decision ensures that conversations remain project-relevant and professional. Once both parties confirm work completion, the chat automatically becomes read-only, preserving historical context while preventing unnecessary extended communication. The complete contract history remains accessible to both parties, maintaining transparency and accountability.

The platform empowers users to manage their contracts through various actions—freelancers can withdraw proposals before selection, clients can extend contract durations with mutual agreement, and both parties can mark work as complete. These controls ensure that users remain in command of their professional relationships while the platform maintains necessary oversight.

\#\# Comprehensive Accountability Through Rating

Perhaps CareerCraft's most innovative feature is its comprehensive rating system, which transcends traditional five-star approaches. The platform implements a \-10 to \+10 rating scale that accurately reflects user performance and reliability. Ratings directly influence platform privileges—users scoring below 4 cannot access high-paying job opportunities, while those reaching \-10 face immediate suspension. This system creates powerful incentives for professionalism and quality service delivery.

Both freelancers and clients receive ratings after contract completion, ensuring mutual accountability. The dual-rating approach acknowledges that professional conduct extends in both directions—freelancers must deliver quality work, while clients must provide fair compensation and clear communication. Reviews are public and identifiable, encouraging honest feedback while maintaining community trust.

\#\# Portfolio and Professional Showcase

Freelancers build comprehensive portfolios within CareerCraft, showcasing their best work through images and project descriptions. These visual galleries serve as living resumes, enabling clients to evaluate capabilities before hiring. The portfolio system requires each submission to include at least one image and a descriptive title, ensuring quality presentation across the platform.

\#\# Conclusion

CareerCraft represents a paradigm shift in freelance platform design, moving beyond simple transaction facilitation to active career development support. By integrating intelligent guidance, personalized job matching, contract-bound communication, and a comprehensive rating system, the platform creates an ecosystem where professionals grow, clients find quality talent, and both parties maintain accountability. The thoughtful distinction between beginner and expert users ensures that everyone receives appropriate guidance, whether they are discovering their career path or pursuing established expertise. In doing so, CareerCraft not only connects people with work but genuinely helps them find their professional calling.

**\# CareerCraft Database Architecture**

\#\# Introduction

The database architecture of CareerCraft represents the foundational backbone upon which the entire application operates. Every feature—from career discovery to contract management—relies on carefully structured data relationships that ensure integrity, scalability, and logical consistency. The design philosophy prioritizes clarity over complexity, recognizing that an academic project demands maintainable structures that clearly demonstrate understanding of relational database principles. Each table serves a distinct purpose, while foreign key relationships create a web of interconnected data that mirrors the real-world relationships between users, jobs, contracts, and communications. The architecture supports the platform's core promise: guiding freelancers toward meaningful careers while maintaining accountability through transparent rating mechanisms.

\#\# User Management and Authentication

The users table stands as the central repository for all platform participants, storing essential identity information while accommodating role-specific attributes. Each user receives a unique UUID primary key, ensuring global uniqueness without exposing sequential identifiers. The table captures email addresses as unique authentication credentials, display names for professional identification, and optional photo URLs for visual recognition. The role field, constrained to freelancer or client values, determines the entire user experience within the application. Similarly, the user\_type field distinguishes beginners requiring career guidance from experts who bypass the assessment process.

The rating system represents a crucial design decision, storing both the current rating score and total review count as derived values that update automatically through database triggers. This denormalization, while breaking strict normalization rules, dramatically improves query performance when displaying user ratings. The profile\_percent field enables quick validation of profile completeness, ensuring users meet the 100% threshold before applying to jobs. The selected\_categories array stores multiple career paths for experts, while assessment-related fields track beginners' progression through the Q\&A process. This thoughtful separation of concerns ensures that users across all experience levels receive appropriate experiences.

\#\# Assessment and Career Guidance

The assessment\_questions table demonstrates the platform's commitment to dynamic content delivery. Rather than hardcoding questions within the application, CareerCraft stores them in the database, enabling administrators to modify or expand the assessment without requiring application updates. Each question includes a feature\_mapping field, establishing the critical link between user responses and machine learning model inputs. The type field distinguishes between slider-based continuous responses and discrete multiple-choice selections, allowing for varied question formats that maintain user engagement. The display\_order field ensures consistent sequencing across the user experience, creating a logical progression through the assessment.

This architectural choice reflects a deeper understanding of the machine learning workflow—the same features used during model training are collected through user responses, ensuring perfect alignment between training data and inference inputs. The separation of question storage from the application logic also facilitates A/B testing of different questions, allowing iterative improvement of the career guidance system without disrupting the user experience.

\#\# Job Posting and Opportunity Management

The jobs table captures all employment opportunities posted by clients, storing comprehensive details that enable intelligent matching. The category field, constrained to Technology, Creative, Physical, or Service values, directly maps to the machine learning model's output classes, creating a seamless bridge between career prediction and job discovery. The required\_skills array enables skill-based filtering, while the pay\_min and pay\_max fields define compensation ranges that factor into job eligibility calculations.

The status field tracks job lifecycle states—open for accepting applications, in-progress after selecting a freelancer, completed upon work fulfillment, or cancelled due to mutual agreement. The deadline field enables automatic expiration, removing stale opportunities from the Smart Job Feed while maintaining historical records for analytics. Foreign key relationships with the users table ensure that only authenticated clients can create jobs, while additional fields capture location preferences and physical requirements for on-site positions. This structure accommodates both remote freelance work and physical contractual jobs, reflecting the platform's inclusive scope.

\#\# Proposal System and Application Management

The proposals table serves as the matching engine connecting freelancers with opportunities, storing comprehensive application details that enable informed client decisions. Each proposal establishes a unique relationship between a freelancer and a specific job, enforced through a composite unique constraint preventing duplicate applications. This design choice maintains fairness while simplifying the selection process. The status field tracks applications through their lifecycle—pending review, accepted with a contract created, rejected by the client, or withdrawn by the freelancer.

This status management enables immediate notifications when clients make selections, automatically rejecting other applicants while preserving their application history. The proposed\_rate field allows freelancers to negotiate compensation, while the estimated\_timeline provides clients with expected delivery dates. The portfolio\_items array enables freelancers to showcase relevant work samples directly within their applications, saving clients from navigating to separate portfolio views. This denormalization improves user experience while maintaining data consistency through application-level integrity.

\#\# Contract Management and Communication

The contracts table represents the culmination of successful proposals, formalizing the professional relationship between freelancer and client. Each contract references the originating job and proposal, creating a complete audit trail from opportunity posting to work engagement. The dual foreign key references to the users table—one for the freelancer and one for the client—enable efficient querying of active engagements for each user. The start\_date timestamp captures contract initiation, while completion\_date and status fields track project progression.

The chat\_active boolean directly controls communication permissions, enabling immediate chat lock upon contract completion. This design decision implements the platform's principle of contract-bound messaging, ensuring conversations remain project-relevant. The freelancer\_completed and client\_completed booleans enable dual confirmation workflows, requiring both parties to agree before marking work as complete. This prevents unilateral completion claims and maintains mutual satisfaction. The pay\_amount field captures the agreed compensation, serving as the foundation for future payment processing.

\#\# Messaging System

The messages table captures all communication within active contracts, with each message belonging to a specific contract rather than user pairs. This architectural decision ensures that messages remain contextually relevant and automatically expire with contracts. The sender\_receiver relationship enables querying all messages for a user across contracts, while the read boolean supports read receipt functionality. The timestamp enables chronological ordering without requiring complex sorting logic in the application layer.

Foreign key relationships enforce data integrity, preventing orphaned messages without associated contracts. The table structure supports unlimited scalability, with proper indexing ensuring efficient querying even as message volumes grow. The design intentionally avoids file attachments, maintaining simplicity while supporting future extensibility through separate attachment tables if needed.

\#\# Portfolio and Professional Showcase

The portfolio table enables freelancers to build compelling professional galleries, storing visual representations of their capabilities. Each portfolio item references its creator through a foreign key to the users table, ensuring ownership and enabling efficient display on freelancer profiles. The images array stores multiple photo URLs, supporting comprehensive project showcases without requiring complex relational designs. The category field enables filtering and organization of portfolio items by type or industry.

This structure reflects a deliberate separation from the proposal process—portfolio items exist as persistent artifacts that freelancers can reference across multiple applications. The title and description fields provide context, enabling clients to evaluate quality without viewing images. The updated\_at trigger automatically tracks modifications, helping clients distinguish current work from outdated samples. This design acknowledges that portfolios evolve over time, requiring flexible update mechanisms.

\#\# Review and Rating System

The reviews table implements CareerCraft's accountability mechanism, storing detailed evaluations that shape platform privileges. Each review belongs to a specific contract, ensuring that ratings reflect actual work experiences. The reviewer and reviewee references establish clear directional relationships, while the rating field accepts values from \-10 to 10, supporting granular performance evaluation. The unique constraint on contract\_reviewer prevents duplicate reviews, maintaining rating integrity.

This structure enables sophisticated analytics—users can view their rating history, track improvement over time, and understand how specific projects contributed to their current rating. The feedback text field enables qualitative commentary, providing context for numerical ratings. The timestamp enables chronological ordering, helping users identify recent patterns. Foreign key relationships ensure that reviews remain tied to verifiable contracts, preventing fraudulent or unverified ratings.

\#\# Notification System

The notifications table provides a persistent record of all user alerts, supporting both in-app and push notification delivery. Each notification targets a specific user through the user\_id foreign key, while the type field enables categorization for different behaviors. The title and body fields store human-readable content, while the data JSONB field enables structured additional information for deep linking and complex actions. The read boolean enables badge counting and unread notification tracking.

This dual-purpose design supports both immediate alerts and historical review, allowing users to revisit past notifications. The JSONB field provides flexibility for storing varying data structures across notification types without schema modifications. The creation timestamp enables automatic expiration of old notifications through scheduled cleanup processes. This architecture supports all notification scenarios—proposal submissions, hiring decisions, contract updates, and rating alerts—through a unified structure.

\#\# Views and Functions for Operational Efficiency

CareerCraft employs carefully designed database views to simplify complex queries and improve performance. The freelancer\_profiles view aggregates portfolio counts and contract histories, providing comprehensive profile summaries without application-level joins. The active\_contracts view filters current engagements, enabling efficient dashboard rendering. The job\_details\_with\_applicants view calculates application counts, helping clients understand proposal activity at a glance. These views encapsulate complex business logic within the database, simplifying application development.

Database functions automate critical maintenance tasks. The update\_user\_rating trigger recalculates scores when new reviews are inserted, ensuring ratings remain accurate without application intervention. The complete\_contract function coordinates multi-step completion workflows, updating status and locking communication simultaneously. The archive\_old\_notifications function cleans historical data, maintaining database performance. These server-side operations reduce application complexity while ensuring consistent business rule enforcement.

\#\# Indexing and Performance Optimization

Strategic indexing ensures that CareerCraft maintains responsive performance as data grows. Indexes on foreign keys accelerate join operations for user relationships, while indexes on status and category fields optimize filtering in job feeds and application lists. The message timestamp index supports chronological message retrieval, while the notification read index facilitates efficient badge counting. These performance optimizations maintain application responsiveness across all user interactions.

The indexing strategy reflects understanding of actual usage patterns—fields frequently used in WHERE clauses receive priority indexing, while rarely filtered fields remain unindexed to conserve storage. Composite indexes support common query patterns, such as filtering jobs by both status and category simultaneously. This measured approach balances performance gains against index maintenance overhead, ensuring sustainable performance throughout the application lifecycle.

\#\# Security Implementation with Row Level Security

CareerCraft implements robust security through Firebase Row Level Security policies, ensuring users access only appropriate data. Freelancers can view all jobs but only their own proposals and contracts. Clients can view jobs they created and proposals for those jobs. Messages remain restricted to contract participants, while portfolio items require ownership for modification. These policies enforce the principle of least privilege, preventing unauthorized data access.

The RLS policies extend to all tables, creating a comprehensive security layer that protects user privacy while enabling necessary collaboration. Public access policies for portfolio items and basic profile data enable discovery, while strict write policies prevent unauthorized modifications. This security architecture ensures data integrity while supporting the platform's collaborative features.

\#\# Conclusion

The CareerCraft database architecture demonstrates careful consideration of every feature's data requirements while maintaining relational integrity and performance. From user authentication through career guidance, contract management, and rating systems, each table serves a specific purpose while contributing to the platform's unified vision. The thoughtful inclusion of views, functions, and indexing reflects an understanding of real-world performance requirements, while security policies ensure data protection. This architecture provides a solid foundation for building a platform that guides freelancers toward meaningful careers while maintaining professional accountability.

\-- \============================================  
\-- CAREERCRAFT \- COMPLETE DATABASE SCHEMA  
\-- All Tables, Relationships, and Optimizations  
\-- \============================================

\-- 1\. USERS TABLE  
CREATE TABLE users (  
    user\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    email TEXT UNIQUE NOT NULL,  
    display\_name TEXT NOT NULL,  
    photo\_url TEXT,  
    role TEXT NOT NULL CHECK (role IN ('freelancer', 'client')),  
    user\_type TEXT NOT NULL CHECK (user\_type IN ('beginner', 'expert')),  
    bio TEXT,  
    skills TEXT\[\],  
    rating\_score DECIMAL(3,1) DEFAULT 0.0 CHECK (rating\_score \>= \-10 AND rating\_score \<= 10),  
    total\_reviews INTEGER DEFAULT 0,  
    selected\_categories TEXT\[\],  
    assessment\_completed BOOLEAN DEFAULT FALSE,  
    predicted\_class INTEGER CHECK (predicted\_class BETWEEN 0 AND 3),  
    career\_path TEXT,  
    profile\_complete BOOLEAN DEFAULT FALSE,  
    profile\_percent INTEGER DEFAULT 0 CHECK (profile\_percent BETWEEN 0 AND 100),  
    created\_at TIMESTAMP DEFAULT NOW(),  
    updated\_at TIMESTAMP DEFAULT NOW()  
);

\-- 2\. ASSESSMENT QUESTIONS TABLE  
CREATE TABLE assessment\_questions (  
    question\_id SERIAL PRIMARY KEY,  
    question TEXT NOT NULL,  
    type TEXT NOT NULL CHECK (type IN ('slider', 'multiple\_choice')),  
    min\_value INTEGER,  
    max\_value INTEGER,  
    feature\_mapping TEXT NOT NULL,  
    icon TEXT,  
    options TEXT\[\],  
    display\_order INTEGER NOT NULL,  
    created\_at TIMESTAMP DEFAULT NOW()  
);

\-- 3\. JOBS TABLE  
CREATE TABLE jobs (  
    job\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    client\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    title TEXT NOT NULL,  
    category TEXT NOT NULL CHECK (category IN ('Technology', 'Creative', 'Physical', 'Service')),  
    description TEXT NOT NULL,  
    required\_skills TEXT\[\] NOT NULL,  
    pay\_min DECIMAL(10,2) NOT NULL,  
    pay\_max DECIMAL(10,2) NOT NULL,  
    duration TEXT NOT NULL,  
    location\_type TEXT NOT NULL CHECK (location\_type IN ('Remote', 'Hybrid', 'On-site')),  
    location TEXT,  
    status TEXT DEFAULT 'open' CHECK (status IN ('open', 'in-progress', 'completed', 'cancelled')),  
    deadline TIMESTAMP,  
    created\_at TIMESTAMP DEFAULT NOW(),  
    updated\_at TIMESTAMP DEFAULT NOW()  
);

\-- 4\. PROPOSALS TABLE  
CREATE TABLE proposals (  
    proposal\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    job\_id UUID NOT NULL REFERENCES jobs(job\_id) ON DELETE CASCADE,  
    freelancer\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    cover\_letter TEXT NOT NULL,  
    proposed\_rate DECIMAL(10,2) NOT NULL,  
    estimated\_timeline TEXT NOT NULL,  
    portfolio\_items TEXT\[\],  
    status TEXT DEFAULT 'pending' CHECK (status IN ('pending', 'accepted', 'rejected', 'withdrawn')),  
    created\_at TIMESTAMP DEFAULT NOW(),  
    updated\_at TIMESTAMP DEFAULT NOW(),  
    UNIQUE(job\_id, freelancer\_id)  
);

\-- 5\. CONTRACTS TABLE  
CREATE TABLE contracts (  
    contract\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    job\_id UUID NOT NULL REFERENCES jobs(job\_id) ON DELETE CASCADE,  
    proposal\_id UUID NOT NULL REFERENCES proposals(proposal\_id) ON DELETE CASCADE,  
    freelancer\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    client\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    status TEXT DEFAULT 'active' CHECK (status IN ('active', 'completed', 'read-only', 'archived')),  
    start\_date TIMESTAMP DEFAULT NOW(),  
    completion\_date TIMESTAMP,  
    duration TEXT NOT NULL,  
    pay\_amount DECIMAL(10,2) NOT NULL,  
    chat\_active BOOLEAN DEFAULT TRUE,  
    freelancer\_completed BOOLEAN DEFAULT FALSE,  
    client\_completed BOOLEAN DEFAULT FALSE,  
    created\_at TIMESTAMP DEFAULT NOW(),  
    updated\_at TIMESTAMP DEFAULT NOW()  
);

\-- 6\. MESSAGES TABLE  
CREATE TABLE messages (  
    message\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    contract\_id UUID NOT NULL REFERENCES contracts(contract\_id) ON DELETE CASCADE,  
    sender\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    receiver\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    content TEXT NOT NULL,  
    read BOOLEAN DEFAULT FALSE,  
    created\_at TIMESTAMP DEFAULT NOW()  
);

\-- 7\. PORTFOLIO TABLE  
CREATE TABLE portfolio (  
    portfolio\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    freelancer\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    title TEXT NOT NULL,  
    category TEXT NOT NULL,  
    description TEXT,  
    images TEXT\[\] NOT NULL,  
    created\_at TIMESTAMP DEFAULT NOW(),  
    updated\_at TIMESTAMP DEFAULT NOW()  
);

\-- 8\. REVIEWS TABLE  
CREATE TABLE reviews (  
    review\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    contract\_id UUID NOT NULL REFERENCES contracts(contract\_id) ON DELETE CASCADE,  
    reviewer\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    reviewee\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    rating INTEGER NOT NULL CHECK (rating \>= \-10 AND rating \<= 10),  
    feedback TEXT,  
    created\_at TIMESTAMP DEFAULT NOW(),  
    UNIQUE(contract\_id, reviewer\_id)  
);

\-- 9\. NOTIFICATIONS TABLE  
CREATE TABLE notifications (  
    notification\_id UUID PRIMARY KEY DEFAULT gen\_random\_uuid(),  
    user\_id UUID NOT NULL REFERENCES users(user\_id) ON DELETE CASCADE,  
    type TEXT NOT NULL CHECK (type IN ('proposal', 'acceptance', 'rejection', 'message', 'completion', 'rating')),  
    title TEXT NOT NULL,  
    body TEXT NOT NULL,  
    data JSONB,  
    read BOOLEAN DEFAULT FALSE,  
    created\_at TIMESTAMP DEFAULT NOW()  
);

\-- \============================================  
\-- INDEXES FOR PERFORMANCE  
\-- \============================================

CREATE INDEX idx\_users\_role ON users(role);  
CREATE INDEX idx\_users\_rating ON users(rating\_score);  
CREATE INDEX idx\_jobs\_client ON jobs(client\_id);  
CREATE INDEX idx\_jobs\_category ON jobs(category);  
CREATE INDEX idx\_jobs\_status ON jobs(status);  
CREATE INDEX idx\_jobs\_deadline ON jobs(deadline);  
CREATE INDEX idx\_proposals\_job ON proposals(job\_id);  
CREATE INDEX idx\_proposals\_freelancer ON proposals(freelancer\_id);  
CREATE INDEX idx\_proposals\_status ON proposals(status);  
CREATE INDEX idx\_contracts\_freelancer ON contracts(freelancer\_id);  
CREATE INDEX idx\_contracts\_client ON contracts(client\_id);  
CREATE INDEX idx\_contracts\_status ON contracts(status);  
CREATE INDEX idx\_messages\_contract ON messages(contract\_id);  
CREATE INDEX idx\_messages\_sender ON messages(sender\_id);  
CREATE INDEX idx\_messages\_receiver ON messages(receiver\_id);  
CREATE INDEX idx\_messages\_created ON messages(created\_at);  
CREATE INDEX idx\_reviews\_reviewee ON reviews(reviewee\_id);  
CREATE INDEX idx\_reviews\_reviewer ON reviews(reviewer\_id);  
CREATE INDEX idx\_reviews\_rating ON reviews(rating);  
CREATE INDEX idx\_notifications\_user ON notifications(user\_id);  
CREATE INDEX idx\_notifications\_read ON notifications(read);

\-- \============================================  
\-- TRIGGERS FOR AUTOMATIC UPDATES  
\-- \============================================

CREATE OR REPLACE FUNCTION update\_updated\_at()  
RETURNS TRIGGER AS $$  
BEGIN  
    NEW.updated\_at \= NOW();  
    RETURN NEW;  
END;  
$$ LANGUAGE plpgsql;

CREATE TRIGGER update\_users\_updated\_at  
    BEFORE UPDATE ON users  
    FOR EACH ROW  
    EXECUTE FUNCTION update\_updated\_at();

CREATE TRIGGER update\_jobs\_updated\_at  
    BEFORE UPDATE ON jobs  
    FOR EACH ROW  
    EXECUTE FUNCTION update\_updated\_at();

CREATE TRIGGER update\_proposals\_updated\_at  
    BEFORE UPDATE ON proposals  
    FOR EACH ROW  
    EXECUTE FUNCTION update\_updated\_at();

CREATE TRIGGER update\_contracts\_updated\_at  
    BEFORE UPDATE ON contracts  
    FOR EACH ROW  
    EXECUTE FUNCTION update\_updated\_at();

CREATE TRIGGER update\_portfolio\_updated\_at  
    BEFORE UPDATE ON portfolio  
    FOR EACH ROW  
    EXECUTE FUNCTION update\_updated\_at();

\-- \============================================  
\-- RATING UPDATE TRIGGER  
\-- \============================================

CREATE OR REPLACE FUNCTION update\_user\_rating()  
RETURNS TRIGGER AS $$  
BEGIN  
    UPDATE users  
    SET   
        rating\_score \= (  
            SELECT AVG(rating)::DECIMAL(3,1)  
            FROM reviews  
            WHERE reviewee\_id \= NEW.reviewee\_id  
        ),  
        total\_reviews \= (  
            SELECT COUNT(\*)  
            FROM reviews  
            WHERE reviewee\_id \= NEW.reviewee\_id  
        )  
    WHERE user\_id \= NEW.reviewee\_id;  
    RETURN NEW;  
END;  
$$ LANGUAGE plpgsql;

CREATE TRIGGER update\_rating\_after\_review  
    AFTER INSERT ON reviews  
    FOR EACH ROW  
    EXECUTE FUNCTION update\_user\_rating();

\-- \============================================  
\-- CONTRACT COMPLETION FUNCTION  
\-- \============================================

CREATE OR REPLACE FUNCTION complete\_contract(contract\_id\_param UUID)  
RETURNS VOID AS $$  
DECLARE  
    contract\_record contracts%ROWTYPE;  
BEGIN  
    SELECT \* INTO contract\_record FROM contracts WHERE contract\_id \= contract\_id\_param;  
      
    IF contract\_record.freelancer\_completed AND contract\_record.client\_completed THEN  
        UPDATE contracts  
        SET   
            status \= 'completed',  
            completion\_date \= NOW(),  
            chat\_active \= FALSE  
        WHERE contract\_id \= contract\_id\_param;  
    END IF;  
END;  
$$ LANGUAGE plpgsql;

\-- \============================================  
\-- NOTIFICATION CLEANUP FUNCTION  
\-- \============================================

CREATE OR REPLACE FUNCTION archive\_old\_notifications()  
RETURNS VOID AS $$  
BEGIN  
    DELETE FROM notifications  
    WHERE created\_at \< NOW() \- INTERVAL '30 days'  
    AND read \= TRUE;  
END;  
$$ LANGUAGE plpgsql;

\-- \============================================  
\-- DATABASE VIEWS  
\-- \============================================

CREATE VIEW freelancer\_profiles AS  
SELECT   
    u.user\_id,  
    u.display\_name,  
    u.photo\_url,  
    u.bio,  
    u.skills,  
    u.rating\_score,  
    u.total\_reviews,  
    u.career\_path,  
    u.profile\_percent,  
    COUNT(DISTINCT p.portfolio\_id) as portfolio\_count,  
    COUNT(DISTINCT c.contract\_id) as total\_contracts  
FROM users u  
LEFT JOIN portfolio p ON u.user\_id \= p.freelancer\_id  
LEFT JOIN contracts c ON u.user\_id \= c.freelancer\_id  
WHERE u.role \= 'freelancer'  
GROUP BY u.user\_id;

CREATE VIEW active\_contracts AS  
SELECT   
    c.contract\_id,  
    c.job\_id,  
    j.title as job\_title,  
    c.freelancer\_id,  
    f.display\_name as freelancer\_name,  
    c.client\_id,  
    cl.display\_name as client\_name,  
    c.start\_date,  
    c.duration,  
    c.pay\_amount,  
    c.status  
FROM contracts c  
JOIN jobs j ON c.job\_id \= j.job\_id  
JOIN users f ON c.freelancer\_id \= f.user\_id  
JOIN users cl ON c.client\_id \= cl.user\_id  
WHERE c.status IN ('active', 'in-progress');

CREATE VIEW job\_details\_with\_applicants AS  
SELECT   
    j.job\_id,  
    j.title,  
    j.client\_id,  
    u.display\_name as client\_name,  
    j.category,  
    j.pay\_min,  
    j.pay\_max,  
    j.duration,  
    j.location\_type,  
    j.status,  
    COUNT(p.proposal\_id) as total\_applicants,  
    COUNT(CASE WHEN p.status \= 'pending' THEN 1 END) as pending\_applicants,  
    COUNT(CASE WHEN p.status \= 'accepted' THEN 1 END) as accepted\_applicants  
FROM jobs j  
LEFT JOIN proposals p ON j.job\_id \= p.job\_id  
JOIN users u ON j.client\_id \= u.user\_id  
GROUP BY j.job\_id, j.title, j.client\_id, u.display\_name, j.category,   
         j.pay\_min, j.pay\_max, j.duration, j.location\_type, j.status;

\-- \============================================  
\-- SAMPLE DATA  
\-- \============================================

INSERT INTO users (email, display\_name, role, user\_type, bio, skills, rating\_score, profile\_complete, profile\_percent) VALUES  
('client1@example.com', 'John Client', 'client', 'expert', 'Hiring manager looking for talent', ARRAY\['Hiring', 'Management'\], 8.5, TRUE, 100),  
('freelancer1@example.com', 'Jane Developer', 'freelancer', 'beginner', 'Passionate about coding', ARRAY\['Java', 'Python', 'Android'\], 7.2, TRUE, 100),  
('freelancer2@example.com', 'Mike Designer', 'freelancer', 'expert', 'UI/UX designer with 5 years experience', ARRAY\['Figma', 'Photoshop', 'Sketch'\], 9.1, TRUE, 100);

INSERT INTO assessment\_questions (question, type, min\_value, max\_value, feature\_mapping, icon, display\_order) VALUES  
('How comfortable are you with technology and computers?', 'slider', 1, 10, 'technical\_aptitude', 'computer', 1),  
('How would you rate your communication skills?', 'slider', 1, 10, 'communication\_skill', 'chat', 2),  
('Do you prefer working alone or in teams?', 'slider', 1, 10, 'prefers\_team\_work', 'people', 3),  
('How important is physical activity in your daily work?', 'slider', 1, 10, 'physical\_endurance', 'fitness', 4),  
('Do you enjoy working outdoors?', 'slider', 1, 10, 'prefers\_outdoor\_work', 'sunny', 5),  
('How many hours can you dedicate daily?', 'slider', 1, 12, 'preferred\_hours\_per\_day', 'clock', 6),  
('What is your highest qualification?', 'multiple\_choice', NULL, NULL, 'qualification\_level', 'school', 7),  
('Where do you prefer to work?', 'multiple\_choice', NULL, NULL, 'work\_location\_preference', 'location', 8),  
('What is your salary expectation?', 'multiple\_choice', NULL, NULL, 'salary\_expectation', 'money', 9);

INSERT INTO jobs (client\_id, title, category, description, required\_skills, pay\_min, pay\_max, duration, location\_type, status) VALUES  
((SELECT user\_id FROM users WHERE email \= 'client1@example.com'),   
 'Android App Development',   
 'Technology',   
 'We need an experienced Android developer to build a freelance marketplace app.',  
 ARRAY\['Java', 'Android Studio', 'Firebase'\],   
 2000.00, 3500.00,   
 '3 months',   
 'Remote',   
 'open');

INSERT INTO proposals (job\_id, freelancer\_id, cover\_letter, proposed\_rate, estimated\_timeline, status) VALUES  
((SELECT job\_id FROM jobs LIMIT 1),  
 (SELECT user\_id FROM users WHERE email \= 'freelancer1@example.com'),  
 'I have 3 years of Android development experience. I can deliver this project within the timeline.',  
 2800.00,  
 '2.5 months',  
 'pending');

INSERT INTO contracts (job\_id, proposal\_id, freelancer\_id, client\_id, duration, pay\_amount, status) VALUES  
((SELECT job\_id FROM jobs LIMIT 1),  
 (SELECT proposal\_id FROM proposals LIMIT 1),  
 (SELECT user\_id FROM users WHERE email \= 'freelancer1@example.com'),  
 (SELECT user\_id FROM users WHERE email \= 'client1@example.com'),  
 '3 months',  
 2800.00,  
 'active');

\-- \============================================  
\-- ROW LEVEL SECURITY POLICIES  
\-- \============================================

ALTER TABLE users ENABLE ROW LEVEL SECURITY;  
ALTER TABLE jobs ENABLE ROW LEVEL SECURITY;  
ALTER TABLE proposals ENABLE ROW LEVEL SECURITY;  
ALTER TABLE contracts ENABLE ROW LEVEL SECURITY;  
ALTER TABLE messages ENABLE ROW LEVEL SECURITY;  
ALTER TABLE portfolio ENABLE ROW LEVEL SECURITY;  
ALTER TABLE reviews ENABLE ROW LEVEL SECURITY;  
ALTER TABLE notifications ENABLE ROW LEVEL SECURITY;  
ALTER TABLE assessment\_questions ENABLE ROW LEVEL SECURITY;

CREATE POLICY users\_select\_policy ON users FOR SELECT USING (true);  
CREATE POLICY users\_update\_policy ON users FOR UPDATE USING (auth.uid() \= user\_id);

CREATE POLICY jobs\_select\_policy ON jobs FOR SELECT USING (true);  
CREATE POLICY jobs\_insert\_policy ON jobs FOR INSERT WITH CHECK (auth.uid() \= client\_id);  
CREATE POLICY jobs\_update\_policy ON jobs FOR UPDATE USING (auth.uid() \= client\_id);

CREATE POLICY proposals\_select\_policy ON proposals FOR SELECT USING (true);  
CREATE POLICY proposals\_insert\_policy ON proposals FOR INSERT WITH CHECK (auth.uid() \= freelancer\_id);  
CREATE POLICY proposals\_update\_policy ON proposals FOR UPDATE USING (auth.uid() \= freelancer\_id OR auth.uid() IN (SELECT client\_id FROM jobs WHERE job\_id \= proposals.job\_id));

CREATE POLICY contracts\_select\_policy ON contracts FOR SELECT USING (auth.uid() \= freelancer\_id OR auth.uid() \= client\_id);  
CREATE POLICY contracts\_update\_policy ON contracts FOR UPDATE USING (auth.uid() \= freelancer\_id OR auth.uid() \= client\_id);

CREATE POLICY messages\_select\_policy ON messages FOR SELECT USING (auth.uid() \= sender\_id OR auth.uid() \= receiver\_id);  
CREATE POLICY messages\_insert\_policy ON messages FOR INSERT WITH CHECK (auth.uid() \= sender\_id);

CREATE POLICY portfolio\_select\_policy ON portfolio FOR SELECT USING (true);  
CREATE POLICY portfolio\_insert\_policy ON portfolio FOR INSERT WITH CHECK (auth.uid() \= freelancer\_id);  
CREATE POLICY portfolio\_update\_policy ON portfolio FOR UPDATE USING (auth.uid() \= freelancer\_id);

CREATE POLICY reviews\_select\_policy ON reviews FOR SELECT USING (true);  
CREATE POLICY reviews\_insert\_policy ON reviews FOR INSERT WITH CHECK (auth.uid() \= reviewer\_id);

CREATE POLICY notifications\_select\_policy ON notifications FOR SELECT USING (auth.uid() \= user\_id);  
CREATE POLICY notifications\_update\_policy ON notifications FOR UPDATE USING (auth.uid() \= user\_id);

CREATE POLICY assessment\_questions\_select\_policy ON assessment\_questions FOR SELECT USING (true);

\# CareerCraft: Complete Page Structure and Navigation Guide

\---

\#\# Introduction

The CareerCraft user interface represents a carefully orchestrated journey through career discovery, job matching, and professional collaboration. Every screen, form, and button serves a specific purpose in guiding users toward meaningful freelance work while maintaining the platform's core principles of intelligent guidance and accountability. The interface design follows a minimalist philosophy with a restrained color palette of white, grey, black, and orange, ensuring that functionality takes precedence over visual clutter. This comprehensive guide details every page, form element, button, and navigation path, creating a complete picture of how users interact with the application from first launch through contract completion and review.

\---

\#\# Section 1: Authentication and Onboarding

\#\#\# 1.1 Splash Screen

\*\*Purpose:\*\* Brand introduction and app initialization  
\*\*Page Description:\*\* A clean, minimal screen displaying the CareerCraft logo with a subtle loading animation. The screen appears briefly while the app checks authentication status and initializes necessary services.

\*\*Visual Elements:\*\*  
\- Centered app logo with tagline "AI-Powered Freelance Mentor"  
\- Progress indicator showing loading status  
\- Version number at bottom corner

\*\*Navigation Logic:\*\*  
\- If user is authenticated → Redirect to role-specific dashboard  
\- If user is not authenticated → Redirect to Login Screen

\---

\#\#\# 1.2 Login Screen

\*\*Purpose:\*\* User authentication and account access  
\*\*Page Description:\*\* A secure entry point where registered users provide credentials to access their accounts. The screen maintains the minimalist design philosophy with clear input fields and prominent action buttons.

\*\*Form Elements:\*\*

| Field Name | Type | Validation | Purpose |  
|------------|------|------------|---------|  
| Email Address | Text Input (Email) | Must be valid email format | User identification |  
| Password | Text Input (Password) | Minimum 6 characters | Account security |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| LOGIN | Orange (Primary) | Authenticates user and navigates to dashboard |  
| SIGN UP | Grey/White (Secondary) | Navigates to Sign Up Screen |  
| Google Sign In | White with icon | OAuth authentication via Google |  
| Forgot Password? | Text Link | Opens password reset dialog |

\*\*Supporting Elements:\*\*  
\- "Remember Me" checkbox (optional)  
\- Error message display below email field  
\- Loading state on login button during authentication

\*\*Navigation Logic:\*\*  
\- Successful login → Dashboard (role-specific)  
\- Failed login → Display error, stay on screen  
\- Google Sign In → Handle OAuth flow, return to dashboard  
\- Forgot Password → Open email reset dialog

\---

\#\#\# 1.3 Sign Up Screen

\*\*Purpose:\*\* New user registration  
\*\*Page Description:\*\* A comprehensive registration form that captures essential user information while maintaining a clean, uncluttered interface. The form guides users through account creation with clear field labels and validation feedback.

\*\*Form Elements:\*\*

| Field Name | Type | Validation | Purpose |  
|------------|------|------------|---------|  
| Full Name | Text Input | Minimum 2 characters | Professional identification |  
| Email Address | Text Input (Email) | Valid email, unique | Account credential |  
| Password | Text Input (Password) | Minimum 8 characters | Account security |  
| Confirm Password | Text Input (Password) | Must match password | Prevent typing errors |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| CONTINUE | Orange (Primary) | Validates form, navigates to Role Selection |  
| Already have an account? | Text Link | Navigates to Login Screen |  
| Sign Up with Google | White with icon | OAuth registration |

\*\*Supporting Elements:\*\*  
\- Password strength indicator  
\- Terms of Service and Privacy Policy links  
\- Real-time field validation feedback

\*\*Navigation Logic:\*\*  
\- Form validation success → Role Selection Screen  
\- Form validation failure → Highlight errors, stay on screen  
\- Google Sign Up → Complete OAuth, proceed to Role Selection

\---

\#\#\# 1.4 Role Selection Screen

\*\*Purpose:\*\* Determine user type (Freelancer or Client)  
\*\*Page Description:\*\* A visually distinct screen presenting two large, card-style options that clearly communicate the differences between freelancer and client experiences. The design uses icons and brief descriptions to aid decision-making.

\*\*Visual Elements:\*\*

| Component | Type | Description |  
|-----------|------|-------------|  
| Freelancer Card | Interactive Card | Icon, title "Freelancer", description "Looking for work and career guidance" |  
| Client Card | Interactive Card | Icon, title "Client", description "Hiring talent for your projects" |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| CONTINUE | Orange (Primary) | Proceeds based on selected role |  
| Back Arrow | Icon | Returns to Sign Up Screen |

\*\*Interaction:\*\*  
\- Tapping a card highlights it with orange border  
\- Selected state persists for confirmation  
\- Haptic feedback on selection

\*\*Navigation Logic:\*\*  
\- Freelancer selected → Beginner/Expert Selection Screen  
\- Client selected → Client Dashboard (after profile setup)  
\- Back → Sign Up Screen

\---

\#\#\# 1.5 Beginner/Expert Selection Screen (Freelancer Only)

\*\*Purpose:\*\* Determine freelancer experience level  
\*\*Page Description:\*\* A decision point that shapes the entire onboarding experience. Beginners receive guided career discovery while experts access direct category selection. The screen uses clear visual metaphors to communicate the difference.

\*\*Visual Elements:\*\*

| Component | Type | Description |  
|-----------|------|-------------|  
| Beginner Card | Interactive Card | 🌱 Icon, "Beginner", description "New to freelancing, need career guidance" |  
| Expert Card | Interactive Card | 💪 Icon, "Expert", description "Experienced, know what I want" |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| CONTINUE | Orange (Primary) | Proceeds based on selected type |  
| Back Arrow | Icon | Returns to Role Selection |

\*\*Navigation Logic:\*\*  
\- Beginner selected → Visual Skill Assessment  
\- Expert selected → Category Selection Screen  
\- Back → Role Selection Screen

\---

\#\#\# 1.6 Visual Skill Assessment (Q\&A Screen)

\*\*Purpose:\*\* Collect personality and preference data for ML prediction  
\*\*Page Description:\*\* An immersive, card-based questionnaire that presents questions one at a time with smooth transitions. Each card features a question, visual icon, and interactive selector appropriate to the question type. The experience feels engaging rather than clinical.

\*\*Form Elements:\*\*

| Component | Type | Question Types |  
|-----------|------|----------------|  
| Question Card | Card View | Displays question text with icon |  
| Slider Selector | SeekBar with labels | 1-10 range for slider-type questions |  
| Multiple Choice | Radio Group | Options displayed as chips for multiple-choice questions |  
| Progress Indicator | Progress Bar | Shows completion percentage (question X of 10\) |

\*\*Dynamic Content:\*\*  
\- Questions fetched from Firestore \`assessment\_questions\` collection  
\- Slider questions show min/max labels  
\- Multiple choice questions show option chips  
\- Questions adapt to screen size

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| Next/Continue | Orange (Primary) | Save answer, proceed to next question |  
| Previous | Text Link | Return to previous question |  
| Skip | Text Link | Mark question as neutral, proceed |  
| Progress Indicator | Visual | Shows position in assessment |

\*\*Supporting Elements:\*\*  
\- Animated transitions between questions  
\- Haptic feedback on slider movements  
\- Progress bar at top of screen  
\- Visual feedback for answered questions

\*\*Navigation Logic:\*\*  
\- All questions answered → ML Prediction Results Screen  
\- Partial completion → Save progress, allow return  
\- Skip → Use default neutral values  
\- Back → Previous question (if available)

\---

\#\#\# 1.7 ML Prediction Results Screen

\*\*Purpose:\*\* Display career recommendations based on assessment  
\*\*Page Description:\*\* A visually engaging results screen presenting the top three career recommendations with match percentages, required skills, and exploration options. The interface celebrates the discovery while providing actionable next steps.

\*\*Visual Elements:\*\*

| Component | Type | Content |  
|-----------|------|---------|  
| Result Card 1 | Card with visual rank | Top job suggestion with match percentage, skills |  
| Result Card 2 | Card with visual rank | Second job suggestion |  
| Result Card 3 | Card with visual rank | Third job suggestion |

\*\*Each Result Card Contains:\*\*  
\- Rank indicator (🥇, 🥈, 🥉)  
\- Job title (e.g., "Mobile App Developer")  
\- Match percentage (visual bar graph)  
\- Required skills (chip tags)  
\- "Explore This Path" button

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| Explore This Path | Orange (Secondary) | Shows details of specific career path |  
| ACCEPT | Orange (Primary) | Saves suggested career path as user preference |  
| I'M NOT SATISFIED | Text Link | Navigates to Category Selection for manual choice |

\*\*Supporting Elements:\*\*  
\- Confetti animation for 5-star matches (optional)  
\- Skill requirement display  
\- Career path description (expandable)

\*\*Navigation Logic:\*\*  
\- Accept → Save career path → Freelancer Dashboard  
\- Not Satisfied → Category Selection Screen  
\- Explore → Show career details with sample jobs

\---

\#\#\# 1.8 Category Selection Screen (Expert/Manual Choice)

\*\*Purpose:\*\* Allow manual selection of job categories  
\*\*Page Description:\*\* A grid-style selection screen where users choose their preferred career categories from four options. Each category displays representative job titles to aid decision-making.

\*\*Visual Elements:\*\*

| Component | Type | Content |  
|-----------|------|---------|  
| Technology Card | Interactive Card | 💻 Icon, "Technology & Remote", sample jobs |  
| Creative Card | Interactive Card | 🎨 Icon, "Creative & Design", sample jobs |  
| Physical Card | Interactive Card | 🏗️ Icon, "Physical & Labor", sample jobs |  
| Service Card | Interactive Card | 🛎️ Icon, "Service & Public", sample jobs |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| CONTINUE | Orange (Primary) | Saves selections, navigates to Dashboard |  
| Back Arrow | Icon | Returns to previous screen |

\*\*Supporting Elements:\*\*  
\- Sample job titles displayed below each category  
\- Multi-select capability (users can choose multiple)  
\- Visual indicators for selected categories (orange border)

\*\*Navigation Logic:\*\*  
\- Expert flow → Select categories → Save → Freelancer Dashboard  
\- Beginner override → Select categories → Save → Freelancer Dashboard

\---

\#\# Section 2: Freelancer Experience

\#\#\# 2.1 Freelancer Dashboard

\*\*Purpose:\*\* Central hub for freelancer activities  
\*\*Page Description:\*\* A comprehensive dashboard providing quick access to all freelance functions while displaying critical status information at a glance. The layout prioritizes actionable information and one-tap access to key features.

\*\*Visual Elements:\*\*

\*\*Top Section (Header):\*\*  
\- Welcome message with user's display name  
\- Career path badge (selected category)  
\- Rating score display with color indicator  
\- Notification bell icon with badge count

\*\*Middle Section (Metrics Cards):\*\*

| Card | Content | Purpose |  
|------|---------|---------|  
| Profile Completeness | Circular progress bar, percentage | Motivates profile completion |  
| Rating Status | Current rating (-10 to \+10), color-coded | Shows professional standing |  
| Active Contracts | Count with "View All" button | Quick access to current work |  
| Total Jobs Done | Cumulative count | Career milestone tracking |

\*\*Quick Action Buttons:\*\*  
\- 🔍 FIND JOBS → Navigates to Smart Job Feed  
\- 📂 MY PORTFOLIO → Navigates to Portfolio Management  
\- 💬 MESSAGES → Navigates to Chat List  
\- 📋 MY PROPOSALS → Navigates to Proposals History

\*\*Bottom Section (Recent Activity):\*\*  
\- Recent notifications (last 3\)  
\- Job posting alerts  
\- Message previews  
\- Status updates

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| FIND JOBS | Orange (Primary) | Opens Smart Job Feed |  
| MY PORTFOLIO | Grey/White | Opens Portfolio Grid |  
| MESSAGES | Grey/White | Opens Chat List |  
| MY PROPOSALS | Grey/White | Opens Proposals History |  
| View All (on contracts) | Text Link | Navigates to full contract list |  
| Notification Bell | Icon | Opens Notification Center |

\*\*Navigation Logic:\*\*  
\- Find Jobs → Smart Job Feed  
\- My Portfolio → Portfolio Grid  
\- Messages → Chat List  
\- My Proposals → Proposals List  
\- Notification Bell → Notification Center  
\- Clicking any metric → Related detail view

\---

\#\#\# 2.2 Smart Job Feed

\*\*Purpose:\*\* Display personalized job recommendations  
\*\*Page Description:\*\* An infinite-scrolling list of job cards, each presenting key information at a glance. The feed prioritizes jobs matching the freelancer's selected career path while offering filtering options for broader discovery.

\*\*Visual Elements:\*\*

\*\*Filter Chips (Horizontal Scroll):\*\*  
| Filter | Function |  
|--------|----------|  
| Recommended | Jobs matching career path, highest relevance |  
| Newest | Chronological order, newest first |  
| Highest Pay | Sorted by compensation amount |  
| All Jobs | No filtering, shows everything |

\*\*Job Card Components:\*\*  
| Element | Content | Purpose |  
|---------|---------|---------|  
| Title | Job title | Identify opportunity |  
| Company | Client name | Source credibility |  
| Match Badge | Percentage | Relevance indicator |  
| Pay Range | 💰 $X \- $Y | Compensation transparency |  
| Duration | ⏱️ X days/months | Time commitment |  
| Location | 📍 Remote/Hybrid/On-site | Work setting |  
| Category Tag | Technology/Creative/Physical/Service | Type identification |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| Quick Apply | Orange (Secondary) | Opens Proposal Form with job pre-filled |  
| View Details | Text Link | Opens Job Detail Screen |  
| Filter Chips | Interactive | Refine job list |  
| Search Icon | Icon | Opens search bar |  
| Refresh | Icon | Reload feed with latest jobs |

\*\*Supporting Elements:\*\*  
\- Pull-to-refresh functionality  
\- Infinite scroll with pagination  
\- Empty state for no matching jobs  
\- Loading skeletons for better UX

\*\*Navigation Logic:\*\*  
\- Quick Apply → Proposal Form (pre-filled)  
\- View Details → Job Detail Screen  
\- Filter selection → Update feed in real-time  
\- Search → Display filtered results

\---

\#\#\# 2.3 Job Detail Screen

\*\*Purpose:\*\* Display comprehensive job information  
\*\*Page Description:\*\* A detailed view of a single job posting, presenting all relevant information for informed decision-making. The screen organizes content in logical sections from overview through application.

\*\*Visual Elements:\*\*

\*\*Header Section:\*\*  
\- Job title (large text)  
\- Match percentage badge  
\- Status indicator (Open, In Progress, etc.)  
\- Back navigation

\*\*Details Section:\*\*  
| Field | Content |  
|-------|---------|  
| Category | Job category badge |  
| Pay Range | 💰 $X \- $Y |  
| Duration | ⏱️ X days/months |  
| Location | 📍 Remote/Hybrid/On-site |

\*\*Description Section:\*\*  
\- Full job description text  
\- Required skills (chip tags)  
\- Additional requirements (if any)

\*\*Client Section:\*\*  
\- Client display name  
\- Client rating score  
\- Years on platform

\*\*Action Buttons:\*\*  
| Button | Color | Function |  
|--------|-------|----------|  
| APPLY NOW | Orange (Primary) | Opens Proposal Form |  
| SAVE JOB | Grey/White | Add to saved list |  
| SHARE | Icon | Share job link |

\*\*Navigation Logic:\*\*  
\- Apply Now → Proposal Form  
\- Save Job → Add to saved jobs collection  
\- Share → System share dialog

\---

\#\#\# 2.4 Proposal Form

\*\*Purpose:\*\* Submit job application with necessary details  
\*\*Page Description:\*\* A structured form that captures all information clients need to evaluate applicants. The form balances comprehensiveness with user-friendliness, showing progress and providing validation feedback.

\*\*Form Elements:\*\*

| Field | Type | Validation | Purpose |  
|-------|------|------------|---------|  
| Cover Letter | Text Area | Minimum 50 words | Introduce yourself, explain fit |  
| Proposed Rate | Number Input | Must be numeric | Negotiate compensation |  
| Estimated Timeline | Text Input | Must be filled | Set expectations |  
| Portfolio Items | Multi-select | Optional | Show relevant work |  
| Additional Notes | Text Area | Optional | Extra information |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| SUBMIT | Orange (Primary) | Submit proposal, show success |  
| SAVE DRAFT | Grey/White | Save progress, return later |  
| CANCEL | Text Link | Discard, return to job |  
| Attach Portfolio | Icon | Open portfolio selection |

\*\*Supporting Elements:\*\*  
\- Character counter for cover letter  
\- Sample rate suggestions based on job  
\- Progress indicator for multi-step forms  
\- Validation messages for each field

\*\*Navigation Logic:\*\*  
\- Submit → Success screen → Dashboard  
\- Save Draft → Return to Job Detail (draft saved)  
\- Cancel → Confirm discard → Return to Job Detail

\---

\#\#\# 2.5 Proposals List

\*\*Purpose:\*\* Track all submitted proposals  
\*\*Page Description:\*\* A categorized list showing the status of all proposals submitted by the freelancer. The interface helps users monitor application progress and understand outcomes.

\*\*Visual Elements:\*\*

\*\*Tab Navigation:\*\*  
| Tab | Content |  
|-----|---------|  
| Pending | Proposals awaiting client review |  
| Accepted | Proposals that became contracts |  
| Rejected | Proposals not selected |  
| Withdrawn | Proposals user withdrew |

\*\*Proposal Card Elements:\*\*  
| Element | Content |  
|---------|---------|  
| Job Title | Original job title |  
| Client Name | Name of hiring client |  
| Proposed Rate | Amount proposed |  
| Status Badge | Pending/Accepted/Rejected/Withdrawn |  
| Date Submitted | When applied |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| VIEW DETAILS | Text Link | See full proposal |  
| WITHDRAW | Red Text | Withdraw pending proposal |  
| OPEN CONTRACT | Orange (Secondary) | View accepted contract |

\*\*Navigation Logic:\*\*  
\- View Details → Proposal Detail  
\- Withdraw → Confirm → Remove from consideration  
\- Open Contract → Contract Detail

\---

\#\#\# 2.6 Portfolio Grid

\*\*Purpose:\*\* Display and manage portfolio items  
\*\*Page Description:\*\* A visual gallery showcasing the freelancer's work, organized in a grid layout. The interface supports adding, editing, and deleting portfolio items while maintaining a professional presentation.

\*\*Visual Elements:\*\*

\*\*Grid Items:\*\*  
| Element | Content |  
|---------|---------|  
| Thumbnail | First image from portfolio item |  
| Title | Project title overlay |  
| Category | Small badge |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| ADD NEW PROJECT | Orange (FAB) | Opens New Portfolio Form |  
| View Item | Tap on card | Opens Portfolio Detail |  
| Edit | Overflow menu | Edit portfolio item |  
| Delete | Overflow menu | Delete portfolio item |

\*\*New Portfolio Form:\*\*  
| Field | Type | Validation |  
|-------|------|------------|  
| Title | Text Input | Required |  
| Category | Dropdown | Required |  
| Description | Text Area | Optional |  
| Images | Image Picker | Minimum 1 required |

\*\*Navigation Logic:\*\*  
\- Add New → Portfolio Form  
\- View Item → Portfolio Detail (view-only for clients)  
\- Edit → Edit existing item  
\- Delete → Confirm → Remove

\---

\#\#\# 2.7 Chat List

\*\*Purpose:\*\* Overview of all active conversations  
\*\*Page Description:\*\* A sorted list of all chat conversations, prioritizing active contracts and showing unread message counts. The interface provides quick access to ongoing communications.

\*\*Visual Elements:\*\*

| Element | Content |  
|---------|---------|  
| Chat Item | Avatar, display name, last message preview, timestamp, unread badge |

\*\*Chat Item Elements:\*\*  
\- User avatar (circle)  
\- Display name  
\- Last message preview  
\- Timestamp  
\- Unread message count badge

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| OPEN CHAT | Tap on item | Opens individual chat |  
| Active Filter | Tab | Show only active conversations |  
| All Filter | Tab | Show all conversations |

\*\*Supporting Elements:\*\*  
\- Empty state for no messages  
\- Pull-to-refresh

\*\*Navigation Logic:\*\*  
\- Tap chat → Individual Chat Screen  
\- Filter → Display filtered list

\---

\#\#\# 2.8 Individual Chat Screen

\*\*Purpose:\*\* Real-time messaging with contract participants  
\*\*Page Description:\*\* A complete messaging interface showing conversation history with new messages appearing in real-time. The screen includes input field, send button, and message bubbles with appropriate styling.

\*\*Visual Elements:\*\*

\*\*Header:\*\*  
\- Back arrow  
\- Other party's display name  
\- Contract status indicator

\*\*Message Area:\*\*  
| Component | Description |  
|-----------|-------------|  
| Sent Messages | Orange bubbles on right |  
| Received Messages | Grey bubbles on left |  
| Timestamp | Small text below message |  
| System Messages | Centered text (e.g., "Contract started") |

\*\*Input Area:\*\*  
| Element | Description |  
|---------|-------------|  
| Text Input | Multi-line text field |  
| Send Button | Orange icon button |  
| Read-Only Banner | Visible when contract completed |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| SEND | Orange (Icon) | Send typed message |  
| Back Arrow | Icon | Return to Chat List |  
| Contract Status | Text Link | View Contract Detail |

\*\*Supporting Elements:\*\*  
\- Scroll to bottom on new message  
\- Typing indicator (optional)  
\- Read receipts (optional)  
\- Message timestamps

\*\*Navigation Logic:\*\*  
\- Send → Message appears, stored in Firestore  
\- Back → Chat List  
\- Status Link → Contract Detail

\---

\#\# Section 3: Client Experience

\#\#\# 3.1 Client Dashboard

\*\*Purpose:\*\* Central hub for client activities  
\*\*Page Description:\*\* A comprehensive dashboard showing job posting status, active contracts, and quick access to hiring functions. The layout prioritizes job management and applicant tracking.

\*\*Visual Elements:\*\*

\*\*Header:\*\*  
\- Welcome message with client name  
\- Rating display  
\- Notification bell

\*\*Metrics Cards:\*\*  
| Card | Content |  
|------|---------|  
| Active Jobs | Number of open postings |  
| Applications Received | Total proposals to review |  
| Active Contracts | Current engagements |  
| Rating | Client rating (-10 to \+10) |

\*\*Quick Action Buttons:\*\*  
\- 📝 POST JOB → New Job Form  
\- 📊 MY JOBS → Jobs List  
\- 💬 MESSAGES → Chat List  
\- 👤 PROFILE → Profile Settings

\*\*Recent Activity:\*\*  
\- New applications received  
\- Message notifications  
\- Contract updates

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| POST JOB | Orange (Primary) | Opens Job Posting Form |  
| MY JOBS | Grey/White | Opens Jobs List |  
| MESSAGES | Grey/White | Opens Chat List |  
| View All | Text Link | Full job list |

\*\*Navigation Logic:\*\*  
\- Post Job → Job Posting Form  
\- My Jobs → Jobs List  
\- Messages → Chat List  
\- Metrics → Related detail view

\---

\#\#\# 3.2 Job Posting Form

\*\*Purpose:\*\* Create new job opportunities  
\*\*Page Description:\*\* A comprehensive form for creating detailed job postings. The multi-step wizard guides clients through each section, ensuring complete information capture.

\*\*Form Elements:\*\*

| Section | Fields | Purpose |  
|---------|--------|---------|  
| Basic Information | Title, Category Dropdown | Job identification |  
| Description | Text Area (min 100 chars) | Work details |  
| Skills | Multi-select (min 3\) | Required qualifications |  
| Compensation | Pay Range (min/max) | Payment clarity |  
| Duration | Text Input | Timeline expectation |  
| Location | Location Type Dropdown, Location (conditional) | Work setting |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| POST JOB | Orange (Primary) | Submit job, make visible |  
| SAVE DRAFT | Grey/White | Save progress |  
| PREVIEW | Text Link | See job as freelancer would |  
| CANCEL | Text Link | Discard, return to dashboard |

\*\*Supporting Elements:\*\*  
\- Character counter for description  
\- Category-specific skill suggestions  
\- Location field appears when "On-site" selected  
\- Validation with error messages

\*\*Navigation Logic:\*\*  
\- Post → Success → Job Posted confirmation → Jobs List  
\- Save Draft → Save → Return later  
\- Preview → Preview screen → Back to edit  
\- Cancel → Confirm → Return to Dashboard

\---

\#\#\# 3.3 Jobs List (Client)

\*\*Purpose:\*\* Manage all job postings  
\*\*Page Description:\*\* A categorized list showing all jobs posted by the client, with status indicators and action buttons for each job.

\*\*Visual Elements:\*\*

\*\*Tab Navigation:\*\*  
| Tab | Content |  
|-----|---------|  
| Open | Jobs accepting applications |  
| In Progress | Jobs with selected freelancers |  
| Completed | Finished projects |  
| Cancelled | Jobs client cancelled |

\*\*Job Card Elements:\*\*  
| Element | Content |  
|---------|---------|  
| Title | Job title |  
| Status | Open/In Progress/Completed/Cancelled |  
| Applicants | Number of proposals |  
| Posted Date | When job was created |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| VIEW | Orange (Secondary) | Opens Job Detail |  
| EDIT | Grey/White | Edit job (only if open) |  
| CLOSE | Red Text | Close job early (confirmation) |  
| View Applicants | Text Link | See all proposals |

\*\*Navigation Logic:\*\*  
\- View → Job Detail (Client View)  
\- Edit → Job Posting Form (pre-filled)  
\- Close → Confirm → Job closed  
\- View Applicants → Proposals List (Client View)

\---

\#\#\# 3.4 Proposals List (Client View)

\*\*Purpose:\*\* Review and manage freelancer applications  
\*\*Page Description:\*\* A list of all proposals received for a specific job, presenting key candidate information for evaluation and selection.

\*\*Visual Elements:\*\*

\*\*Proposal Card:\*\*  
| Element | Content |  
|---------|---------|  
| Freelancer Info | Name, rating, profile photo |  
| Proposal Details | Proposed rate, timeline |  
| Cover Letter | Preview of application text |  
| Portfolio | Thumbnail previews |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| VIEW PROFILE | Grey/White | See freelancer's full profile |  
| CHAT | Grey/White | Open communication |  
| HIRE | Orange (Primary) | Select freelancer, create contract |

\*\*Sorting Options:\*\*  
| Sort | Function |  
|------|----------|  
| Rating | Highest rated first |  
| Rate | Lowest proposed rate first |  
| Experience | Most experienced first |

\*\*Navigation Logic:\*\*  
\- View Profile → Freelancer Profile (Public)  
\- Chat → Individual Chat Screen  
\- Hire → Confirm → Contract Created → Other applicants notified  
\- Reject → Proposal status updated to rejected (automatic when hiring another)

\---

\#\#\# 3.5 Contract Detail (Client/Freelancer Shared)

\*\*Purpose:\*\* View and manage active contracts  
\*\*Page Description:\*\* A comprehensive view showing all contract details, communication access, and completion controls for both parties.

\*\*Visual Elements:\*\*

\*\*Header:\*\*  
\- Contract title  
\- Status indicator  
\- Back navigation

\*\*Details Section:\*\*  
| Field | Content |  
|-------|---------|  
| Freelancer/Client | Name and rating |  
| Pay Amount | Agreed compensation |  
| Duration | Estimated timeline |  
| Start Date | When work began |  
| Status | Active/Completed/Read-Only |

\*\*Action Buttons:\*\*

| Button | Role | Function |  
|--------|------|----------|  
| OPEN CHAT | Both | Opens Chat Screen |  
| MARK COMPLETE | Both | Confirm work completion |  
| EXTEND DURATION | Client | Request duration extension |  
| VIEW HISTORY | Both | See contract history |

\*\*Completion Process:\*\*  
\- Both parties must click "Mark Complete"  
\- After both confirm → Chat becomes read-only  
\- Reviews become available

\*\*Navigation Logic:\*\*  
\- Open Chat → Individual Chat Screen  
\- Mark Complete → Confirmation dialog → Confirm → Contract status updated  
\- Extend Duration → Form → Submit → Notification to freelancer

\---

\#\# Section 4: Shared Features

\#\#\# 4.1 Profile Settings

\*\*Purpose:\*\* Manage user profile and account settings  
\*\*Page Description:\*\* A comprehensive settings screen allowing users to update personal information, manage privacy, and view account status.

\*\*Form Elements:\*\*

| Section | Fields | Purpose |  
|---------|--------|---------|  
| Personal Information | Display Name, Bio, Skills | Profile content |  
| Account Security | Email, Change Password | Account management |  
| Privacy | Notification preferences | Communication control |  
| Professional | Rating display, Career path | Professional standing |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| SAVE | Orange (Primary) | Save all changes |  
| CHANGE PASSWORD | Text Link | Open password change dialog |  
| LOG OUT | Red Text | Sign out of account |

\*\*Navigation Logic:\*\*  
\- Save → Update Firestore → Success message  
\- Change Password → Dialog → Update Firebase Auth  
\- Log Out → Confirm → Return to Login

\---

\#\#\# 4.2 Notification Center

\*\*Purpose:\*\* View and manage all notifications  
\*\*Page Description:\*\* A chronological list of all user notifications with read/unread status and action buttons for relevant notifications.

\*\*Visual Elements:\*\*

\*\*Notification Types:\*\*  
| Type | Content |  
|------|---------|  
| Proposal | "Freelancer applied to your job" |  
| Acceptance | "You've been hired for X" |  
| Rejection | "Client selected another freelancer" |  
| Message | "New message from X" |  
| Completion | "Contract completed" |  
| Rating | "You received a rating of X" |

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| Mark as Read | Text Link | Individual notification |  
| Mark All Read | Text Link | All notifications |  
| Clear All | Text Link | Delete all notifications |

\*\*Navigation Logic:\*\*  
\- Tap notification → Navigate to relevant screen  
\- Mark Read → Update status  
\- Clear → Remove notification

\---

\#\#\# 4.3 Rating Screen

\*\*Purpose:\*\* Submit performance evaluation  
\*\*Page Description:\*\* A dedicated screen for providing feedback after contract completion, featuring a slider for \-10 to \+10 rating and optional text feedback.

\*\*Visual Elements:\*\*

\*\*Rating Slider:\*\*  
\- \-10 to \+10 range  
\- Color-coded: Red (negative) to Green (positive)  
\- Haptic feedback on movement  
\- Current value displayed

\*\*Feedback Area:\*\*  
\- Text area for optional comments  
\- Character counter

\*\*Buttons and Functions:\*\*

| Button | Color | Function |  
|--------|-------|----------|  
| SUBMIT | Orange (Primary) | Submit rating |  
| SKIP | Text Link | Skip rating (optional) |

\*\*Navigation Logic:\*\*  
\- Submit → Confirmation → Return to Dashboard  
\- Skip → Return to Dashboard

\---

\#\# Section 5: Complete Page Navigation Map

\#\#\# Freelancer Navigation Tree  
\`\`\`  
Splash Screen  
    │  
    ▼  
Login/Sign Up  
    │  
    ├─── Freelancer ──┬─── Beginner ──► Q\&A ──► ML Results ──► Category Selection (if reject)  
    │                 │                              │  
    │                 │                              ▼  
    │                 │                        Freelancer Dashboard  
    │                 │                              │  
    │                 └─── Expert ──► Category Selection ──► Freelancer Dashboard  
    │  
    └─── Client ──────────────────────────────────────► Client Dashboard

FREELANCER DASHBOARD  
    │  
    ├─── Find Jobs ──► Smart Job Feed  
    │                      │  
    │                      ├─── Quick Apply ──► Proposal Form  
    │                      │                      │  
    │                      │                      └─── Submit ──► Success ──► Dashboard  
    │                      │  
    │                      └─── View Details ──► Job Detail  
    │                                              │  
    │                                              └─── Apply ──► Proposal Form  
    │  
    ├─── My Proposals ──► Proposals List  
    │                        │  
    │                        ├─── Pending ──► Withdraw ──► Confirmation  
    │                        │  
    │                        ├─── Accepted ──► Contract Detail  
    │                        │  
    │                        └─── Rejected ──► View Only  
    │  
    ├─── Active Contracts ──► Contract List  
    │                             │  
    │                             └─── Open Chat ──► Chat Screen  
    │                                                     │  
    │                                                     └─── Send Message ──► Real-time Update  
    │  
    ├─── Portfolio ──► Portfolio Grid  
    │                     │  
    │                     ├─── Add New ──► Portfolio Form  
    │                     │                      │  
    │                     │                      └─── Submit ──► Grid Update  
    │                     │  
    │                     └─── Edit ──► Portfolio Form (pre-filled)  
    │  
    ├─── Messages ──► Chat List  
    │                    │  
    │                    └─── Open Chat ──► Chat Screen  
    │  
    └─── Profile ──► Profile Settings  
                       │  
                       ├─── Edit ──► Save ──► Dashboard  
                       │  
                       └─── Log Out ──► Login Screen

CONTRACT COMPLETION FLOW (Both Roles)  
    │  
    └─── Mark Complete ──► Confirmation Dialog  
                              │  
                              ├─── Both Confirm ──► Contract Complete ──► Chat Lock  
                              │                                         │  
                              │                                         ▼  
                              │                                   Rating Screen  
                              │                                         │  
                              │                                         └─── Submit/Skip ──► Dashboard  
                              │  
                              └─── One Party Only ──► Wait for Other  
\`\`\`

\#\#\# Client Navigation Tree  
\`\`\`  
CLIENT DASHBOARD  
    │  
    ├─── Post Job ──► Job Posting Form  
    │                    │  
    │                    └─── Post ──► Success ──► Jobs List  
    │  
    ├─── My Jobs ──► Jobs List  
    │                  │  
    │                  ├─── Open ──► View Job ──► Proposals List  
    │                  │                    │  
    │                  │                    ├─── View Profile ──► Freelancer Profile  
    │                  │                    │  
    │                  │                    ├─── Chat ──► Chat Screen  
    │                  │                    │  
    │                  │                    └─── Hire ──► Confirm ──► Contract Created  
    │                  │                                              │  
    │                  │                                              ├─── Other Applicants Notified  
    │                  │                                              │  
    │                  │                                              └─── Chat Opens  
    │                  │  
    │                  ├─── In Progress ──► Contract Detail  
    │                  │                        │  
    │                  │                        ├─── Open Chat ──► Chat Screen  
    │                  │                        │  
    │                  │                        └─── Mark Complete ──► Confirmation  
    │                  │  
    │                  └─── Completed ──► Contract History  
    │  
    ├─── Messages ──► Chat List  
    │                    │  
    │                    └─── Open Chat ──► Chat Screen  
    │  
    └─── Profile ──► Profile Settings  
                       │  
                       ├─── Edit ──► Save ──► Dashboard  
                       │  
                       └─── Log Out ──► Login Screen  
\`\`\`

\---

\#\# Section 6: Key Interaction Summary

\#\#\# Button Color Coding  
| Color | Usage |  
|-------|-------|  
| Orange (\#FF6B00) | Primary actions, important calls-to-action |  
| White/Grey (\#FFFFFF/\#9E9E9E) | Secondary actions, navigation |  
| Red (\#D32F2F) | Destructive actions, warnings, withdrawal |  
| Text Links | Navigation, informational actions |

\#\#\# Form Validation Patterns  
| Validation Type | Implementation |  
|-----------------|----------------|  
| Required Field | Red border with "\*" indicator |  
| Email Format | Regular expression validation |  
| Password Strength | Visual strength indicator |  
| Character Count | Live counter with limit |  
| Numeric Range | Min/max validation with error message |

\#\#\# Navigation Patterns  
| Pattern | Implementation |  
|---------|----------------|  
| Bottom Navigation | Role-specific tabs (Freelancer: 5, Client: 4\) |  
| Back Navigation | System back button plus custom back arrow |  
| Deep Linking | Notification taps navigate to relevant screens |  
| Modal Dialogs | Confirmations, alerts, and forms |

**\# CareerCraft: Machine Learning System Design and Dataset Architecture**

\---

\#\# Introduction to the Machine Learning Component

The machine learning system at the heart of CareerCraft represents a thoughtful integration of artificial intelligence into the freelance career discovery process. Unlike conventional freelancing platforms that simply present all available jobs indiscriminately, CareerCraft employs a lightweight predictive model to guide users toward career paths aligned with their natural inclinations, skills, and work preferences. This intelligent guidance system serves as the cornerstone of the platform's value proposition, transforming a simple job marketplace into a genuine career development tool.

The ML system operates on a fundamental principle: understanding a person's characteristics and preferences enables accurate prediction of career satisfaction and success. By collecting responses to carefully designed questions about technical aptitude, communication skills, work environment preferences, and physical capabilities, the system builds a comprehensive profile that maps to specific job categories. This approach acknowledges that career fulfillment depends on alignment between individual characteristics and job requirements—a software developer who prefers solitary work will thrive in different environments than a customer service representative who draws energy from social interaction.

\#\# The Machine Learning Model Architecture

CareerCraft implements a supervised classification model trained on a purpose-built dataset of 4,000 synthetic samples. The model architecture employs a Random Forest classifier, chosen for its interpretability, robustness to outliers, and excellent performance on tabular data with mixed feature types. Random Forest's ensemble approach—combining hundreds of decision trees—provides reliable predictions even with the relatively small dataset size, making it ideal for an academic project with practical constraints.

The model accepts ten feature inputs, each representing a specific user characteristic collected through the visual skill assessment. These features include a mix of categorical variables (qualification level, work location preference, salary expectation) and continuous variables (technical aptitude, communication skill, physical endurance). This diverse feature set captures the multidimensional nature of career suitability, recognizing that no single factor determines professional success.

\*\*Model Training Process:\*\*  
The model was trained using the custom dataset where each of 4,000 samples represents a synthetic user profile with known career class labels. The training process follows standard machine learning methodology—80% of samples (3,200) used for training, 20% (800) reserved for testing. Cross-validation ensures the model generalizes well to unseen data, preventing overfitting to specific patterns in the training set. The Random Forest algorithm builds 100 decision trees, each trained on random subsets of data and features, then aggregates their predictions through majority voting.

\*\*Model Output:\*\*  
The model predicts one of four career classes, each containing ten specific job titles. Rather than simply returning a class label, the system provides probability scores for all four classes, enabling confidence-based decision-making. If the highest probability exceeds 60%, the system confidently recommends that category; if all probabilities remain low, the system presents the top three possibilities with appropriate disclaimers. This probabilistic approach acknowledges the inherent uncertainty in career prediction while providing actionable guidance.

\*\*Inference Location:\*\*  
CareerCraft performs all model inference directly on the Android device using TensorFlow Lite, a lightweight version of TensorFlow optimized for mobile deployment. This on-device inference offers three critical advantages: zero latency predictions (no network calls required), complete user privacy (responses never leave the device), and offline functionality (predictions work without internet connectivity). The model, converted to TensorFlow Lite format, is bundled with the application, occupying minimal storage space while delivering instantaneous career recommendations.

\#\# The Custom Dataset: Design and Construction

\#\#\# Dataset Overview

The CareerCraft dataset represents a carefully constructed synthetic corpus of 4,000 samples, perfectly balanced across four career classes with 1,000 samples each. This balance ensures the machine learning model learns equally well across all categories, preventing bias toward majority classes. Each sample contains ten feature values representing a user's profile, along with two target variables—the career class (0-3) and a specific job title from the corresponding class.

\*\*Dataset Size and Composition:\*\*  
| Property | Value |  
|----------|-------|  
| Total Samples | 4,000 |  
| Classes | 4 |  
| Samples per Class | 1,000 (perfectly balanced) |  
| Features | 10 (7 continuous, 3 categorical) |  
| Target Variables | 2 (class ID, job title) |  
| Total Jobs | 40 (10 per class) |

\#\#\# Feature Engineering

The ten features were selected based on career counseling research and practical considerations of job requirements. Each feature captures a distinct dimension of user characteristics, ensuring comprehensive profile representation while maintaining simplicity for user assessment.

\*\*Continuous Features (1-10 Scale):\*\*

| Feature | Description | Range | Purpose |  
|---------|-------------|-------|---------|  
| Technical Aptitude | Comfort and skill with technology | 1-10 | Identifies suitability for tech roles |  
| Communication Skill | Verbal and written communication ability | 1-10 | Critical for client-facing roles |  
| Team Work Preference | Preference for collaborative vs. solo work | 1-10 | Determines work environment fit |  
| Physical Endurance | Capacity for physical labor | 1-10 | Essential for physical jobs |  
| Outdoor Work Preference | Enjoyment of outdoor environments | 1-10 | Differentiates indoor/outdoor roles |  
| Preferred Hours/Day | Desired daily work hours | 1-12 | Matches job scheduling requirements |  
| Years Experience | Professional experience | 0-20 | Indicates skill level |

\*\*Categorical Features:\*\*

| Feature | Options | Purpose |  
|---------|---------|---------|  
| Qualification Level | High School, Diploma, Bachelor's, Master's, PhD | Educational requirement matching |  
| Work Location Preference | Remote, Hybrid, On-site | Work style preference |  
| Salary Expectation | Low, Medium, High | Compensation alignment |

\#\#\# Class Distribution and Job Mapping

The four career classes represent broad occupational categories, each containing ten specific job titles. This hierarchical structure enables the model to provide both high-level career guidance and specific job recommendations.

\*\*Class 0: Technology & Remote Work (1,000 samples)\*\*

This class encompasses knowledge workers who excel in technical environments, typically preferring independent work with minimal physical demands. These roles require strong technical aptitude, moderate to high communication skills, and comfort with remote or hybrid work arrangements.

\*Jobs within this class:\*  
1\. Software Engineer  
2\. Mobile App Developer  
3\. Web Developer  
4\. Data Scientist  
5\. DevOps Engineer  
6\. Cloud Architect  
7\. Machine Learning Engineer  
8\. Game Developer  
9\. Database Administrator  
10\. Systems Analyst

\*Typical feature patterns:\* High technical aptitude (6-10), moderate communication skills (4-9), moderate team preference (3-9), low physical endurance (1-5), low outdoor preference (1-4), 4-9 hours daily, higher qualifications (Bachelor's+, 40% Masters).

\*\*Class 1: Creative & Design (1,000 samples)\*\*

Creative professionals who combine artistic sensibility with technical skills, often working in collaborative environments. These roles require strong communication, moderate technical aptitude, and appreciation for aesthetic quality.

\*Jobs within this class:\*  
1\. Graphic Designer  
2\. UI/UX Designer  
3\. Content Writer  
4\. Social Media Manager  
5\. Video Editor  
6\. Photographer  
7\. Digital Marketer  
8\. Copywriter  
9\. Animator  
10\. Brand Strategist

\*Typical feature patterns:\* Moderate technical aptitude (3-8), high communication skills (6-10), high team preference (4-10), low physical endurance (1-4), moderate outdoor preference (1-5), 3-8 hours daily, Diploma to Bachelor's (50% Bachelor's).

\*\*Class 2: Physical & Labor (1,000 samples)\*\*

Workers in physically demanding roles requiring endurance and often outdoor work. These positions typically require less formal education but may offer stable, long-term employment.

\*Jobs within this class:\*  
1\. Security Guard  
2\. Warehouse Worker  
3\. Delivery Driver  
4\. Construction Worker  
5\. Factory Operator  
6\. Janitor  
7\. Landscaper  
8\. Maintenance Technician  
9\. Farm Worker  
10\. Food Service Worker

\*Typical feature patterns:\* Low technical aptitude (1-6), moderate communication (2-7), moderate team preference (3-8), high physical endurance (7-10), high outdoor preference (6-10), 6-12 hours daily, High School or Diploma (85%).

\*\*Class 3: Service & Public Facing (1,000 samples)\*\*

Service professionals who interact directly with customers or clients, requiring strong communication skills and moderate physical activity in indoor settings.

\*Jobs within this class:\*  
1\. Cashier  
2\. Receptionist  
3\. Call Center Agent  
4\. Retail Sales Associate  
5\. Waiter/Waitress  
6\. Barista  
7\. Front Desk Clerk  
8\. Store Manager  
9\. Customer Service Rep  
10\. Administrative Assistant

\*Typical feature patterns:\* Moderate technical aptitude (2-7), high communication (7-10), high team preference (5-10), moderate physical endurance (3-7), moderate outdoor preference (2-6), 5-10 hours daily, High School to Diploma (75%).

\#\#\# Dataset Generation Logic

The dataset was generated with careful attention to creating realistic, non-discriminatory patterns. A critical design principle ensures that high qualifications do not automatically force users into technology roles. The generation logic uses weighted random sampling to create overlaps between classes, mimicking real-world scenarios where individuals with diverse backgrounds might pursue various career paths.

For each class, the generation function assigns feature values using distinct probability distributions. These distributions create characteristic patterns for each class while maintaining overlap, preventing the model from learning simplistic correlations. For example, while Technology class samples typically have higher technical aptitude (distribution centered around 8), some samples in this class have moderate technical aptitude (5-6), representing individuals who may have pursued technology careers despite moderate natural inclination.

Similarly, Physical class samples generally have lower formal qualifications (High School/Diploma) but include some Bachelor's degree holders who prefer physical work. This inclusion of "outlier" samples prevents the model from making discriminatory assumptions about individuals based solely on education level. The guiding principle is that user preferences should outweigh qualifications—a Master's degree holder who wants physical labor should receive Physical class recommendations, not Technology class recommendations.

\#\#\# Feature Distributions by Class

\*\*Technical Aptitude:\*\*  
\- Technology: Mean 8.2, Range 6-10 (high, little variation)  
\- Creative: Mean 5.5, Range 3-8 (moderate, broader variation)  
\- Physical: Mean 3.5, Range 1-6 (low, with some outliers)  
\- Service: Mean 4.5, Range 2-7 (moderate-low)

\*\*Communication Skill:\*\*  
\- Technology: Mean 6.5, Range 4-9 (moderate-high)  
\- Creative: Mean 8.0, Range 6-10 (high)  
\- Physical: Mean 4.5, Range 2-7 (moderate-low)  
\- Service: Mean 8.5, Range 7-10 (high)

\*\*Physical Endurance:\*\*  
\- Technology: Mean 3.0, Range 1-5 (low)  
\- Creative: Mean 2.5, Range 1-4 (low)  
\- Physical: Mean 8.5, Range 7-10 (high)  
\- Service: Mean 5.0, Range 3-7 (moderate)

\*\*Preferred Hours Per Day:\*\*  
\- Technology: Mean 6.5, Range 4-9  
\- Creative: Mean 5.5, Range 3-8  
\- Physical: Mean 9.0, Range 6-12  
\- Service: Mean 7.5, Range 5-10

\#\# Integration with the Application

\#\#\# User Flow Integration

The ML system integrates seamlessly into the user onboarding flow, activating specifically for beginner freelancers who select the guided pathway. The integration follows a carefully designed sequence:

1\. \*\*User Completes Assessment:\*\* The Visual Skill Assessment presents dynamic questions, collecting all ten feature values through interactive slider and multiple-choice inputs.

2\. \*\*Feature Vector Construction:\*\* The application maps user responses to feature values, creating a ten-dimensional vector matching the model's input format. Categorical responses (qualification level, location preference, salary expectation) are encoded numerically using predefined mappings.

3\. \*\*Model Inference:\*\* The feature vector passes through the TensorFlow Lite model, which returns probability scores for all four classes. The system extracts the highest probability class and associated confidence.

4\. \*\*Result Display:\*\* The application presents the top three job titles from the predicted class, showing match percentages and required skills. The user can accept these recommendations or override with manual selection.

5\. \*\*Preference Persistence:\*\* Upon acceptance, the predicted career path saves to the user's profile in Firestore. This preference then powers the Smart Job Feed, ensuring all subsequent job recommendations align with the user's chosen career direction.

\#\#\# Fallback System Implementation

To ensure reliability across all Android devices, CareerCraft implements a robust rule-based fallback system that activates when TensorFlow Lite fails to load. This could occur on older devices with limited hardware support, corrupted model files, or other technical issues. The fallback system produces identical outputs to the ML model, maintaining seamless user experience regardless of underlying implementation.

\*\*Rule-Based Logic:\*\*  
The fallback system calculates weighted scores for each class based on feature thresholds. Each class has defined "ideal" feature ranges, and the system computes how closely the user's profile matches each class. The class with the highest weighted score becomes the recommendation, with confidence approximated from the score differential.

\*Example rules:\*  
\- If technical\_aptitude \> 7 and physical\_endurance \< 4 and preferred\_hours \< 8 → Score Technology highly  
\- If communication\_skill \> 7 and technical\_aptitude \< 7 → Score Creative/Social highly  
\- If physical\_endurance \> 7 and preferred\_hours \> 8 → Score Physical highly  
\- If communication\_skill \> 7 and physical\_endurance \> 4 and \< 7 → Score Service highly

\*\*Key Principle:\*\* The fallback system, like the ML model, must never show users they are being "classified" or discriminated against. The user experience remains identical—they see job suggestions with match percentages, never class labels or category names that might feel reductive or judgmental.

\#\#\# Model Updates and Maintenance

While the current model version is bundled with the application, the architecture supports future updates without requiring full app reinstallation. The model file can be downloaded from Firebase Storage on app launch if a newer version exists, enabling continuous improvement without user intervention. This over-the-air update mechanism ensures the platform can evolve as more real user data becomes available or as job market dynamics shift.

\*\*Training Data Evolution:\*\*  
Future versions of the model could incorporate real user data collected through the application. As more freelancers complete assessments and successfully find work in their recommended categories, the platform could use this feedback to refine its predictions. This creates a virtuous cycle—better predictions lead to better user outcomes, which provide better training data for future models.

\#\# Model Limitations and Ethical Considerations

CareerCraft's ML system is designed with clear boundaries and ethical considerations. The system provides guidance, not deterministic decision-making. Users always retain the ability to override recommendations and manually select career paths. This preserves individual agency while leveraging AI for insight rather than control.

\*\*Key Limitations:\*\*  
1\. The model was trained on synthetic data, not real-world employment outcomes. While the data is logically consistent, it cannot capture all nuances of career success.  
2\. Career satisfaction depends on many factors not captured in the ten features, including personal passion, market conditions, and interpersonal dynamics.  
3\. The model provides recommendations based on user-provided responses, which may reflect current self-perception rather than actual capabilities.  
4\. Job markets evolve rapidly; model predictions reflect current conditions but may not anticipate future trends.

\*\*Ethical Safeguards:\*\*  
1\. Users never see class labels or category names that might carry social stigma.  
2\. All users, regardless of predicted class, receive equal access to all platform features.  
3\. The system never stores or shares user responses outside the secure Firebase environment.  
4\. Users can always choose the expert pathway, bypassing the ML system entirely.  
5\. The platform maintains transparency about the role of AI without overpromising outcomes.

\#\# Conclusion

The CareerCraft machine learning system represents a thoughtful, ethical integration of artificial intelligence into the career discovery process. By combining a well-designed synthetic dataset, a robust Random Forest classifier, and intelligent fallback mechanisms, the platform provides personalized career guidance without sacrificing user privacy or agency. The system's architecture acknowledges the complexity of career decisions while providing practical, actionable recommendations. Most importantly, the ML component operates invisibly in the background, delivering value without drawing attention to itself—users simply see relevant job suggestions and feel understood rather than "classified."

The dataset's careful construction ensures balanced, non-discriminatory predictions across all career categories, while the on-device inference preserves privacy and enables instant responses. This approach demonstrates how machine learning, when thoughtfully applied, can enhance user experience without introducing the risks typically associated with algorithmic decision-making. CareerCraft's ML system doesn't define users—it simply helps them discover paths they might not have considered, empowering informed career decisions.

**Prominent Instructions To From Developer**

This will be an android app and i want it to host it. The database must also be online so that users can dynamically participate in the running app. I will work in windows 11 Android Studio. Keep that in mind that the scope of this app is not that high. This is going to be an academic project. The ML part that i have included is just for an experience like how a model can work inside an app that have been trained on a preexisting dataset that we prepared. I want to keep things very simple. But i must host this app at free of cost. The app must deal with user images too, apart from the text and numerical details. The front end should be very very polished and simple. I to use only a few colors in this entire app: black, white, grey, orange(prominent buttons). You can consider Uber app's polished color, buttons, interface to get an idea about the front end. Simple but very polished. Plus the screen must be rotated and should be able to fit in any screen size. The constraints should not be hard coded, rather they should be flexible. keep the file names very catchy. After the work i want a documentations of which file is doing what and contains what. It must also include the file desciptions which responsible for database connection and hosting details.  