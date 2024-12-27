package uz.itschool.educationsystemapp.screen.admin

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.educationsystemapp.db.AppDataBase

@Composable
fun StudentEditScreen(username: String, appDataBase: AppDataBase, navController: NavController) {
    val student = appDataBase.getStudentRepository().getStudentByUsername(username)
    var name = student?.name?: ""
    var email = student?.email?: ""
    var usernameField = student?.username?: ""
    var password = student?.password?:""
    var phone = student?.phone?:""

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally ) {

        Text("Edit Student", fontWeight = FontWeight.Bold, fontSize = 32.sp)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = usernameField,
            onValueChange = { usernameField = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Column {
            OutlinedButton(
                onClick = {
                    if (name.isNotBlank() && email.isNotBlank() && username.isNotBlank() && password.isNotBlank() && phone.isNotBlank()) {
                        appDataBase.getStudentRepository().updateStudent(
                            appDataBase.getStudentRepository().getStudentByUsername(username)?.studentId ?: 0,
                            name,
                            email,
                            phone,
                            username,
                            password
                        )
                        navController.navigate("admin-student")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
            ) {
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                    color = Color(0xFF3F51B5)
                )
            }

            OutlinedButton(
                onClick = {
                    appDataBase.getStudentRepository().deleteByUserName(username)
                    navController.navigate("admin-student")
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
        }
    }
}