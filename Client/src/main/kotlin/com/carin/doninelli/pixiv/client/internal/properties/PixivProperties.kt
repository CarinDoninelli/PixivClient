package com.carin.doninelli.pixiv.client.internal.properties

import java.util.Properties

internal object PixivProperties {
    private val pixivPropertiesFile = "pixiv.properties"

    private val properties: Properties by lazy {
        Properties().also { properties ->
            javaClass.classLoader
                    .getResourceAsStream(pixivPropertiesFile)
                    .use(properties::load)
        }
    }

    val referrer: String by lazy { properties.getProperty("referrer") }
    val userAgent: String by lazy { properties.getProperty("userAgent") }
    val contentType: String by lazy { properties.getProperty("contentType") }
    val clientId: String by lazy { properties.getProperty("clientId") }
    val clientSecret: String by lazy { properties.getProperty("clientSecret") }
    val getSecureUrl: String by lazy { properties.getProperty("getSecureUrl") ?: "1" }
    val grantType: String by lazy { properties.getProperty("grantType") ?: "password" }
}