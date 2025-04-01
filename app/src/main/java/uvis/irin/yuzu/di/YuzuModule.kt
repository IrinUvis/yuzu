package uvis.irin.yuzu.di

import org.koin.dsl.module
import uvis.irin.yuzu.feature.wordgenerator.di.wordGeneratorModule

val yuzuModule = module {
    includes(wordGeneratorModule)
}
