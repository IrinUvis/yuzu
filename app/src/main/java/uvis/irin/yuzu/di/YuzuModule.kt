package uvis.irin.yuzu.di

import org.koin.dsl.module
import uvis.irin.feature.wordgenerator.di.wordGeneratorModule

val yuzuModule = module {
    includes(wordGeneratorModule)
}
