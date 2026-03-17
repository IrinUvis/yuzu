package uvis.irin.yuzu.feature.wordgenerator.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import uvis.irin.yuzu.domain.genai.di.genAiDomainModule
import uvis.irin.yuzu.domain.wordgeneration.di.wordGenerationDomainModule
import uvis.irin.yuzu.feature.wordgenerator.ui.WordGeneratorViewModel

val wordGeneratorFeatureModule = module {
    viewModelOf(::WordGeneratorViewModel)

    includes(wordGenerationDomainModule, genAiDomainModule)
}
