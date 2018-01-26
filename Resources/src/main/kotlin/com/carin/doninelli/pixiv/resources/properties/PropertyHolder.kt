package com.carin.doninelli.pixiv.resources.properties

import java.util.Properties

class PropertyHolder(file: String) {
    private val properties: Properties by lazy {
        Properties().also {
            javaClass.classLoader
                    .getResourceAsStream(file)
                    .use(it::load)
        }
    }

    operator fun get(name: String): String = properties.getProperty(name)

    fun getOrNull(name: String): String? = properties.getProperty(name)
}