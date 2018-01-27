package com.carin.doninelli.pixiv.client.internal.entities

import com.carin.doninelli.pixiv.client.entities.PixivAuth
import java.io.Serializable

internal data class PixivAuthImpl(
        override val accessToken: String,
        override val refreshToken: String,
        override val scope: String,
        override val tokenType: String,
        override val expiresIn: Int
) : Serializable,
    PixivAuth