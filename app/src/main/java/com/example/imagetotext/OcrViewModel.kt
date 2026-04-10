package com.example.imagetotext

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class OcrViewModel : ViewModel() {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    var scanCount by mutableIntStateOf(0)
        private set

    var recognizedText by mutableStateOf("")
        private set

    var isProcessing by mutableStateOf(false)
        private set

    fun runOcr(context: Context, image: InputImage, onTextExtracted: () -> Unit) {
        isProcessing = true
        recognizer.process(image)
            .addOnSuccessListener { visionText ->
                isProcessing = false
                recognizedText = visionText.text
                if (visionText.text.isNotEmpty()) {
                    scanCount++
                    Toast.makeText(context, "Text Extracted successfully!", Toast.LENGTH_LONG).show()
                    onTextExtracted()
                } else {
                    Toast.makeText(context, "No text found in image.", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                isProcessing = false
                Toast.makeText(context, "Error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    }

    fun clearResult() {
        recognizedText = ""
    }
}
