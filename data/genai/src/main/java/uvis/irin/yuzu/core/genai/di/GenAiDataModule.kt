package uvis.irin.yuzu.core.genai.di

import org.koin.dsl.module
import uvis.irin.yuzu.core.genai.repository.GenAiRepository
import uvis.irin.yuzu.core.genai.repository.impl.LlmRepository

val genAiDataModule = module {
    single<GenAiRepository> { LlmRepository(get()) }
}
