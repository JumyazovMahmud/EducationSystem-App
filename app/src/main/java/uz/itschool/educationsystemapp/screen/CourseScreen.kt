package uz.itschool.educationsystemapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

@Composable
fun CourseScreen(navController: NavController, appDataBase: AppDataBase, id:Int) {

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
            IconButton(onClick = {navController.navigate("home/$id")}) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp) 
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        val names = appDataBase.getCourseRepository().getAllCourses()
            .groupBy { it?.courseName ?: "" }



        val defaultColors :Map<Int, List<Color>> = mapOf(
            0 to listOf(Color(0xFF2196F3) , Color(0xFF6FA8FF)) ,
            1 to listOf(Color(0xFFFF5722) , Color(0xFFFF7A8C)) ,
            2 to listOf(Color(0xFFE91E63) , Color(0xFFFFAB5F)) ,
            3 to listOf(Color(0xFFCD853F) , Color(0xFFFFE957)) ,
            4 to listOf(Color(0xFF4CAF50) , Color(0xFF3A8CFF)) ,
            5 to listOf(Color(0xFF9C27B0) , Color(0xFFFF8C2F))
        )

        val subjects = names.keys.filter { it.isNotEmpty() }.mapIndexed { index, courseName ->
            CourseItem(
                name = courseName,
                backgroundColorStart = defaultColors[index % defaultColors.size]?.get(0) ?: Color.White,
                backgroundColorEnd = defaultColors[index % defaultColors.size]?.get(1) ?: Color.White
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(subjects.size) { index ->
                val subject = subjects[index]
                CourseCard(
                    title = subject.name,
                    backgroundColorStart = subject.backgroundColorStart,
                    backgroundColorEnd = subject.backgroundColorEnd,
                    navController = navController,
                    id = id
                )
            }
        }
    }
}

data class CourseItem(val name: String, val backgroundColorStart: Color, val backgroundColorEnd: Color)


@Composable
fun CourseCard(title: String, backgroundColorStart: Color, backgroundColorEnd: Color, navController: NavController, id : Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(80.dp)
            .padding(top = 10.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(backgroundColorStart, backgroundColorEnd)
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { navController.navigate("course-details/$title/$id") },
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

@Preview(showBackground = true)
@Composable
fun CourseScreenPreview() {
    EducationSystemAppTheme {
        CourseScreen(rememberNavController(),  appDataBase = AppDataBase.getInstance(LocalContext.current), 0)
    }
}
