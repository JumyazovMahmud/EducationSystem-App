package uz.itschool.educationsystemapp.screen.admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

@Composable
fun AdminHomeScreen(navController: NavController, appDataBase: AppDataBase){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        OutlinedButton(
            onClick = { navController.navigate("admin-course") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(text = "Course", fontSize = 32.sp, color = Color(0xFF3F51B5))
        }

        OutlinedButton(
            onClick = { navController.navigate("admin-student") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp ,vertical = 20.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(text = "Enrollment", fontSize = 32.sp, color = Color(0xFF3F51B5))
        }



        OutlinedButton(
            onClick = { navController.navigate("admin-test-course") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(text = "TestCourse", fontSize = 32.sp, color = Color(0xFF3F51B5))
        }

        OutlinedButton(
            onClick = { navController.navigate("access") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(100.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
        ) {
            Text(text = "Back", fontSize = 32.sp, color = Color(0xFF3F51B5))
        }
    }
}