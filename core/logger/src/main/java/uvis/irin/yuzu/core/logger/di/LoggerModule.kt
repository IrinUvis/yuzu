package uvis.irin.yuzu.core.logger.di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter
import org.koin.dsl.module
import uvis.irin.yuzu.core.logger.YuzuLogger

val loggerModule = module {
    single { YuzuLogger(kermitLogger = Logger(config = loggerConfigInit(platformLogWriter()), tag = "Yuzu")) }
}
