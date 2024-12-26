package uz.itschool.educationsystemapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase

@Composable
fun HomeScreen(navController: NavController, appDataBase: AppDataBase, id: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        // Top Bar
        TopBar()

        Spacer(modifier = Modifier.height(16.dp))

        // Welcome Message
        WelcomeMessage(name = "Rohan", pendingTests = 4)

        Spacer(modifier = Modifier.height(16.dp))

        // Points Card
        PointsCard(points = 300)

        Spacer(modifier = Modifier.height(24.dp))

        // Pending Tests
        PendingTests()

        Spacer(modifier = Modifier.height(24.dp))

        // Subjects
        SubjectsGrid()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* TODO */ },
            modifier = Modifier.offset(x = (-12).dp)) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }

            Image(
                painter = painterResource(R.drawable.user),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun WelcomeMessage(name: String, pendingTests: Int) {
    Column {
        Text(
            text = "Hi $name,",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = buildAnnotatedString {
                append("You have ")
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append("$pendingTests pending test")
                }
                append(" this week")
            },
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Composable
fun PointsCard(points: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4169E1))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                Row(
                    verticalAlignment =  Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "$points",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Points",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 2.dp, bottom = 5.dp)
                    )
                }
                Text(
                    text = "Cross 500 within the week to\nget a free One on One Class.",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            }

            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(33.dp)
                    .width(120.dp)
            ) {
                Text(
                    text = "Take test now",
                    color = Color(0xFF4169E1),
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
fun PendingTests() {
    Column {
        Row {
            Text(
            text = "4 Pending tests",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
            Spacer(modifier = Modifier.width(9.dp))
            Image(
                painter = painterResource(id = R.drawable.info),
                contentDescription = "Custom Icon",
                modifier = Modifier.size(16.dp).offset(y=4.dp),
                colorFilter = ColorFilter.tint(Color.Red)
            ) }


        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PendingTestCard(
                subject = "Law of Motion",
                category = "Physics",
                time = "1d:10Hr",
                modifier = Modifier.weight(1f)
            )
            PendingTestCard(
                subject = "Law of Motion",
                category = "Chemistry",
                time = "1d:10Hr",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PendingTestCard(
                subject = "Law of Motion",
                category = "Maths",
                time = "1d:10Hr",
                modifier = Modifier.weight(1f)
            )
            PendingTestCard(
                subject = "Law of Motion",
                category = "Physics",
                time = "1d:10Hr",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun PendingTestCard(
    subject: String,
    category: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = subject,
                fontWeight = FontWeight.Medium
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = category,
                    color = when (category) {
                        "Physics" -> Color(0xFFE91E63)
                        "Chemistry" -> Color(0xFFFF5722)
                        "Maths" -> Color(0xFF2196F3)
                        else -> Color.Gray
                    },
                    fontSize = 12.sp
                )
                Text(
                    text = time,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun SubjectsGrid() {
    Column {
        Text(
            text = "Subjects",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SubjectButton(
                text = "Mathematics",
                color = Color(0xFF2196F3),
                modifier = Modifier.weight(1f)
            )
            SubjectButton(
                text = "Chemistry",
                color = Color(0xFFFF5722),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SubjectButton(
                text = "Physics",
                color = Color(0xFFE91E63),
                modifier = Modifier.weight(1f)
            )
            SubjectButton(
                text = "Reasoning",
                color = Color(0xFFCD853F),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SubjectButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /* TODO */ },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController(), appDataBase = AppDataBase.getInstance(LocalContext.current), 0)
}