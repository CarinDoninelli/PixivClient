package com.carin.doninelli.pixiv.client.internal.entities

import com.carin.doninelli.pixiv.client.entities.User
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

internal data class UserImpl(

        override val id: Long,

        override val name: String,

        override val account: String,

        @JsonProperty(defaultValue = "")
        override val comment: String,

        override val isFollowed: Boolean,

        override val region: String?

) : Serializable,
    User