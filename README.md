![Screenshot_20260410_190545](https://github.com/user-attachments/assets/3f0a12af-8d47-4893-ae1d-68bf65f833e6)Txtify - Text Extraction App

A powerful Android application that uses Google ML Kit to extract text from images in real-time. Simply take a photo or select an image from your gallery, and Txtify will instantly recognize and extract all text using advanced machine learning technology.
📸 Features

Real-time Text Recognition - Extract text from images using Google ML Kit's Text Recognition API
Multi-source Input - Capture photos directly from the camera or select from your device gallery
Multiple Language Support - Supports English, Chinese, Hindi, and more languages
Easy Text Copying - One-tap copy functionality to quickly copy extracted text to clipboard
Clean UI - Intuitive and user-friendly interface built with Material Design
Fast Processing - Optimized ML Kit integration for quick text extraction
Offline Capability - Text recognition works offline once ML Kit models are downloaded

🛠️ Tech Stack

Language: Kotlin
ML Framework: Google ML Kit (Text Recognition)
Android Version: Minimum SDK 21 (Android 5.0+)
Architecture: MVVM / MVP
Build Tool: Gradle

Key Libraries
gradle// ML Kit - Text Recognition
implementation 'com.google.mlkit:text-recognition:16.0.0'

// Camera
implementation 'androidx.camera:camera-core:1.3.0'
implementation 'androidx.camera:camera-camera2:1.3.0'
implementation 'androidx.camera:camera-lifecycle:1.3.0'

// Material Design
implementation 'com.google.android.material:material:1.10.0'

// Kotlin Coroutines
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0'
📋 Requirements

Android 5.0 (API Level 21) or higher
Camera permission for capturing photos
Storage permission for accessing gallery images
Internet connection (for initial ML Kit model download)

🚀 Getting Started
Installation

Clone the repository

bash   git clone https://github.com/yourusername/txtify.git
   cd txtify

Open in Android Studio

File → Open → Select the project directory
Wait for Gradle sync to complete


Add Firebase/ML Kit Configuration

The app uses Google ML Kit, which may require Firebase configuration
Follow ML Kit Setup Guide if needed


Build and Run

bash   ./gradlew build
   ./gradlew installDebug
Or use Android Studio's Run button
Permissions
The app requires the following permissions in AndroidManifest.xml:
xml<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.INTERNET" />
💻 Usage

Launch the App - Open Txtify on your Android device
Choose Input Method

Tap Camera to take a new photo
Tap Gallery to select an existing image


Select Language - Choose from English, Chinese, Hindi, or other supported languages
View Results - The app displays extracted text with an option to copy
Copy Text - Tap the "Copy Text" button to copy to clipboard

🏗️ Project Structure
txtify/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/yourpackage/
│   │   │   │   ├── activity/
│   │   │   │   │   └── MainActivity.kt
│   │   │   │   ├── fragment/
│   │   │   │   ├── viewmodel/
│   │   │   │   ├── repository/
│   │   │   │   └── util/
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   └── values/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle.kts
└── gradle/
🔧 ML Kit Text Recognition Implementation
Basic Usage
kotlinimport com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

val image = InputImage.fromBitmap(bitmap)
recognizer.process(image)
    .addOnSuccessListener { visionText ->
        val resultText = visionText.text
        // Use the extracted text
    }
    .addOnFailureListener { e ->
        // Handle errors
    }
Language Specific Recognition
kotlinimport com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions
import com.google.mlkit.vision.text.devanagari.DevanagariTextRecognizerOptions

// For Chinese
val chineseRecognizer = TextRecognition.getClient(
    ChineseTextRecognizerOptions.Builder().build()
)

// For Hindi (Devanagari)
val hindiRecognizer = TextRecognition.getClient(
    DevanagariTextRecognizerOptions.Builder().build()
)
📸 Screenshots

![Screenshot_20260410_190613](https://github.com/user-attachments/assets/7fff5a93-97eb-4298-a364-2f586f3eee9c)
![Screenshot_20260410_190545](https://github.com/user-attachments/assets/cafc089b-dd33-4f81-b521-0708631e677b)



🎯 Features in Development

 Batch image processing
 Document scanning mode
 Text translation integration
 Cloud backup of extracted text
 Dark mode support
 Voice output
 Advanced OCR filters

🐛 Known Issues

Large images may take longer to process
Some handwritten text may not be recognized accurately
Language detection might need manual selection for mixed-language documents

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.
🤝 Contributing
Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

Fork the repository
Create your feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a Pull Request

📞 Support
If you encounter any issues or have questions, please:

Open an Issue
Check existing documentation
Contact the maintainer

🙏 Acknowledgments

Google ML Kit for the powerful text recognition API
Android Architecture Components
Kotlin for an amazing language

📚 Resources

ML Kit Documentation
Android Developer Guide
Kotlin Documentation
Material Design


Made with ❤️ using Kotlin and ML Kit
Last Updated: April 2026
