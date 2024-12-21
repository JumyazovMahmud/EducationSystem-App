package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto

class BasicsService(context: Context) {
    val db = AppDataBase.getInstance(context)
    fun create(dto: BasicsDto){

    }

    fun update(dto:BasicsDto, id:Int){

    }

    fun delete(id:Int){

    }

    fun get(id:Int){

    }


}