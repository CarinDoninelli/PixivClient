package com.carin.doninelli.pixiv.client.internal.http.util

import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.message.BasicNameValuePair

internal fun urlEncodedFormOf(vararg entries: Pair<String, String>): UrlEncodedFormEntity {
    val formData: List<NameValuePair> = entries.map { (key, value) ->
        BasicNameValuePair(key, value)
    }

    return UrlEncodedFormEntity(formData)
}