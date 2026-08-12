package com.example.careercraft.ml

object FeatureVectorBuilder {

    private val qualificationLevels = listOf("High School", "Diploma", "Bachelor's", "Master's", "PhD")
    private val locationPreferences = listOf("Remote", "Hybrid", "On-site")
    private val salaryExpectations = listOf("Low", "Medium", "High")

    // Order MUST match training: technical_aptitude, communication_skill, prefers_team_work,
    // physical_endurance, prefers_outdoor_work, preferred_hours_per_day,
    // qualification_level, work_location_preference, salary_expectation
    fun build(answers: Map<String, Any>): DoubleArray {
        return doubleArrayOf(
            sliderValue(answers, "technical_aptitude", 1, 10),
            sliderValue(answers, "communication_skill", 1, 10),
            sliderValue(answers, "prefers_team_work", 1, 10),
            sliderValue(answers, "physical_endurance", 1, 10),
            sliderValue(answers, "prefers_outdoor_work", 1, 10),
            sliderValue(answers, "preferred_hours_per_day", 1, 12),
            categoricalIndex(answers, "qualification_level", qualificationLevels).toDouble(),
            categoricalIndex(answers, "work_location_preference", locationPreferences).toDouble(),
            categoricalIndex(answers, "salary_expectation", salaryExpectations).toDouble()
        )
    }

    private fun sliderValue(answers: Map<String, Any>, key: String, min: Int, max: Int): Double {
        val raw = answers[key]
        return if (raw is Int) raw.toDouble() else ((min + max) / 2.0)
    }

    private fun categoricalIndex(answers: Map<String, Any>, key: String, options: List<String>): Int {
        val raw = answers[key] as? String
        val index = options.indexOf(raw)
        return if (index >= 0) index else options.size / 2
    }
}