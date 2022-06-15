package com.example.a20220615_kazinafis_nycschools.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.a20220615_kazinafis_nycschools.R
import com.example.a20220615_kazinafis_nycschools.databinding.FragmentSchoolDetailsBinding
import com.example.a20220615_kazinafis_nycschools.model.school.SchoolDetails
import com.example.a20220615_kazinafis_nycschools.viewmodel.SchoolApiStatus
import com.example.a20220615_kazinafis_nycschools.viewmodel.SchoolDetailsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SchoolDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchoolDetailsFragment: Fragment() {

    private val viewModel: SchoolDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Gets the data from the passed bundle
        val bundle = arguments
        val dbn_value = bundle!!.getString("DBN_Value")

        // Inflate the layout for this fragment
        val binding = FragmentSchoolDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.schoolDetailsViewModel = viewModel
        if (dbn_value != null) {
            viewModel.getSchoolDetails(dbn_value)
        }

        viewModel.status.observe(viewLifecycleOwner, Observer { status ->
            when(status) {
                SchoolApiStatus.LOADING -> {
                    Toast.makeText(context, "Fetching data.", Toast.LENGTH_SHORT).show()
                }
                SchoolApiStatus.ERROR -> {
                    Toast.makeText(context, "Please check your internet connection and try again later.", Toast.LENGTH_LONG).show()
                }
                SchoolApiStatus.DONE -> {
                    Toast.makeText(context, "Successfully received data.", Toast.LENGTH_LONG).show()
                }
            }
        })

        return binding.root
    }

}