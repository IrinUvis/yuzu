package uvis.irin.yuzu.core.logger

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity

interface YuzuLogger {
    fun logDebug(
        tag: String,
        message: String,
        throwable: Throwable? = null,
    )

    fun logError(
        tag: String,
        message: String,
        throwable: Throwable? = null,
    )
}

internal class YuzuLoggerImpl(
    private val kermitLogger: Logger,
) : YuzuLogger {
    override fun logDebug(
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        kermitLogger.log(
            tag = tag,
            message = message,
            severity = Severity.Debug,
            throwable = throwable,
        )
    }

    override fun logError(
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        kermitLogger.log(
            tag = tag,
            message = message,
            severity = Severity.Debug,
            throwable = throwable,
        )
    }
}
