package com.carin.doninelli.pixiv.client.entities

import java.io.Serializable

data class Credentials(
        val username: String,
        val password: String
) : Serializable