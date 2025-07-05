package com.example.newsapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Publish
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import android.graphics.Rect
import android.view.ViewTreeObserver
import androidx.compose.ui.graphics.SolidColor

@Composable
fun PostEditorScreen() {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val view = LocalView.current
    val density = LocalDensity.current

    // Listen to keyboard height
    var keyboardHeightDp by remember { mutableStateOf(0.dp) }

    DisposableEffect(view) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.rootView.height
            val keyboardHeightPx = screenHeight - rect.bottom

            keyboardHeightDp = with(density) { keyboardHeightPx.toDp() }
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 38.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* back */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Row {
                    Button(
                        onClick = { /* publish */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .height(48.dp)
                            .width(110.dp)
                    ) {
                        Text("Publish", fontSize = 16.sp)
                    }
                    IconButton(onClick = { /* more */ }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)
                    }
                }
            }

            // Title input
            BasicTextField(
                value = title,
                onValueChange = { title = it },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                ),
                cursorBrush = SolidColor(Color.White.copy(alpha = 0.6f)),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (title.isEmpty()) {
                        Text("Add title", color = Color.Gray, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Content input
            BasicTextField(
                value = content,
                onValueChange = { content = it },
                textStyle = TextStyle(color = Color.White, fontSize = 18.sp, lineHeight = 28.sp),
                cursorBrush = SolidColor(Color.White.copy(alpha = 0.6f)),
                modifier = Modifier
                    .fillMaxSize(),
                decorationBox = { innerTextField ->
                    if (content.isEmpty()) {
                        Text("Start writing...", color = Color.Gray, fontSize = 18.sp)
                    }
                    innerTextField()
                }
            )
        }

        // Floating Add Image Button (appears above keyboard)
        FloatingActionButton(
            onClick = { /* open gallery or image picker */ },
            containerColor = Color.DarkGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = keyboardHeightDp + 16.dp) // shifts up above keyboard
        ) {
            Icon(Icons.Default.AddPhotoAlternate, contentDescription = "Add Image")
        }
    }
}
