package uz.itschool.educationsystemapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

@Composable
fun CourseDetailsScreen(navController: NavController, appDataBase: AppDataBase, courseName: String, id:Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.head_part),
                contentDescription = "Header Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Handle back action */ },
                    modifier = Modifier.size(36.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back Icon",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Course",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                IconButton(
                    onClick = { /* Handle more action */ },
                    modifier = Modifier.size(36.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = "More Icon",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Spanish",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(60.dp))
                BeginnerDropdown()
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CourseCard(title = "Basics", progress = "4 / 5", imageId = R.drawable.icon1)
                Spacer(modifier = Modifier.width(12.dp))
                CourseCard(
                    title = "Occupations",
                    progress = "1 / 5",
                    imageId = R.drawable.icon2
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CourseCard(
                    title = "Conversation",
                    progress = "3 / 5",
                    imageId = R.drawable.icon3
                )
                Spacer(modifier = Modifier.width(12.dp))
                CourseCard(title = "Places", progress = "1 / 5", imageId = R.drawable.icon4)
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CourseCard(
                    title = "Family Members",
                    progress = "3 / 5",
                    imageId = R.drawable.icon5
                )
                Spacer(modifier = Modifier.width(12.dp))
                CourseCard(title = "Foods", progress = "2 / 5", imageId = R.drawable.icon6)
            }
        }
    }
}





@Composable
fun CourseCard(title: String, progress: String, imageId: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(180.dp)
            .height(170.dp)
            .padding(4.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = androidx.compose.material3.CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "$title Icon",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = progress,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun BeginnerDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selectedLevel by remember { mutableStateOf("Beginner") }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart).padding(top =10.dp)
    ) {
        Button(
            onClick = { expanded = true },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF673AB7)
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(4.dp)
        ) {
            Text(
                text = selectedLevel,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Icon",
                tint = Color.White
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            val levels = listOf("Beginner", "Intermediate", "Advanced")

            levels.forEach { level ->
                DropdownMenuItem(
                    onClick = {
                        selectedLevel = level
                        expanded = false
                    },
                    text = { Text(level) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CourseDetailsScreenPreview() {
    EducationSystemAppTheme {
        CourseDetailsScreen()
    }
}
