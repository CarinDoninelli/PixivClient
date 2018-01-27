package com.carin.doninelli.pixiv.client.internal.http

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder

internal class HttpClientFactory {
    fun createHttpClient(): HttpClient = HttpClientBuilder.create().build()
}