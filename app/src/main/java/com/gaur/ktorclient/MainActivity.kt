package com.gaur.ktorclient

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gaur.ktorclient.network.model.Post
import com.gaur.ktorclient.repository.GetRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {

            val post =Post(
                body = "this is body",
                id=1,
                title="this is title",
                userId = 1
            )

            val map = mutableMapOf<String,String>()
            map.put("body","this is not body")

            Log.d("TAG", "onCreate getPosts: ${GetRepo().getPosts()}")
            Log.d("TAG", "onCreate: get Comments${GetRepo().getComments("1")}")
            Log.d("TAG", "onCreate: Create Post ${GetRepo().postPost(post)}")
            Log.d("TAG", "onCreate: Put Post ${GetRepo().putPost(1,post)}")
            Log.d("TAG", "onCreate: Patch Post ${GetRepo().patchPost(1,map)}")
            Log.d("TAG", "onCreate: Delete Post ${GetRepo().deletePost(1).status}")
        }


    }
}