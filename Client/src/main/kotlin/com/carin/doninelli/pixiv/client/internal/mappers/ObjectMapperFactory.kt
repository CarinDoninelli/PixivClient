package com.carin.doninelli.pixiv.client.internal.mappers

import com.carin.doninelli.pixiv.client.entities.PixivAuth
import com.carin.doninelli.pixiv.client.entities.Profile
import com.carin.doninelli.pixiv.client.entities.User
import com.carin.doninelli.pixiv.client.entities.UserProfile
import com.carin.doninelli.pixiv.client.internal.entities.PixivAuthImpl
import com.carin.doninelli.pixiv.client.internal.entities.ProfileImpl
import com.carin.doninelli.pixiv.client.internal.entities.UserImpl
import com.carin.doninelli.pixiv.client.internal.entities.UserProfileImpl
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

internal class ObjectMapperFactory {
    fun createPixivObjectMapper(): ObjectMapper = jacksonObjectMapper().apply {
        propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        val module = createModule()
        registerModule(module)
    }

    private fun createModule(): Module = SimpleModule().apply {
        val resolver = createResolver()
        setAbstractTypes(resolver)
    }

    private fun createResolver(): SimpleAbstractTypeResolver = SimpleAbstractTypeResolver().apply {
        addMapping(Profile::class.java, ProfileImpl::class.java)
        addMapping(User::class.java, UserImpl::class.java)
        addMapping(UserProfile::class.java, UserProfileImpl::class.java)
        addMapping(PixivAuth::class.java, PixivAuthImpl::class.java)
    }
}