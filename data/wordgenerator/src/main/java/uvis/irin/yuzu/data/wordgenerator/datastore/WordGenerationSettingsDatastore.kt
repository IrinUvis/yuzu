package uvis.irin.yuzu.data.wordgenerator.datastore

import android.content.Context
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStoreFile

internal fun createWordGenerationSettingsDatastore(context: Context) = DataStoreFactory.create(
    serializer = WordGenerationSettingsSerializer,
    corruptionHandler = ReplaceFileCorruptionHandler { WordGenerationSettingsSerializer.defaultValue },
    produceFile = { context.dataStoreFile(DataStoreName) },
)

private const val DataStoreName = "word_generator_settings"
