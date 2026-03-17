package uvis.irin.yuzu.core.logger.di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter
import org.koin.dsl.module
import uvis.irin.yuzu.core.logger.YuzuLogger
import uvis.irin.yuzu.core.logger.YuzuLoggerImpl

val loggerModule = module {
    single<YuzuLogger> {
        YuzuLoggerImpl(
            kermitLogger = Logger(
                config = loggerConfigInit(platformLogWriter()),
                tag = "Yuzu",
            ),
        )
    }
}
