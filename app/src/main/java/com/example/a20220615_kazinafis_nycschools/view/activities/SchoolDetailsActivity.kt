package com.example.a20220615_kazinafis_nycschools.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a20220615_kazinafis_nycschools.R
import com.example.a20220615_kazinafis_nycschools.view.fragments.SchoolDetailsFragment

class SchoolDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_details)

        val dbn = intent.getStringExtra("SchoolDBN")

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val schoolDetailsfragment = SchoolDetailsFragment()

        val mBundle = Bundle()
        mBundle.putString("DBN_Value", dbn)
        schoolDetailsfragment.arguments = mBundle
        fragmentTransaction.add(R.id.school_details_fragment, schoolDetailsfragment).commit()
    }
}