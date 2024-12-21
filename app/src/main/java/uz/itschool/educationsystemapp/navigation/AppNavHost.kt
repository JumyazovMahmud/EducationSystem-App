package uz.itschool.educationsystemapp.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import uz.itschool.educationsystemapp.db.AppDataBase



@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController,
               startDestination:String = "view-todo-item",
               appDataBase: AppDataBase
){

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("add-todo-item") {
//            AddToDoItemScreen(navController, appDataBase = appDataBase)
        }
        composable("edit-todo-item/{id}") {
                navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let {
//                EditToDoItemScreen(navController, appDataBase = appDataBase, id= id.toInt())
            }

        }
        composable("view-todo-item") {
//            ViewToDoItemsScreen(navController, appDataBase = appDataBase)
        }
    }
}