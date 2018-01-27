package com.carin.doninelli.pixiv.client.internal.entities

import com.carin.doninelli.pixiv.client.entities.Profile
import com.carin.doninelli.pixiv.client.internal.deserializers.EmptyStringAsNullDeserializer
import com.carin.doninelli.pixiv.client.internal.deserializers.ZeroAsNullDeserializer
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.io.Serializable

internal data class ProfileImpl(

        @JsonProperty("webpage")
        override val webPage: String?,

        override val gender: String,

        @JsonDeserialize(using = EmptyStringAsNullDeserializer::class)
        override val birth: String?,

        override val countryCode: String,

        @JsonDeserialize(using = EmptyStringAsNullDeserializer::class)
        override val job: String?,

        @JsonDeserialize(using = ZeroAsNullDeserializer::class)
        override val jobId: Int?,

        @JsonDeserialize(using = ZeroAsNullDeserializer::class)
        override val addressId: Int?,

        @JsonProperty("total_follower")
        override val totalFollowers: Int,

        @JsonProperty("total_follow_users")
        override val totalFollowed: Int,

        @JsonProperty("total_illusts")
        override val totalIllustrations: Int,

        override val totalManga: Int,

        override val totalNovels: Int

) : Serializable, Profile