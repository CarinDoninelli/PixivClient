package com.carin.doninelli.pixiv.client

import com.carin.doninelli.pixiv.client.entities.Credentials
import com.carin.doninelli.pixiv.client.internal.PixivClientImpl
import com.carin.doninelli.pixiv.client.internal.http.HttpClientFactory
import com.carin.doninelli.pixiv.client.internal.mappers.ObjectMapperFactory

class PixivClientFactory {
    private val objectMapperFactory = ObjectMapperFactory()
    private val clientFactory = HttpClientFactory()

    fun createPixivClient(credentials: Credentials): PixivClient {
        val mapper = objectMapperFactory.createPixivObjectMapper()
        val client = clientFactory.createHttpClient()

        return PixivClientImpl(mapper, client, credentials)
    }
}
