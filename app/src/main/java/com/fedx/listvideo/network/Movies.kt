package com.fedx.listvideo.network

data class Movies(
    val results: List<Headline>
)
data class Headline(
    val headline: String,
    val summary_short: String,
    val multimedia: ImgSrc
)
data class ImgSrc(
    val src: String
)
