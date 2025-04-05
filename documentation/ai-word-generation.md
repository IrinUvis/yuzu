# AI Word Generation

For the purpose of word generation a Google model is used from the family of open source models Gemma - more specifically Gemma-3 1B.

It is available for anyone to use and can be downloaded from [Hugging Face](https://huggingface.co/litert-community/Gemma3-1B-IT).
The variant used is the instruction tuned model in a 4-bit quantized format (gemma3-1b-it-int4.task).
Google AI Edge library
The model is used via (MediaPipe Tasks Google AI Edge library)[https://ai.google.dev/edge/mediapipe/solutions/tasks].

The model should be put in the assets folder of the :data:genai module

*Note*: The MediaPipe Tasks LLM Inference API does not fully support device emulators so using a physical devices is recommended in order to avoid crashes, performance issues, and unexpected behaviours. 
