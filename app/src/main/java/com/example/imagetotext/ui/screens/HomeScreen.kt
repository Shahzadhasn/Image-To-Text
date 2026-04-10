package com.example.imagetotext.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagetotext.OcrViewModel
import com.example.imagetotext.ui.theme.TalTeal
import com.example.imagetotext.ui.theme.TalLightBlue
import com.example.imagetotext.ui.theme.ImageToTextTheme
import com.google.mlkit.vision.common.InputImage

@Composable
fun HomeScreen(viewModel: OcrViewModel, onNavigateToResult: () -> Unit) {
    val context = LocalContext.current

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { viewModel.runOcr(context, InputImage.fromFilePath(context, it), onNavigateToResult) }
    }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let { viewModel.runOcr(context, InputImage.fromBitmap(it, 0), onNavigateToResult) }
    }

    HomeContent(
        scanCount = viewModel.scanCount,
        isProcessing = viewModel.isProcessing,
        onCameraClick = { cameraLauncher.launch() },
        onGalleryClick = { galleryLauncher.launch("image/*") }
    )
}

@Composable
fun HomeContent(
    scanCount: Int,
    isProcessing: Boolean,
    onCameraClick: () -> Unit,
    onGalleryClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isProcessing) {
            CircularProgressIndicator(color = TalTeal)
            Spacer(Modifier.height(16.dp))
        }
        
        Icon(Icons.Default.CameraAlt, null, modifier = Modifier.size(80.dp), tint = TalTeal)
        Spacer(Modifier.height(24.dp))
        Text(
            "Take a photo or select an image\nto extract text",
            textAlign = TextAlign.Center, color = TalTeal, fontSize = 16.sp
        )
        Spacer(Modifier.height(48.dp))
        Row {
            Button(
                onClick = onCameraClick,
                colors = ButtonDefaults.buttonColors(TalLightBlue)
            ) {
                Text("Camera", color = TalTeal)
            }
            Spacer(Modifier.width(20.dp))
            Button(
                onClick = onGalleryClick,
                colors = ButtonDefaults.buttonColors(TalLightBlue)
            ) {
                Text("Gallery", color = TalTeal)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    ImageToTextTheme {
        HomeContent(
            scanCount = 5,
            isProcessing = false,
            onCameraClick = {},
            onGalleryClick = {}
        )
    }
}
