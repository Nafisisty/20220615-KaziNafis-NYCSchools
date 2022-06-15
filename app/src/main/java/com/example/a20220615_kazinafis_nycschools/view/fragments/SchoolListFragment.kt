package com.example.a20220615_kazinafis_nycschools.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.a20220615_kazinafis_nycschools.databinding.FragmentSchoolListBinding
import com.example.a20220615_kazinafis_nycschools.view.adapters.SchoolListAdapter
import com.example.a20220615_kazinafis_nycschools.viewmodel.SchoolApiStatus
import com.example.a20220615_kazinafis_nycschools.viewmodel.SchoolViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SchoolListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchoolListFragment : Fragment() {

    private val viewModel: SchoolViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSchoolListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.schoolsRecyclerView.adapter = SchoolListAdapter()

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