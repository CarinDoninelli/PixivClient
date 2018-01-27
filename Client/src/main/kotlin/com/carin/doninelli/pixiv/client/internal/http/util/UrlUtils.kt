package com.carin.doninelli.pixiv.client.internal.http.util

import org.apache.http.NameValuePair
import org.apache.http.client.utils.URLEncodedUtils
import java.net.URI

internal fun URI.withParams(params: List<NameValuePair>): URI {
    val paramQuery = URLEncodedUtils.format(params, "utf-8")
    val newQuery = query?.plus("&$paramQuery") ?: paramQuery
    return URI(scheme, authority, path, newQuery, fragment)
}