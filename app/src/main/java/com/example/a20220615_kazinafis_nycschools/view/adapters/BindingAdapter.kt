package com.example.a20220615_kazinafis_nycschools.view.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220615_kazinafis_nycschools.model.school.School
import com.example.a20220615_kazinafis_nycschools.model.school.SchoolDetails

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<School>?) {
    val adapter = recyclerView.adapter as SchoolListAdapter
    adapter.submitList(data)
}

@BindingAdapter("textData")
fun bindTextView(textView: TextView, data: String?) {
    textView.text = data
}