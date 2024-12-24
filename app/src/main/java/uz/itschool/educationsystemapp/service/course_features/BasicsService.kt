package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.module.course_features.Basics
import uz.itschool.educationsystemapp.util.CRUD

class BasicsService(context: Context) : CRUD<BasicsDto, Basics, Int>{
    val basicsRepository = AppDataBase.getInstance(context)
    override fun create(dto: BasicsDto): ResponseDto<BasicsDto?> {
        TODO("Not yet implemented")
    }

    override fun update(dto: BasicsDto, id: Int): ResponseDto<BasicsDto?> {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): ResponseDto<BasicsDto?> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): ResponseDto<BasicsDto?> {
        TODO("Not yet implemented")
    }


}