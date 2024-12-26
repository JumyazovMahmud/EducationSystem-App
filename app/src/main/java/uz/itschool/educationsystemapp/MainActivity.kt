package uz.itschool.educationsystemapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.navigation.AppNavHost
import uz.itschool.educationsystemapp.screen.admin.AdminHomeScreen
import uz.itschool.educationsystemapp.ui.theme.EducationSystemAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationSystemAppTheme {
//                val mydb = AppDataBase.getInstance(this)
//                mydb.getStudentRepository().addStudent(
//                    Student(
//                        "admin",
//                        "admin",
//                        "admin",
//                        "admin",
//                        "root"
//                    )
//                )

//                if(mydb.getStudentRepository().getStudentByUsername("admin") != null) {
////                AppNavHost(navController = rememberNavController())
//                    AdminHomeScreen()
//                }
//                else{
                    AppNavHost(navController = rememberNavController())
//                }
            }
        }
    }
}