package com.example.a20220615_kazinafis_nycschools.model.network

import com.example.a20220615_kazinafis_nycschools.model.Constants.Companion.BASE_URL
import com.example.a20220615_kazinafis_nycschools.model.Constants.Companion.QUERY
import com.example.a20220615_kazinafis_nycschools.model.Constants.Companion.SCHOOL_DETAILS_PATH
import com.example.a20220615_kazinafis_nycschools.model.Constants.Companion.SCHOOL_LIST_PATH
import com.example.a20220615_kazinafis_nycschools.model.school.School
import com.example.a20220615_kazinafis_nycschools.model.school.SchoolDetails
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object SchoolApi {
    val retrofitService : SchoolApiService by lazy {
        retrofit.create(SchoolApiService::class.java)
    }
}

interface SchoolApiService {
    @GET(SCHOOL_LIST_PATH)
    suspend fun getSchoolList() : List<School>

    @GET(SCHOOL_DETAILS_PATH)
    suspend fun getSchoolDetails(@Query(QUERY) dbn: String) : List<SchoolDetails>
}