package uz.itschool.educationsystemapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import uz.itschool.educationsystemapp.screen.HomeScreen
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationSystemAppTheme {
                HomeScreen()
            }
        }
    }
}