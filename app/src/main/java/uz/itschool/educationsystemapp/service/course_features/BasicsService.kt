package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.module.course_features.Basics
import uz.itschool.educationsystemapp.util.CRUD

class BasicsService(context: Context) : CRUD<BasicsDto, Basics, Int>{
    val basicsRepository = AppDataBase.getInstance(context)
    override fun create(dto: BasicsDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: BasicsDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Basics? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }


}