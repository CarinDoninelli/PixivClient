package com.carin.doninelli.pixiv.client.entities

interface Profile {

    val webPage: String?

    val gender: String

    val birth: String?

    val countryCode: String

    val job: String?

    val jobId: Int?

    val addressId: Int?

    val totalFollowers: Int

    val totalFollowed: Int

    val totalIllustrations: Int

    val totalManga: Int

    val totalNovels: Int

    val isPremium: Int

}