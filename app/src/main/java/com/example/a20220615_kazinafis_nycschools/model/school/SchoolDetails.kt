package com.example.a20220615_kazinafis_nycschools.model.school

import com.squareup.moshi.Json

data class SchoolDetails(
    val dbn: String?,
    @Json(name = "school_name")
    val schoolName: String?,
    @Json(name = "num_of_sat_test_takers")
    val numOfSatTestTakers: String?,
    @Json(name = "sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String?,
    @Json(name = "sat_math_avg_score")
    val satMathAvgScore: String?,
    @Json(name = "sat_writing_avg_score")
    val satWritingAvgScore: String?

)
