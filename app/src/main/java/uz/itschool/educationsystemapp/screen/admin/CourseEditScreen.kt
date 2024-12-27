package uz.itschool.educationsystemapp.screen.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.screen.connection
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

@Composable
fun CourseEditScreen(navController: NavController, appDataBase: AppDataBase, text: String ) {
    var courseName by remember { mutableStateOf(if (text == "create") "" else text) }
    var duration by remember { mutableStateOf("0") }

    if (text != "create") {
        val course: Course? = appDataBase.getCourseRepository().getCourseByName(text)
//    courseName = course?.courseName ?: ""
        duration = course?.duration.toString() ?: "0"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



    Text(text = if(text == "create") "Creation" else text, fontWeight = FontWeight.Bold, fontSize = 32.sp)

    OutlinedTextField(
        value = courseName,
        onValueChange = { courseName = it },
        label = { Text("Course Name") },
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


    Column (
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            onClick = {
                if (courseName.isNotBlank() && duration.isNotBlank()) {
                    uz.itschool.educationsystemapp.screen.admin.connection(appDataBase, courseName, duration, text)
                    navController.navigate("admin-course")
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

        if (text != "create") {
            OutlinedButton(
                onClick = {
                    appDataBase.getCourseRepository().deleteCourseById(
                        appDataBase.getCourseRepository().getCourseByName(text)?.courseId ?: 0
                    )
                    navController.navigate("admin-course")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .height(50.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
            ) {
                Text(
                    text = "Delete",
                    fontSize = 16.sp,
                    color = Color(0xFF3F51B5)
                )
            }


            OutlinedButton(
                onClick = {
                    navController.navigate("admin-course")
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
            }}
    }


}
    }




fun connection(appDataBase: AppDataBase, courseName: String, duration: String, text: String){
    if(text == "create"){
        appDataBase.getCourseRepository().addCourse(Course(courseName, duration))
    }else{
        appDataBase.getCourseRepository().updateCourse(appDataBase.getCourseRepository().getCourseByName(text)?.courseId, courseName, duration)
    }

}

@Preview(showBackground = true)
@Composable
fun CourseEditScreenPreview() {
    EducationSystemAppTheme {
        CourseEditScreen(rememberNavController(), appDataBase = AppDataBase.getInstance(LocalContext.current), "create")

    }
}