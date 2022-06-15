package com.example.a20220615_kazinafis_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20220615_kazinafis_nycschools.model.network.SchoolApi
import com.example.a20220615_kazinafis_nycschools.model.school.School
import kotlinx.coroutines.launch
import java.lang.Exception

enum class SchoolApiStatus {LOADING, ERROR, DONE}

class SchoolViewModel : ViewModel() {

    private val _status = MutableLiveData<SchoolApiStatus>()
    val status : LiveData<SchoolApiStatus> = _status

    private val _schools = MutableLiveData<List<School>>()
    val schools : LiveData<List<School>> = _schools

    init {
        getNYCSchools()
    }

    private fun getNYCSchools() {
        viewModelScope.launch {
            _status.value = SchoolApiStatus.LOADING
            try {
                _schools.value = SchoolApi.retrofitService.getSchoolList()
                _status.value = SchoolApiStatus.DONE
            } catch (e: Exception) {
                _schools.value = listOf()
                _status.value = SchoolApiStatus.ERROR
            }
        }
    }
}