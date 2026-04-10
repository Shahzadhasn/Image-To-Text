package com.example.imagetotext.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagetotext.ui.theme.TalTeal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcrTopBar(scanCount: Int, onReset: () -> Unit) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.CameraAlt, contentDescription = null, tint = TalTeal)
                Spacer(Modifier.width(8.dp))
                Text("TAL-OCR", color = TalTeal, fontWeight = FontWeight.Bold)
            }
        },
        actions = {
            Surface(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.border(1.dp, TalTeal.copy(0.2f), RoundedCornerShape(20.dp)),
                color = androidx.compose.ui.graphics.Color.Transparent
            ) {
                Text(
                    "Scans: ${scanCount.toString().padStart(2, '0')}",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    fontSize = 12.sp, color = TalTeal
                )
            }
            IconButton(onClick = onReset) {
                Icon(Icons.Default.Refresh, contentDescription = "Reset", tint = TalTeal)
            }
        }
    )
}