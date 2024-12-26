package uz.itschool.educationsystemapp.screen.admin

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.screen.Subject
import uz.itschool.educationsystemapp.screen.SubjectButton

@Composable
fun AdminCourseScreen(navController: NavController, appDataBase: AppDataBase) {

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Row {
            IconButton(
                onClick = { navController.navigate("admin-home") },
                modifier = Modifier.size(36.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Text(
            text = "Subjects",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


        val names = appDataBase.getCourseRepository().getAllCourses()
            .groupBy { it?.courseName ?: "" }

        val defaultColors = listOf(
            Color(0xFF2196F3),
            Color(0xFFFF5722),
            Color(0xFFE91E63),
            Color(0xFFCD853F),
            Color(0xFF4CAF50),
            Color(0xFF9C27B0)
        )

        val subjects = names.keys.filter { it.isNotEmpty() }.mapIndexed { index, courseName ->
            Subject(
                name = courseName,
                color = defaultColors[index % defaultColors.size]
            )
        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(subjects.size) { index ->
                val subject = subjects[index]
                SubjectButton(
                    text = subject.name,
                    color = subject.color,
                    navController = navController,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }

        OutlinedButton(
            onClick = { navController.navigate("course-edit/create") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(text = "Add Course", fontSize = 32.sp, color = Color(0xFF3F51B5))
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
fun SubjectButton(
    text: String,
    color: Color,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { navController.navigate("course-edit/$text") },
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