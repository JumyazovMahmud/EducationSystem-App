package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.CourseDto
import uz.itschool.educationsystemapp.mapper.CourseMapper
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.util.CRUD

class CourseService(context: Context) : CRUD<CourseDto, Course, Int> {
    private val courseRepository = AppDataBase.getInstance(context).getCourseRepository()
    private val courseMapper = CourseMapper()
    override fun create(dto: CourseDto):Boolean{
        if(this.courseMapper.dtoToEntity(dto) in this.courseRepository.getAllCourses()){
            return false
        }
        this.courseRepository.addCourse(this.courseMapper.dtoToEntity(dto))
        return true
    }

    override fun get(id:Int): Course? {
        return this.courseRepository.getCourseById(id)
    }

    override fun update(dto: CourseDto, id: Int): Boolean {
        if (this.courseRepository.getCourseById(id) != null) {
            this.courseRepository.updateCourse(
                dto.courseId,
                dto.courseName,
                dto.duration)
            return true
        }
        return false
    }

    override fun delete(id: Int): Boolean {
        if (this.courseRepository.getCourseById(id) != null) {
            this.courseRepository.deleteCourseById(id)
            return true
        }
        return false
    }
}