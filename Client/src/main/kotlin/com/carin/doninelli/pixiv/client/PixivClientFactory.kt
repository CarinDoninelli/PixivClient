package com.carin.doninelli.pixiv.client

import com.carin.doninelli.pixiv.client.entities.Credentials
import com.carin.doninelli.pixiv.client.internal.PixivAuthenticator
import com.carin.doninelli.pixiv.client.internal.PixivClientImpl
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class PixivClientFactory {
    fun createPixivClient(credentials: Credentials): PixivClient {
        val mapper = jacksonObjectMapper().apply {
            propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }

        val pixivAuthenticator = PixivAuthenticator(mapper)
        return PixivClientImpl(mapper, credentials, pixivAuthenticator)
    }
}