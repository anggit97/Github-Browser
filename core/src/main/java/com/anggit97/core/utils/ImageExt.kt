package com.anggit97.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
fun ImageView.load(imageUri: Any) {
    Glide.with(context)
        .load(imageUri)
        .apply(RequestOptions())
        .into(this)
}

fun ImageView.circle(imageUri: Any) {
    Glide.with(context)
        .asBitmap()
        .load(imageUri)
        .apply(
            RequestOptions()
                .transform(CircleCrop())
        )
        .into(this)
}