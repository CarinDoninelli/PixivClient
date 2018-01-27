package com.carin.doninelli.pixiv.client.internal

import com.carin.doninelli.pixiv.client.entities.Credentials
import com.carin.doninelli.pixiv.client.entities.PasswordCredentials
import com.carin.doninelli.pixiv.client.entities.PixivAuth
import com.carin.doninelli.pixiv.client.internal.deserializers.deserializePixivResponse
import com.carin.doninelli.pixiv.client.internal.http.util.nameValuePairListOf
import com.carin.doninelli.pixiv.client.internal.properties.PixivProperties
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost


internal class PixivAuthenticator(private val mapper: ObjectMapper, private val client: HttpClient) {
    fun authenticate(credentials: Credentials): PixivAuth {
        val (username, password) = when (credentials) {
            is PasswordCredentials -> credentials
        }

        val formData = nameValuePairListOf(
                "client_id" to PixivProperties.CLIENT_ID,
                "client_secret" to PixivProperties.CLIENT_SECRET,
                "get_secure_url" to PixivProperties.GET_SECURE_URL,
                "grant_type" to PixivProperties.GRANT_TYPE,
                "username" to username,
                "password" to password
        )

        val post = HttpPost("https://oauth.secure.pixiv.net/auth/token").apply {
            entity = UrlEncodedFormEntity(formData)
            setHeader("Content-Type", PixivProperties.CONTENT_TYPE)
        }

        val response = client.execute(post)
        return mapper.deserializePixivResponse(response.entity.content, entityField = "response")
    }
}