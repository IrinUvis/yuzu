package uvis.irin.yuzu.data.wordgeneration.datastore

import android.util.Log
import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import uvis.irin.yuzu.data.wordgeneration.model.DifficultyModel
import uvis.irin.yuzu.data.wordgeneration.model.LanguageModel
import uvis.irin.yuzu.data.wordgeneration.model.PartOfSpeechModel
import uvis.irin.yuzu.data.wordgeneration.model.WordGenerationSettingsDataModel
import java.io.InputStream
import java.io.OutputStream

object WordGenerationSettingsSerializer : Serializer<WordGenerationSettingsDataModel> {
    override val defaultValue: WordGenerationSettingsDataModel
        get() = WordGenerationSettingsDataModel(
            language = LanguageModel.English,
            partsOfSpeech = setOf(
                PartOfSpeechModel.Noun,
                PartOfSpeechModel.Verb,
            ),
            difficulties = setOf(DifficultyModel.CommonlyUsed),
        )

    override suspend fun readFrom(input: InputStream): WordGenerationSettingsDataModel {
        return try {
            Json.decodeFromString(
                deserializer = WordGenerationSettingsDataModel.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            Log.d("WordGenerationSettingsSerializer", "Error deserializing WordGenerationSettings", e)
            defaultValue
        }
    }

    override suspend fun writeTo(
        t: WordGenerationSettingsDataModel,
        output: OutputStream,
    ) {
        output.write(
            Json.encodeToString(
                serializer = WordGenerationSettingsDataModel.serializer(),
                value = t,
            ).toByteArray(),
        )
    }
}
