package uz.itschool.educationsystemapp.screen.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.module.TestCourse
import uz.itschool.educationsystemapp.screen.PendingTestCard

@Composable
fun AdminTestCourseScreen(navController: NavController, appDataBase: AppDataBase){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
//        Row {
//            Text(
//                text = "$number Pending tests",
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp
//            )
//            Spacer(modifier = Modifier.width(9.dp))
//            Image(
//                painter = painterResource(id = R.drawable.info),
//                contentDescription = "Custom Icon",
//                modifier = Modifier.size(16.dp).offset(y=4.dp),
//                colorFilter = ColorFilter.tint(Color.Red)
//            ) }
//
//
//        Spacer(modifier = Modifier.height(8.dp))

        val testCourses = appDataBase.getTestCourseRepository().getAllTestCourse()
        if(testCourses.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(testCourses.size) { index ->
                    val course = testCourses[index] ?: TestCourse(
                        1,
                        "",
                        "",
                        ""
                    )
                    PendingTestCard(
                        subject = course.topic,
                        category = course.courseName,
                        time = course.duration,
                        modifier = Modifier.padding(8.dp),
                        navController
                    )
                }
            }
        }

        OutlinedButton(
            onClick = { navController.navigate("test-course-edit/create") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(text = "Add Test Course", fontSize = 32.sp, color = Color(0xFF3F51B5))
        }

        OutlinedButton(
            onClick = {
                navController.navigate("admin-home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(
                text = "Back",
                fontSize = 32.sp,
                color = Color(0xFF3F51B5)
            )
        }

    }
}

@Composable
fun PendingTestCard(
    subject: String,
    category: String,
    time: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = modifier.clickable { navController.navigate("test-course-edit/$category") },
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
                    text = time.toString(),
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}