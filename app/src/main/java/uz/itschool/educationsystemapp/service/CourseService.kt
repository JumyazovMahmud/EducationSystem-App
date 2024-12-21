package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.CourseDto
import uz.itschool.educationsystemapp.module.Course

class CourseService(context: Context) {
    val courseRepository = AppDataBase.getInstance(context).getCourseRepository()

    fun create(dto: CourseDto){

    }

    fun update (dto: CourseDto, courseName: String, id:Int){

    }

    fun delete(courseName:String, id:Int){

    }

    fun get(id:Int){

    }
}