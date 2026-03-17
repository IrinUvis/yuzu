package uvis.irin.yuzu.data.wordgeneration.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStoreFile
import uvis.irin.yuzu.core.logger.YuzuLogger
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettings

internal fun createWordGenerationSettingsDatastore(
    context: Context,
    logger: YuzuLogger,
): DataStore<WordGenerationSettings> {
    val serializer = WordGenerationSettingsSerializer(logger)
    return DataStoreFactory.create(
        serializer = serializer,
        corruptionHandler = ReplaceFileCorruptionHandler { serializer.defaultValue },
        produceFile = { context.dataStoreFile(DataStoreName) },
    )
}

private const val DataStoreName = "word_generator_settings"
