package uz.itschool.educationsystemapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.R

@Composable
fun CourseScreen(navController: NavController, id:Int) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4C1A81))
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier.size(36.dp) // Larger Menu Icon
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp) // Increased spacing
            ) {
                IconButton(onClick = { /* Handle notifications click */ }) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp) // Larger Notifications Icon
                    )
                }

                // Profile image
                Image(
                    painter = painterResource(id = R.drawable.user), // Replace with your drawable resource
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(48.dp) // Increased profile picture size
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

//        AnimatedVisibility(
//            visible = showCards,
//            enter = slideInHorizontally(initialOffsetX = { -it }), // Slide in from the left
//            exit = slideOutHorizontally(targetOffsetX = { -it }) // Slide out to the left
//        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                CourseCard(
                    title = "Mathematics",
                    backgroundColorStart = Color(0xFF3A8CFF),
                    backgroundColorEnd = Color(0xFF6FA8FF)
                )
                CourseCard(
                    title = "Physics",
                    backgroundColorStart = Color(0xFFFF5673),
                    backgroundColorEnd = Color(0xFFFF7A8C)
                )
                CourseCard(
                    title = "Chemistry",
                    backgroundColorStart = Color(0xFFFF8C2F),
                    backgroundColorEnd = Color(0xFFFFAB5F)
                )
                CourseCard(
                    title = "Reasoning",
                    backgroundColorStart = Color(0xFFFFC837),
                    backgroundColorEnd = Color(0xFFFFE957)
                )
            }

    }
}

@Composable
fun CourseCard(title: String, backgroundColorStart: Color, backgroundColorEnd: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f) // Adjust card width
            .height(80.dp) // Card height
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(backgroundColorStart, backgroundColorEnd)
                ),
                shape = RoundedCornerShape(16.dp) // Rounded corners
            )
            .clickable { /* Handle click */ },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

