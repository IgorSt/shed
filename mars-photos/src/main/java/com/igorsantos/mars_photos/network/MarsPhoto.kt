package com.igorsantos.mars_photos.network

import com.squareup.moshi.Json

/**
 * Created by IgorSantos on 8/18/2021.
 */
data class MarsPhoto (
    val id: String,
    @Json(name = "img_src")val imgSrcUrl: String
    )