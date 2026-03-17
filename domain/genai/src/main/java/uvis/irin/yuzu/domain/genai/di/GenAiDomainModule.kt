package uvis.irin.yuzu.domain.genai.di

import org.koin.dsl.module
import uvis.irin.yuzu.core.genai.di.genAiDataModule
import uvis.irin.yuzu.domain.genai.usecase.DownloadGenAiModelUseCase
import uvis.irin.yuzu.domain.genai.usecase.GetAiModelStatusUseCase
import uvis.irin.yuzu.domain.genai.usecase.impl.DownloadGenAiModelUseCaseImpl
import uvis.irin.yuzu.domain.genai.usecase.impl.GetAiModelStatusUseCaseImpl

val genAiDomainModule = module {
    single<GetAiModelStatusUseCase> { GetAiModelStatusUseCaseImpl(get(), get()) }
    single<DownloadGenAiModelUseCase> { DownloadGenAiModelUseCaseImpl(get()) }

    includes(genAiDataModule)
}
