package uvis.irin.yuzu.di

import org.koin.dsl.module
import uvis.irin.yuzu.feature.wordgenerator.di.wordGeneratorFeatureModule

val yuzuModule = module {
    includes(wordGeneratorFeatureModule)
}
