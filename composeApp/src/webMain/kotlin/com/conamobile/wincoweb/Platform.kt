package com.conamobile.wincoweb

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform