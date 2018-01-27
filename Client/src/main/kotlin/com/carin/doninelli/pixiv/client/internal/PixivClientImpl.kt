package com.carin.doninelli.pixiv.client.internal

import com.carin.doninelli.pixiv.client.PixivClient
import com.carin.doninelli.pixiv.client.entities.Credentials
import com.carin.doninelli.pixiv.client.entities.PixivAuth
import com.carin.doninelli.pixiv.client.entities.UserProfile
import com.carin.doninelli.pixiv.client.internal.deserializers.deserializePixivResponse
import com.carin.doninelli.pixiv.client.internal.http.util.nameValuePairListOf
import com.carin.doninelli.pixiv.client.internal.http.util.withParams
import com.carin.doninelli.pixiv.client.internal.properties.PixivProperties
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.message.BasicHeader
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletableFuture.supplyAsync

internal class PixivClientImpl(
        private val mapper: ObjectMapper,
        private val client: HttpClient,
        private val credentials: Credentials,
        private val authenticator: PixivAuthenticator = PixivAuthenticator(mapper, client)
) : PixivClient {
    private val auth = supplyAsync { authenticator.authenticate(credentials) }
    private fun <T : Any> withAuthentication(action: (PixivAuth) -> T) = auth.thenApply(action)

    private val headers = arrayOf(
            BasicHeader("Referer", "http://www.pixiv.net/"),
            BasicHeader("User-Agent", "PixivIOSApp/6.4.0"),
            BasicHeader("Content-Type", "application/x-www-form-urlencoded")
    )

    override fun getUserInfo(id: Int): CompletableFuture<UserProfile> = supplyAsync {
        val params = nameValuePairListOf(
                "user_id" to id.toString(),
                "filter" to PixivProperties.FILTER
        )

        val request = HttpGet("https://app-api.pixiv.net/v1/user/detail").apply {
            uri = uri.withParams(params)
            setHeaders(headers)
        }

        val response = client.execute(request)
        mapper.deserializePixivResponse<UserProfile>(response.entity.content)
    }
}