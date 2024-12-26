package uz.itschool.educationsystemapp.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.screen.AccessScreen
import uz.itschool.educationsystemapp.screen.CourseDetailsScreen
import uz.itschool.educationsystemapp.screen.CourseScreen
import uz.itschool.educationsystemapp.screen.HomeScreen
import uz.itschool.educationsystemapp.screen.LogInScreen
import uz.itschool.educationsystemapp.screen.SignUpScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController,
               startDestination:String = "access",
               appDataBase: AppDataBase
){

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("course/{id}") {
            navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")?.toIntOrNull()?:0
            CourseScreen(navController, id)
        }
        composable("home/{id}") {
                navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let {
                HomeScreen(navController, appDataBase = appDataBase, id= id.toInt())
            }

        }
        composable("sign-up") {
            SignUpScreen(navController, appDataBase = appDataBase)
        }
        composable("log-in") {
            LogInScreen(navController, appDataBase = appDataBase)
        }
        composable("access") {
            AccessScreen(navController, appDataBase = appDataBase)
        }
        composable("course-details/{course-name}/{id}") { navBackStackEntry ->
            val courseName = navBackStackEntry.arguments?.getString("course-name")
            val id = navBackStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            courseName?.let {
            CourseDetailsScreen(navController, appDataBase = appDataBase, courseName, id)}
        }
    }
}