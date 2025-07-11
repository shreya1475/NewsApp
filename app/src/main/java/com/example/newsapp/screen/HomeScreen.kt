package com.example.newsapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import android.net.Uri
import java.net.URLDecoder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.animation.AnimatedVisibility


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val posts = (23 downTo 1).map { "Post $it" }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF282828)) // light gray background
        ) {
            TopAppBar(
                title = {
                    Text("NewsApp", fontWeight = FontWeight.Bold)
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                    IconButton(onClick = { navController.navigate("profile")}) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )


            Spacer(modifier = Modifier.height(2.dp))

            Column(modifier = Modifier.fillMaxWidth()) {


                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Published Today", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("5", color = Color(0xFF087DC5), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Total Posts", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("100", color = Color(0xFF087DC5), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Total Drafts", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("5", color = Color(0xFF087DC5), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Pending", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("5", color = Color(0xFF087DC5), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("New Comments", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("100", color = Color(0xFF087DC5), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Spam", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("5", color = Color(0xFF087DC5), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .weight(1.1f)
                            .padding(end = 8.dp)
                    ) {
                        Text("Analytics")
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .weight(1.1f)
                            .padding(end = 8.dp)
                    ) {
                        Text("Manage")
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))



                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxHeight(),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(posts) { post ->
                        Card(
                            onClick = {
                                val encodedTitle = Uri.encode(post)
                                navController.navigate("postDetail/$encodedTitle")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.Black),
                            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = post,
                                modifier = Modifier.padding(16.dp),
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
        var expanded by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            AnimatedVisibility(visible = expanded) {
                Column {
                    Button(
                        onClick = { /* action for 1 */ },
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text("New Post")
                    }
                    Button(
                        onClick = { /* action for 2 */ },
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text("Option 2")
                    }
                    Button(
                        onClick = { /* action for 3 */ },
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text("Option 3")
                    }
                }
            }

            FloatingActionButton(
                onClick = { expanded = !expanded },
                containerColor = Color(0xFF087DC5),
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    }

    @Composable
    fun PostRow(startIndex: Int) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 0..2) {
                Card(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Text("#Post ${startIndex + i + 1}", color = Color.Black)
                    }
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailScreen(title: String) {
    val decodedTitle = URLDecoder.decode(title, "UTF-8")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
//            .padding(16.dp)
    ) {
        TopAppBar(
            title = {
                Text("NewsApp", fontWeight = FontWeight.Bold)
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White,
            )
        )
        Text(text = decodedTitle, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "This is the full content of \"$decodedTitle\". You can replace this with actual post content.",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}
