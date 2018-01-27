package com.carin.doninelli.pixiv.client.entities

interface PixivAuth {

    val accessToken: String

    val refreshToken: String

    val scope: String

    val tokenType: String

    val expiresIn: Int

}