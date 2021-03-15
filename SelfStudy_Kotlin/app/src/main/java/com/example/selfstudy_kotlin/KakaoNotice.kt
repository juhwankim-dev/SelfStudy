package com.example.selfstudy_kotlin

data class KakaoNotice(
        val hometab: Hometab
)

data class Hometab(
        val items: List<Item>
)

data class Item(
        val contents: List<Content>
)

data class Content(
        val title: Title,
    val link: Link,
    val media: Media
)

data class Title(
       val  text: String
)

data class Link(
        val url: String
)

data class Media(
        val image: Image
)

data class Image(
        val height: Double,
        val image_url: String,
        val width: Double
)