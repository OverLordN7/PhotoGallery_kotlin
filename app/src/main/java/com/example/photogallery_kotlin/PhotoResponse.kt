package com.example.photogallery_kotlin

import com.google.gson.annotations.SerializedName

class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItem: List<GalleryItem>
}