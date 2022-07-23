package com.gaur.ktorclient.repository

import com.gaur.ktorclient.network.KtorClient
import com.gaur.ktorclient.network.model.Comment
import com.gaur.ktorclient.network.model.Post
import io.ktor.client.request.*
import io.ktor.client.statement.*

class GetRepo {


    suspend fun getPosts(): List<Post> =
        KtorClient.httpClient.get("https://jsonplaceholder.typicode.com/posts")


    suspend fun getComments(id: String): List<Comment> =
        KtorClient.httpClient.get<List<Comment>> {
            url("https://jsonplaceholder.typicode.com/comments")
            parameter("postId", id)
        }

    suspend fun postPost(post: Post): Post = KtorClient.httpClient.post {
        url("https://jsonplaceholder.typicode.com/posts")
        body = post
    }

    suspend fun putPost(id: Int, post: Post): Post = KtorClient.httpClient.put {
        url("https://jsonplaceholder.typicode.com/posts/$id")
        body = post

    }

    suspend fun patchPost(id: Int, map: MutableMap<String, String>) =
        KtorClient.httpClient.patch<Post> {
            url("https://jsonplaceholder.typicode.com/posts/$id")
            body = map

        }

    suspend fun deletePost(id:Int) : HttpResponse = KtorClient.httpClient.delete {
        url("https://jsonplaceholder.typicode.com/posts/$id")
    }


}