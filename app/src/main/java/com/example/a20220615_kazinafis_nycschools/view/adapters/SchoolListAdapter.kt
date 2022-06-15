package com.example.a20220615_kazinafis_nycschools.view.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220615_kazinafis_nycschools.databinding.SchoolItemBinding
import com.example.a20220615_kazinafis_nycschools.model.school.School
import com.example.a20220615_kazinafis_nycschools.view.activities.SchoolDetailsActivity

class SchoolListAdapter: ListAdapter<School, SchoolListAdapter.SchoolListViewHolder>(DiffCallBack) {
    class SchoolListViewHolder(private var binding: SchoolItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(school: School) {
            binding.school = school
            binding.detailsButton.setOnClickListener() {
                var detailsIntent = Intent(binding.root.context, SchoolDetailsActivity::class.java)
                detailsIntent.putExtra("SchoolDBN", school.dbn)
                binding.root.context.startActivity(detailsIntent)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SchoolListAdapter.SchoolListViewHolder {
        return SchoolListViewHolder(SchoolItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SchoolListAdapter.SchoolListViewHolder, position: Int) {
        val school = getItem(position)
        holder.bind(school)
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<School>() {
        override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
            return oldItem.dbn == newItem.dbn
        }

        override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
            return oldItem.schoolName == newItem.schoolName
        }

    }
}