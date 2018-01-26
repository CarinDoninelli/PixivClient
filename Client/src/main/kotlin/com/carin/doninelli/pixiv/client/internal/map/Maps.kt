package com.carin.doninelli.pixiv.client.internal.map

internal fun headersMap(
        referrer: String,
        userAgent: String,
        contentType: String,
        vararg other: Pair<String, String>
): Map<String, String> {
    return mapOf(*other) + mapOf(
            "Referrer" to referrer,
            "User-Agent" to userAgent,
            "Content-Type" to contentType
    )
}