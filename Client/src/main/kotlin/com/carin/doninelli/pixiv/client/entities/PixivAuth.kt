package com.carin.doninelli.pixiv.client.entities

import java.io.Serializable

data class PixivAuth internal constructor(
        val accessToken: String,
        val refreshToken: String,
        val scope: String,
        val tokenType: String,
        val expiresIn: Int
) : Serializable