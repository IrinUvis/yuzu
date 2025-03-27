package uvis.irin.feature.wordgenerator.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import uvis.irin.feature.wordgenerator.domain.GenerateWordUseCase
import uvis.irin.feature.wordgenerator.domain.GenerateWordUseCaseImpl
import uvis.irin.feature.wordgenerator.ui.WordGeneratorViewModel

val wordGeneratorModule = module {
    singleOf<GenerateWordUseCase>(::GenerateWordUseCaseImpl)
    viewModelOf(::WordGeneratorViewModel)
}
