package com.carin.doninelli.pixiv.client

import com.carin.doninelli.pixiv.client.entities.UserProfile
import java.util.concurrent.CompletableFuture

interface PixivClient {
    fun getUserInfo(id: Int): CompletableFuture<UserProfile>
}