package uvis.irin.yuzu.feature.wordgenerator.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import uvis.irin.yuzu.domain.wordgeneration.di.wordGenerationDomainModule
import uvis.irin.yuzu.feature.wordgenerator.domain.ExplainWordUseCase
import uvis.irin.yuzu.feature.wordgenerator.domain.ExplainWordUseCaseImpl
import uvis.irin.yuzu.feature.wordgenerator.domain.GenerateWordUseCase
import uvis.irin.yuzu.feature.wordgenerator.domain.GenerateWordUseCaseImpl
import uvis.irin.yuzu.feature.wordgenerator.ui.WordGeneratorViewModel

val wordGeneratorModule = module {
    singleOf<ExplainWordUseCase>(::ExplainWordUseCaseImpl)
    singleOf<GenerateWordUseCase>(::GenerateWordUseCaseImpl)
    viewModelOf(::WordGeneratorViewModel)

    includes(wordGenerationDomainModule)
}
