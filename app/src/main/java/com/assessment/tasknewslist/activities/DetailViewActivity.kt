package com.assessment.tasknewslist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.assessment.tasknewslist.databinding.ActivityDetailViewBinding
import com.assessment.tasknewslist.model.MainContent

class DetailViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsDetail = intent.getSerializableExtra("newsdetail") as MainContent
        binding.newsdetail=newsDetail
    }
}