package com.example.gllibrary

data class Attribute(
    val location: Int,
    val size: Int,
    val offset: Int,
    val stride: Int? = null,
    val divisor: Int? = null
)
