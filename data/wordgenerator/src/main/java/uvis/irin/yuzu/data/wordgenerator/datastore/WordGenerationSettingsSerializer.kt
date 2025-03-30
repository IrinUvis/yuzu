package uvis.irin.yuzu.data.wordgenerator.datastore

import android.util.Log
import androidx.datastore.core.Serializer
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import uvis.irin.yuzu.data.wordgenerator.model.Difficulty
import uvis.irin.yuzu.data.wordgenerator.model.Language
import uvis.irin.yuzu.data.wordgenerator.model.PartOfSpeech
import uvis.irin.yuzu.data.wordgenerator.model.WordGenerationSettings
import java.io.InputStream
import java.io.OutputStream

object WordGenerationSettingsSerializer : Serializer<WordGenerationSettings> {
    override val defaultValue: WordGenerationSettings
        get() = WordGenerationSettings(
            language = Language.English,
            partsOfSpeech = persistentSetOf(
                PartOfSpeech.Noun,
                PartOfSpeech.Verb,
            ),
            difficulties = persistentSetOf(Difficulty.CommonlyUsed),
        )

    override suspend fun readFrom(input: InputStream): WordGenerationSettings {
        return try {
            Json.decodeFromString(
                deserializer = WordGenerationSettings.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            Log.d("WordGenerationSettingsSerializer", "Error deserializing WordGenerationSettings", e)
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
}
