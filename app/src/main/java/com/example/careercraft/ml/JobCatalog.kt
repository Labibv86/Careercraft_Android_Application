package com.example.careercraft.ml

data class JobSuggestion(val title: String, val skills: String)

object JobCatalog {
    private val technology = listOf(
        JobSuggestion("Software Engineer", "Java, Algorithms, Git"),
        JobSuggestion("Mobile App Developer", "Kotlin, Android, Firebase"),
        JobSuggestion("Web Developer", "HTML, CSS, JavaScript"),
        JobSuggestion("Data Scientist", "Python, SQL, Statistics"),
        JobSuggestion("DevOps Engineer", "CI/CD, Docker, Cloud"),
        JobSuggestion("Cloud Architect", "AWS, Networking, Security"),
        JobSuggestion("Machine Learning Engineer", "Python, TensorFlow, Math"),
        JobSuggestion("Game Developer", "Unity, C#, 3D Math"),
        JobSuggestion("Database Administrator", "SQL, Backup, Tuning"),
        JobSuggestion("Systems Analyst", "Requirements, Documentation")
    )
    private val creative = listOf(
        JobSuggestion("Graphic Designer", "Photoshop, Illustrator, Layout"),
        JobSuggestion("UI/UX Designer", "Figma, Wireframing, Research"),
        JobSuggestion("Content Writer", "Writing, SEO, Editing"),
        JobSuggestion("Social Media Manager", "Content, Scheduling, Analytics"),
        JobSuggestion("Video Editor", "Premiere, Storytelling, Pacing"),
        JobSuggestion("Photographer", "Composition, Lighting, Editing"),
        JobSuggestion("Digital Marketer", "Ads, SEO, Analytics"),
        JobSuggestion("Copywriter", "Writing, Persuasion, Branding"),
        JobSuggestion("Animator", "After Effects, Timing, Design"),
        JobSuggestion("Brand Strategist", "Positioning, Research, Messaging")
    )
    private val physical = listOf(
        JobSuggestion("Security Guard", "Alertness, Reporting"),
        JobSuggestion("Warehouse Worker", "Lifting, Inventory"),
        JobSuggestion("Delivery Driver", "Driving, Time Management"),
        JobSuggestion("Construction Worker", "Physical Stamina, Tools"),
        JobSuggestion("Factory Operator", "Machinery, Precision"),
        JobSuggestion("Janitor", "Cleaning, Reliability"),
        JobSuggestion("Landscaper", "Physical Stamina, Outdoor Work"),
        JobSuggestion("Maintenance Technician", "Repairs, Troubleshooting"),
        JobSuggestion("Farm Worker", "Outdoor Work, Physical Stamina"),
        JobSuggestion("Food Service Worker", "Speed, Hygiene")
    )
    private val service = listOf(
        JobSuggestion("Cashier", "Accuracy, Customer Service"),
        JobSuggestion("Receptionist", "Communication, Organization"),
        JobSuggestion("Call Center Agent", "Communication, Patience"),
        JobSuggestion("Retail Sales Associate", "Communication, Product Knowledge"),
        JobSuggestion("Waiter/Waitress", "Communication, Speed"),
        JobSuggestion("Barista", "Communication, Multitasking"),
        JobSuggestion("Front Desk Clerk", "Communication, Organization"),
        JobSuggestion("Store Manager", "Leadership, Communication"),
        JobSuggestion("Customer Service Rep", "Communication, Patience"),
        JobSuggestion("Administrative Assistant", "Organization, Communication")
    )

    private val byClass = mapOf(0 to technology, 1 to creative, 2 to physical, 3 to service)
    private val classNames = mapOf(0 to "Technology & Remote Work", 1 to "Creative & Design", 2 to "Physical & Labor", 3 to "Service & Public Facing")

    fun jobsFor(careerClass: Int): List<JobSuggestion> = byClass[careerClass] ?: emptyList()
    fun nameFor(careerClass: Int): String = classNames[careerClass] ?: "Unknown"
}