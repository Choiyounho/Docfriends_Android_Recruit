package com.soten.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.soten.solution.R

private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

fun ImageView.load(url: String?) {
    Glide.with(this)
        .load(url)
        .error(R.drawable.close)
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}