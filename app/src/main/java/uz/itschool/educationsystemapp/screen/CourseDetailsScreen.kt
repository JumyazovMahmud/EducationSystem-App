package uz.itschool.educationsystemapp.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
                .background(Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse),
                contentDescription = "Header Background",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(404.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.FillBounds
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { navController.navigate("home/$id") },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back Icon",
                            modifier = Modifier.size(24.dp).clickable { navController.navigate("home/$id") }
                        )
                    }

                    Text(
                        text = "Course",
                        fontSize = 24.sp,
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
                            modifier = Modifier.size(30.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = courseName,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(60.dp))
                    BeginnerDropdown()
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(top = 250.dp).background(Color.Transparent)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().background(Color.Transparent)
                ) {
                    CourseCard(title = "Basics", progress = "4 / 5", imageId = R.drawable.icon1, color = Color(0xFFFAAB3B), 4)
                    Spacer(modifier = Modifier.width(12.dp))
                    CourseCard(
                        title = "Occupations",
                        progress = "1 / 5",
                        imageId = R.drawable.icon2,
                        color = Color(0xFFF03E56),
                        1
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CourseCard(
                        title = "Conversation",
                        progress = "3 / 5",
                        imageId = R.drawable.icon3,
                        color = Color(0xFF5592D9),
                        3
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    CourseCard(title = "Places", progress = "1 / 5", imageId = R.drawable.icon4, color = Color(0xFF2FC75C), 1)
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CourseCard(
                        title = "Family Members",
                        progress = "3 / 5",
                        imageId = R.drawable.icon5,
                        color = Color(0xFF9839F0),
                        3
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    CourseCard(title = "Foods", progress = "2 / 5", imageId = R.drawable.icon6, color = Color(0xFF2D51BD), 2)
                }
            }
        }
    }
}


@Composable
fun CourseCard(title: String, progress: String, imageId: Int, color: Color, number: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(180.dp)
            .height(170.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
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

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier.size(145.dp , 5.dp).background(Color.Gray, RoundedCornerShape(10.dp))
            ){
                Box(modifier = Modifier.size( if(number == 1) 29.dp else if(number == 2) 58.dp else if(number == 3) 87.dp else if(number == 4) 116.dp else 145.dp).background(color, RoundedCornerShape(10.dp)))
            }
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
                containerColor = Color.White,
                contentColor = Color(0xFF673AB7)
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(4.dp),
            modifier = Modifier.size(115.dp, 33.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedLevel,
                    color = Color(0xFF513174),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))

                Image(
                    painter = painterResource(R.drawable.arrow_dropdown),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Dropdown Icon"
                )
            }
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
        CourseDetailsScreen(rememberNavController(), appDataBase = AppDataBase.getInstance(LocalContext.current), "Spanish", 0)
    }
}
