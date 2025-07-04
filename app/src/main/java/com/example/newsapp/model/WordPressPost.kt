package com.example.newsapp.model

data class WordPressPost(
    val id: Int,
    val date: String,
    val title: Rendered,
    val excerpt: Rendered,
    val content: Rendered,
    val author: Int,
    val featured_media: Int
)

data class Rendered(
    val rendered: String
)

data class Author(
    val id: Int,
    val name: String
)

data class FeaturedMedia(
    val id: Int,
    val source_url: String
)
