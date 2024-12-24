package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.CourseDto
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.PlacesDto
import uz.itschool.educationsystemapp.mapper.CourseMapper
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.util.CRUD

class CourseService(context: Context) : CRUD<CourseDto, Course, Int> {
    private val courseRepository = AppDataBase.getInstance(context).getCourseRepository()
    private val courseMapper = CourseMapper()

    override fun create(dto: CourseDto): ResponseDto<CourseDto?> {
        if(this.courseMapper.dtoToEntity(dto) in this.courseRepository.getAllCourses()){
            return ResponseDto<CourseDto?>(
                -1,
                "Not Found",
                null,
                false
            )
        }
        this.courseRepository.addCourse(
            this.courseMapper.dtoToEntity(dto)
        )
        return ResponseDto<CourseDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

    override fun get(id:Int): ResponseDto<CourseDto?> {
        if(this.courseRepository.getCourseById(id) == null){
            return ResponseDto<CourseDto?>(
                -1,
                "Not Found",
                null,
                false
            )
        }
        return ResponseDto<CourseDto?>(
            0,
            "OK",
            this.courseMapper.entityToDto(
                this.courseRepository.getCourseById(id)!!
            ),
            true
        )
    }

    override fun update(dto: CourseDto, id: Int): ResponseDto<CourseDto?> {
        if (this.courseRepository.getCourseById(id) != null) {
            this.courseRepository.updateCourse(
                dto.courseId,
                dto.courseName,
                dto.duration)
            return ResponseDto<CourseDto?>(
                0,
                "OK",
                dto,
                true
            )
        }
        return ResponseDto<CourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

     override fun delete(id: Int): ResponseDto<CourseDto?> {
        if (this.courseRepository.getCourseById(id) != null) {
            this.courseRepository.deleteCourseById(id)
            return ResponseDto<CourseDto?>(
                0,
                "OK",
                this.courseMapper.entityToDto(
                    this.courseRepository.getCourseById(id)!!
                ),
                true
            )
        }
        return ResponseDto<CourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
}