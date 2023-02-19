package com.assessment.tasknewslist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.assessment.tasknewslist.databinding.ActivityListNewsBinding
import com.assessment.tasknewslist.viewModel.NewsViewModel
import kotlinx.coroutines.launch

class NewsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListNewsBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsAdapter= NewsListAdapter(NewsListAdapter.OnClickListener{   newsDetail ->
            val intent = Intent(this, DetailViewActivity::class.java)
            intent.putExtra("newsdetail", newsDetail)
            startActivity(intent)
        })


        binding.recyclerview.adapter = newsAdapter
        viewModel=ViewModelProvider(this)[NewsViewModel::class.java]
        lifecycleScope.launch {
            viewModel.getNews()
        }
        viewModel.newsLiveData.observe(this) { newsList ->
            newsAdapter.submitList(newsList)
        }
    }
}