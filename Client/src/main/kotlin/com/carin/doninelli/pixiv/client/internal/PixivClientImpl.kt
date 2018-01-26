package com.carin.doninelli.pixiv.client.internal

import com.carin.doninelli.pixiv.client.PixivClient
import com.carin.doninelli.pixiv.client.entities.Credentials
import com.carin.doninelli.pixiv.client.entities.PixivAuth
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.impl.client.HttpClientBuilder

internal class PixivClientImpl(
        private val mapper: ObjectMapper,
        credentials: Credentials
) : PixivClient {
    private val client = HttpClientBuilder.create().build()
    private val authenticator = PixivAuthenticator(mapper, client)
    private val auth: PixivAuth by lazy { authenticator.authenticate(credentials) }
}