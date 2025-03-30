package uvis.irin.yuzu.data.wordgeneration.datastore

import android.util.Log
import androidx.datastore.core.Serializer
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import uvis.irin.yuzu.data.wordgeneration.model.DifficultyModel
import uvis.irin.yuzu.data.wordgeneration.model.LanguageModel
import uvis.irin.yuzu.data.wordgeneration.model.PartOfSpeechModel
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsModel
import java.io.InputStream
import java.io.OutputStream

object WordGenerationSettingsSerializer : Serializer<WordGenerationSettingsModel> {
    override val defaultValue: WordGenerationSettingsModel
        get() = WordGenerationSettingsModel(
            language = LanguageModel.English,
            partsOfSpeech = persistentSetOf(
                PartOfSpeechModel.Noun,
                PartOfSpeechModel.Verb,
            ),
            difficulties = persistentSetOf(DifficultyModel.CommonlyUsed),
        )

    override suspend fun readFrom(input: InputStream): WordGenerationSettingsModel {
        return try {
            Json.decodeFromString(
                deserializer = WordGenerationSettingsModel.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            Log.d("WordGenerationSettingsSerializer", "Error deserializing WordGenerationSettings", e)
            defaultValue
        }
    }

    override suspend fun writeTo(
        t: WordGenerationSettingsModel,
        output: OutputStream,
    ) {
        output.write(
            Json.encodeToString(
                serializer = WordGenerationSettingsModel.serializer(),
                value = t,
            ).toByteArray(),
        )
    }
}
