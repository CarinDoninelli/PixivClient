package com.carin.doninelli.pixiv.client.internal.deserializers

import com.carin.doninelli.pixiv.client.exceptions.PixivException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.convertValue
import java.io.InputStream

internal inline fun <reified T : Any> ObjectMapper.deserializePixivResponse(jsonStream: InputStream, entityField: String? = null): T {
    val json = readTree(jsonStream)

    val hasErrors = json["has_error"]?.asBoolean() ?: false
    if (hasErrors) {
        val message = json["errors"]["system"]["message"]?.asText() ?: ""
        throw PixivException(message)
    }

    val responseContent = if (entityField != null) json[entityField] else json
    return convertValue(responseContent)
}