package uvis.irin.yuzu.domain.wordgeneration.di

import org.koin.dsl.module
import uvis.irin.yuzu.data.wordgeneration.di.wordGeneratorDataModule
import uvis.irin.yuzu.domain.wordgeneration.usecase.ExplainWordUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.GenerateWordUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.GetWordGenerationSettingsUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.UpdateWordGenerationSettingsUseCase
import uvis.irin.yuzu.domain.wordgeneration.usecase.impl.ExplainWordUseCaseImpl
import uvis.irin.yuzu.domain.wordgeneration.usecase.impl.GenerateWordUseCaseImpl
import uvis.irin.yuzu.domain.wordgeneration.usecase.impl.GetWordGenerationSettingsUseCaseImpl
import uvis.irin.yuzu.domain.wordgeneration.usecase.impl.UpdateWordGenerationSettingsUseCaseImpl

val wordGenerationDomainModule = module {
    single<ExplainWordUseCase> { ExplainWordUseCaseImpl() }
    single<GenerateWordUseCase> { GenerateWordUseCaseImpl() }
    single<UpdateWordGenerationSettingsUseCase> { UpdateWordGenerationSettingsUseCaseImpl(get()) }
    single<GetWordGenerationSettingsUseCase> { GetWordGenerationSettingsUseCaseImpl(get()) }

    includes(wordGeneratorDataModule)
}
