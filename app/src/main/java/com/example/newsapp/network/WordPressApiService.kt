package com.example.newsapp.network

import com.example.newsapp.model.Author
import com.example.newsapp.model.FeaturedMedia
import com.example.newsapp.model.WordPressPost
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface WordPressApiService {

    @GET("wp-json/wp/v2/posts")
    suspend fun getPosts(): List<WordPressPost>

    @GET("wp-json/wp/v2/users/{id}")
    suspend fun getAuthor(@Path("id") id: Int): Author

    @GET("wp-json/wp/v2/media/{id}")
    suspend fun getMedia(@Path("id") id: Int): FeaturedMedia

    companion object {
        fun create(): WordPressApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://blogpost.kesug.com/") // ✅ Change to your domain
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(WordPressApiService::class.java)
        }
    }
}
