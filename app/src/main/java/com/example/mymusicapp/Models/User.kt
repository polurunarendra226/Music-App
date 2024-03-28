package com.example.mymusicapp.Models

data class User(
    val `data`: List<Data>,
    val next: String?,
    val total: Int?
)