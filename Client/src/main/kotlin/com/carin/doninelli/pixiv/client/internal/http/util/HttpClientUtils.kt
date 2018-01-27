package com.carin.doninelli.pixiv.client.internal.http.util

import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair

internal fun nameValuePairListOf(vararg entries: Pair<String, String>): List<NameValuePair> {
    return entries.map { (key, value) -> BasicNameValuePair(key, value) }
}
