package com.carin.doninelli.pixiv.client.internal.entities

import com.carin.doninelli.pixiv.client.entities.Profile
import com.carin.doninelli.pixiv.client.entities.User
import com.carin.doninelli.pixiv.client.entities.UserProfile
import java.io.Serializable

data class UserProfileImpl internal constructor(

        private val user: User,

        private val profile: Profile

) : Serializable,
    UserProfile,
    User by user,
    Profile by profile