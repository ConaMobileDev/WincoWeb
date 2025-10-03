package com.conamobile.wincoweb.tools

import kotlinx.browser.window

fun getPlatformType(): PlatformType {
    val userAgent = window.navigator.userAgent.lowercase()

    return when {
        userAgent.contains("android") -> PlatformType.ANDROID
        userAgent.contains("iphone") ||
                userAgent.contains("ipad") ||
                userAgent.contains("ipod") -> PlatformType.IOS

        userAgent.contains("windows") -> PlatformType.DESKTOP
        userAgent.contains("mac") -> PlatformType.DESKTOP
        userAgent.contains("linux") -> PlatformType.DESKTOP
        else -> PlatformType.DESKTOP
    }
}

fun isPortrait(): Boolean {
    return window.innerWidth > window.innerHeight
}

enum class PlatformType {
    ANDROID, IOS, DESKTOP
}