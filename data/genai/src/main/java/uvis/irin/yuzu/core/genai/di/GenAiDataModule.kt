package uvis.irin.yuzu.core.genai.di

import com.google.mlkit.genai.prompt.Generation
import org.koin.dsl.module
import uvis.irin.yuzu.core.genai.repository.LlmRepository
import uvis.irin.yuzu.core.genai.repository.impl.GeminiNanoRepository

val genAiDataModule = module {
    single<LlmRepository> {
        GeminiNanoRepository(
            generativeModel = Generation.getClient(),
            logger = get(),
        )
    }
}
