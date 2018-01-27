package com.carin.doninelli.pixiv.client.internal.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

internal class EmptyStringAsNullDeserializer : JsonDeserializer<String?>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): String? {
        return p.valueAsString.takeIf { it.isNotBlank() }
    }
}