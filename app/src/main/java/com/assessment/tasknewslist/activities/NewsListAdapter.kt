package com.assessment.tasknewslist.activities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assessment.tasknewslist.R
import com.assessment.tasknewslist.databinding.MainRecyclerviewElementBinding
import com.assessment.tasknewslist.model.MainContent


class NewsListAdapter(private val onClickListener: OnClickListener) : ListAdapter<MainContent, NewsListAdapter.ViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(news)
        }
        holder.bind(getItem(position), position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: MainRecyclerviewElementBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.main_recyclerview_element,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<MainContent>() {
            override fun areItemsTheSame(oldItem: MainContent, newItem: MainContent): Boolean =
                oldItem.id == newItem.id
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: MainContent, newItem: MainContent): Boolean =
                oldItem == newItem
        }
    }

    class ViewHolder(val binding: MainRecyclerviewElementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
         * ViewHolder when Item is loaded.
         */
        fun bind(content: MainContent?, position: Int) {
            binding.content = content
            binding.executePendingBindings()
        }
    }


    class OnClickListener(val clickListener: (mainContent: MainContent) -> Unit) {
        fun onClick(mainContent: MainContent) = clickListener(mainContent)
    }
}