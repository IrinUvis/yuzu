package uvis.irin.yuzu.core.logger

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity

class YuzuLogger(private val kermitLogger: Logger) {
    fun log(
        tag: String,
        message: String,
        severity: LoggerSeverity = LoggerSeverity.Debug,
        throwable: Throwable? = null,
    ) {
        kermitLogger.log(
            tag = tag,
            message = message,
            severity = severity.toKermitSeverity(),
            throwable = throwable,
        )
    }
}

enum class LoggerSeverity {
    Info,
    Debug,
    Error,
}

private fun LoggerSeverity.toKermitSeverity() = when (this) {
    LoggerSeverity.Info -> Severity.Info
    LoggerSeverity.Debug -> Severity.Debug
    LoggerSeverity.Error -> Severity.Error
}
