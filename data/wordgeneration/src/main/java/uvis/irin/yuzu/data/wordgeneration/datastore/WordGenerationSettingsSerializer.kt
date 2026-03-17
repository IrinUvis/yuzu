package uvis.irin.yuzu.data.wordgeneration.datastore

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import uvis.irin.yuzu.core.logger.YuzuLogger
import uvis.irin.yuzu.data.wordgeneration.model.Difficulty
import uvis.irin.yuzu.data.wordgeneration.model.Language
import uvis.irin.yuzu.data.wordgeneration.model.PartOfSpeech
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettings
import java.io.InputStream
import java.io.OutputStream

internal class WordGenerationSettingsSerializer(private val logger: YuzuLogger) : Serializer<WordGenerationSettings> {
    override val defaultValue: WordGenerationSettings
        get() = WordGenerationSettings(
            language = Language.English,
            partsOfSpeech = setOf(
                PartOfSpeech.Noun,
                PartOfSpeech.Verb,
            ),
            difficulties = setOf(Difficulty.CommonlyUsed),
        )

    override suspend fun readFrom(input: InputStream): WordGenerationSettings {
        return try {
            Json.decodeFromString(
                deserializer = WordGenerationSettings.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            logger.logError(
                tag = TAG,
                message = "Error during deserialization of WordGenerationSettings",
                throwable = e,
            )
            defaultValue
        }
    }

    override suspend fun writeTo(
        t: WordGenerationSettings,
        output: OutputStream,
    ) {
        output.write(
            Json.encodeToString(
                serializer = WordGenerationSettings.serializer(),
                value = t,
            ).toByteArray(),
        )
    }

    companion object {
        private val TAG = WordGenerationSettingsSerializer::class.simpleName!!
    }
}
