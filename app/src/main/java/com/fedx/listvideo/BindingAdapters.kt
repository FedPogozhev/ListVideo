package com.fedx.listvideo

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fedx.listvideo.network.Headline
import com.fedx.listvideo.network.ImgSrc
import com.fedx.listvideo.network.Movies

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl.let {
        val imgUri = imgUrl!!.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Headline>?) {
    val adapter = recyclerView.adapter as DataAdapter
    adapter.submitList(data)
}