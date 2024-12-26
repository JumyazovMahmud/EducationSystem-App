package uz.itschool.educationsystemapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.itschool.educationsystemapp.R
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme


@Composable
fun AccessScreen(navController: NavController, appDataBase: AppDataBase) {
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
            Text(
                text = "EDUCATION",
                modifier = Modifier.padding(top = 105.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )

            Spacer(modifier = Modifier.height(70.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.rect),
                    contentDescription = "Skill Up Rectangle",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 30.dp, x = 42.dp)

                )


                //Text elements

                Column(
                    modifier = Modifier
                        .padding(25.dp, top = 180.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "STAY HOME",
                        color = Color(0xFFFF5722),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "SKILL UP!",
                        color = Color(0xFF1A237E),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 40.sp
                    )
                    Text(
                        text = "Quarantine is never an excuse \nto do nothing",
                        color = Color.DarkGray,
                        fontSize = 15.sp,
                        lineHeight = 15.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(110.dp))

            // Buttons
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .height(50.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF513174), Color(0xFF4F61BB))
                        ),
                        shape = MaterialTheme.shapes.small
                    )
                    .clickable {  },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Log in",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
            ) {
                Text(text = "Sign up", fontSize = 16.sp, color = Color(0xFF3F51B5))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccessScreenPreview() {
    EducationSystemAppTheme {
        AccessScreen(rememberNavController(), appDataBase = AppDataBase.getInstance(LocalContext.current))
    }
}