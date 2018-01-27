package com.carin.doninelli.pixiv.client.entities

interface User {
    val id: Long

    val name: String

    val account: String

    val comment: String

    val isFollowed: Boolean

    val region: String?
}