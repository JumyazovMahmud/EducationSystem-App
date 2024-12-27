package uz.itschool.educationsystemapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

@Composable
fun LogInScreen(navController: NavController, appDataBase: AppDataBase) {
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var valid by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.ellipse),
            contentDescription = "Ellipse Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "EDUCATION",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            Spacer(modifier = Modifier.height(35.dp))


            Image(
                painter = painterResource(id = R.drawable.asset),
                contentDescription = "Illustration",
                modifier = Modifier
                    .size(383.dp, 326.dp),
                contentScale = ContentScale.Fit
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Log in",
                    color = Color(0xFF1A237E),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = username,
                    onValueChange = {username = it },
                    label = { Text("Username") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                var passwordVisible by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(if (passwordVisible) R.drawable.view else R.drawable.hide),
                                contentDescription = "Toggle Password Visibility",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color(0xFF513174), Color(0xFF4F61BB))
                            )
                        )
                        .height(50.dp)
                        //todo:BACKEND CONNECTION
                        .clickable {

                            if(username.isNotBlank() && password.isNotBlank()) {
                                if(username == "admin" && password == "root"){
                                    navController.navigate("admin-home")
                                }
                               else if (connection(appDataBase, username, password) && username != "admin" && password != "root") {
                                    valid = false
                                    navController.navigate(
                                        "home/${
                                            appDataBase.getStudentRepository()
                                                .getStudentByUsername(username)?.studentId
                                        }"
                                    )
                                } else {
                                    valid = true
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Log in",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                TextButton(
                    onClick = {  },
                ) {
                    Text(
                        text = "Forget password?",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                TextButton(
                    onClick = { navController.navigate("sign-up") },
                ) {
                    Text(
                        text = "Don't have an account?",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Wrong username or password", color = Color.Red, modifier = Modifier.alpha(if(valid) 1f else 0f ), fontSize = 14.sp)
            }
        }
    }
}

fun connection(appDataBase: AppDataBase, username: String, password: String):Boolean{
    return appDataBase.getStudentRepository().getStudentByUsername(username) != null && appDataBase.getStudentRepository().getStudentByUsername(username)?.password == password
}

@Preview(showBackground = true)
@Composable
fun LogInScreenPreview() {
    EducationSystemAppTheme {
        LogInScreen(rememberNavController(), appDataBase = AppDataBase.getInstance(LocalContext.current))
    }
}
