package com.example.a20220615_kazinafis_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20220615_kazinafis_nycschools.model.network.SchoolApi
import com.example.a20220615_kazinafis_nycschools.model.school.SchoolDetails
import kotlinx.coroutines.launch
import java.lang.Exception

class SchoolDetailsViewModel : ViewModel() {

    private val _status = MutableLiveData<SchoolApiStatus>()
    val status : LiveData<SchoolApiStatus> = _status

    private val _schoolDetails = MutableLiveData<SchoolDetails>()
    val schoolDetails: LiveData<SchoolDetails> = _schoolDetails

    init {

    }

    fun getSchoolDetails(dbn: String) {
        viewModelScope.launch {
            _status.value = SchoolApiStatus.LOADING
            try {
                _schoolDetails.value = SchoolApi.retrofitService.getSchoolDetails(dbn)[0]
                _status.value = SchoolApiStatus.DONE
            } catch (e: Exception) {
                _status.value = SchoolApiStatus.ERROR
            }
        }
    }
}