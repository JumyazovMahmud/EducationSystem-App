package uz.itschool.educationsystemapp.screen.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.module.TestCourse

@Composable
fun TestCourseEditScreen(navController: NavController, appDataBase: AppDataBase, text: String) {
    var courseName by remember { mutableStateOf(if (text == "create") "" else text) }
    var topic by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("0") }

    if(text != "create") {
        val testCourse: TestCourse? =
            appDataBase.getTestCourseRepository().getTestCourseByCourseName(text)
        duration = testCourse?.duration.toString() ?: "0"
        topic = testCourse?.topic ?: ""
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row {
            IconButton(
                onClick = { navController.navigate("admin-test-course") },
                modifier = Modifier.size(36.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Text(text = text , fontWeight = FontWeight.Bold, fontSize = 32.sp)

        OutlinedTextField(
            value = courseName,
            onValueChange = {courseName = it },
            label = { Text("Test Course Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = topic,
            onValueChange = {topic = it },
            label = { Text("Topic") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text("Duration") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )


        Column(Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            OutlinedButton(
                onClick = {
                    if(courseName.isNotBlank() && topic.isNotBlank() && duration.isNotBlank()) {
                        connection(appDataBase, courseName, topic, duration.toInt(), text)
                        navController.navigate("admin-test-course")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
            ) {
                Text(
                    text = if (text == "create") "Add" else "Save",
                    fontSize = 16.sp,
                    color = Color(0xFF3F51B5)
                )
            }

            if(text != "create"){
                OutlinedButton(
                    onClick = {
                        appDataBase.getTestCourseRepository().deleteTestCourseByCourseName(text)
                        navController.navigate("admin-test-course")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(50.dp),
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
                ) {
                    Text(
                        text = "Delete",
                        fontSize = 16.sp,
                        color = Color(0xFF3F51B5)
                    )
                }
            }

            OutlinedButton(
                onClick = {
                    navController.navigate("admin-test-course")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .height(50.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
            ) {
                Text(
                    text = "Back",
                    fontSize = 16.sp,
                    color = Color(0xFF3F51B5)
                )
            }
        }


    }
}

fun connection(appDataBase: AppDataBase, courseName: String, topic: String, duration: Int, text: String){
    if(text == "create" && appDataBase.getCourseRepository().getCourseByName(courseName) != null){
        appDataBase.getTestCourseRepository().addTestCourse(TestCourse(courseName, topic, duration))
    }else{
        appDataBase.getTestCourseRepository().updateTestCourseByCourseName(courseName, topic, duration)

    }
}