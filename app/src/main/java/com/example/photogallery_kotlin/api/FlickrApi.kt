package com.example.photogallery_kotlin.api

import retrofit2.Call
import retrofit2.http.GET


interface FlickrApi {

    @GET("services/rest/?method=flickr.interestingness.getList"+
            "&api_key=f192d06238a081a8530c92d57cb668b8" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s")
    fun fetchPhotos(): Call<String>
}