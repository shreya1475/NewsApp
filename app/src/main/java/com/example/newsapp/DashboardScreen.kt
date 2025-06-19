package com.example.newsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.navigation.NavHostController


@Composable
fun DashboardScreen(
    publishedToday: Int = 5,
    totalPosts: Int = 105,
    drafts: Int = 3,
    pending: Int = 11,
    newComments: Int = 201,
    spam: Int = 25,
    posts: List<Post> = dummyPosts(),
    navController: NavHostController,
    onAnalyticsClick: () -> Unit = {},
    onManageClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("COEP NEWS", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row {
                IconButton(onClick = { /* search */ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                IconButton(onClick = {
                    navController.navigate("profile")
                }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        MetricsRow(
            publishedToday,
            totalPosts,
            drafts,
            pending,
            newComments,
            spam
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onAnalyticsClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text("ANALYTICS", fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = onManageClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text("MANAGE", fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(posts) { post ->
                PostItem(post)
            }
        }
    }
}

@Composable
fun MetricsRow(
    publishedToday: Int,
    totalPosts: Int,
    drafts: Int,
    pending: Int,
    newComments: Int,
    spam: Int
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            MetricItem("Published today", publishedToday.toString())
            MetricItem("Total Posts", totalPosts.toString())
            MetricItem("Drafts", drafts.toString())
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            MetricItem("Pending", pending.toString())
            MetricItem("New Comments", newComments.toString())
            MetricItem("Spam", spam.toString())
        }
    }
}

@Composable
fun MetricItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            value,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            label,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray, RoundedCornerShape(8.dp))
            .padding(12.dp)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "POST #${post.id}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = post.date,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = post.description,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

data class Post(val id: Int, val description: String, val date: String)

fun dummyPosts(): List<Post> = listOf(
    Post(23, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "13/04/2025"),
    Post(22, "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", "13/04/2025"),
    Post(21, "It has survived not only five centuries, but also the leap into electronic typesetting.", "13/04/2025")
)
