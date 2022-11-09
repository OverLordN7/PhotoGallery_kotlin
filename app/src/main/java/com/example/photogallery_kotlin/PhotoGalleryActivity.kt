package com.example.photogallery_kotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PhotoGalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFrahmentContainerEmpty = savedInstanceState == null
        if(isFrahmentContainerEmpty){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer,PhotoGalleryFragment.newInstance())
                .commit()
        }
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context,PhotoGalleryActivity::class.java)
        }
    }
}