package com.example.photogallery_kotlin

import android.app.Application
import androidx.lifecycle.*
import retrofit2.http.Query

class PhotoGalleryViewModel(private val app: Application): AndroidViewModel(app) {
    val galleryItemLiveData: LiveData<List<GalleryItem>>

    val searchTerm: String
        get() = mutableSearchTerm.value ?: ""

    private val flicktFetchr = FlickrFetchr()
    private val mutableSearchTerm = MutableLiveData<String>()


    init {
        mutableSearchTerm.value = QueryPreferences().getStoredQuery(app)
        galleryItemLiveData = Transformations.switchMap(mutableSearchTerm){ searchTerm->
            if(searchTerm.isBlank()){
                flicktFetchr.fetchPhotos()
            }else{
                flicktFetchr.searchPhotos(searchTerm)
            }

        }
    }

    fun fetchPhotos(query: String = " "){
        QueryPreferences().setStoredQuery(app,query)
        mutableSearchTerm.value = query
    }
}