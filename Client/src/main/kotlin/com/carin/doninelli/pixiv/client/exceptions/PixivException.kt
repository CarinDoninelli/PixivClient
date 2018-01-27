package com.carin.doninelli.pixiv.client.exceptions

open class PixivException : RuntimeException {
    internal constructor() : super()
    internal constructor(message: String?) : super(message)
    internal constructor(message: String?, cause: Throwable?) : super(message, cause)
    internal constructor(cause: Throwable?) : super(cause)
    internal constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) : super(message, cause, enableSuppression, writableStackTrace)
}