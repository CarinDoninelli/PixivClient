package com.carin.doninelli.pixiv.client.internal.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

internal class ZeroAsNullDeserializer : JsonDeserializer<Int?>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): Int? {
        return p.intValue.takeIf { it != 0 }
    }
}