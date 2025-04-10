package uvis.irin.yuzu.core.genai.repository.impl

import android.content.Context
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import com.google.mediapipe.tasks.genai.llminference.LlmInference.LlmInferenceOptions
import com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession
import com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession.LlmInferenceSessionOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uvis.irin.yuzu.core.genai.repository.GenAiRepository
import java.io.File
import java.io.FileOutputStream
import kotlin.random.Random

internal class LlmRepository(
    private val context: Context,
) : GenAiRepository {
    override suspend fun generateResponse(prompt: String): Result<String> = withContext(Dispatchers.IO) {
        val storageDir = context.cacheDir
        val modelFile = File(storageDir, MODEL_FILE_NAME)
        context.assets.open(MODEL_FILE_NAME).use { input ->
            FileOutputStream(modelFile).use { output ->
                input.copyTo(output)
            }
        }

        val taskOptions = LlmInferenceOptions.builder()
            .setModelPath(modelFile.path)
            .setPreferredBackend(LlmInference.Backend.CPU)
            .build()
        val llmInference = LlmInference.createFromOptions(context, taskOptions)

        val llmInferenceSessionOptions = LlmInferenceSessionOptions.builder()
            .setTemperature(TEMPERATURE)
            .setTopK(TOP_K)
            .setRandomSeed(Random.nextInt())
            .build()
        val llmInferenceSession = LlmInferenceSession.createFromOptions(llmInference, llmInferenceSessionOptions)

        llmInferenceSession.addQueryChunk(prompt)
        val modelResponse = llmInferenceSession.generateResponse()

        llmInferenceSession.close()
        llmInference.close()

        return@withContext Result.success(modelResponse)
    }

    companion object {
        private const val MODEL_FILE_NAME = "gemma3-1b-it-int4.task"
        private const val TEMPERATURE = 0.8f
        private const val TOP_K = 10
    }
}
