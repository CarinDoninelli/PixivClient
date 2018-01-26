package com.carin.doninelli.pixiv.client.internal

import com.carin.doninelli.pixiv.client.entities.Credentials
import com.carin.doninelli.pixiv.client.entities.PixivAuth
import com.carin.doninelli.pixiv.client.internal.http.util.urlEncodedFormOf
import com.carin.doninelli.pixiv.client.internal.properties.PixivProperties
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost


internal class PixivAuthenticator(private val mapper: ObjectMapper, private val client: HttpClient) {
    fun authenticate(credentials: Credentials): PixivAuth {
        val (username, password) = credentials
        val post = HttpPost("https://oauth.secure.pixiv.net/auth/token").apply {
            entity = urlEncodedFormOf(
                    "client_id" to PixivProperties.clientId,
                    "client_secret" to PixivProperties.clientSecret,
                    "get_secure_url" to PixivProperties.getSecureUrl,
                    "grant_type" to PixivProperties.grantType,
                    "username" to username,
                    "password" to password
            )

            setHeader("Content-Type", PixivProperties.contentType)
        }

        val response = client.execute(post)
        return mapper.readValue(response.entity.content) // TODO: extract from response field
    }
}