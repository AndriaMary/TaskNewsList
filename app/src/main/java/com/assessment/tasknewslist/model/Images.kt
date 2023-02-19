package com.assessment.tasknewslist.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class Images(
    val square_140: String?
):java.io.Serializable

@BindingAdapter("square_140")
fun ImageView.setImageUrl(square_140: String?) {
    Glide.with(this).load(square_140).into(this)
}