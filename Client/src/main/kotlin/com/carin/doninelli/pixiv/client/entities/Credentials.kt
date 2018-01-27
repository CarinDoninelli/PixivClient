package com.carin.doninelli.pixiv.client.entities

import java.io.Serializable

sealed class Credentials : Serializable

data class PasswordCredentials(
        val username: String,
        val password: String
) : Credentials(), Serializable