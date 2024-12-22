package uz.itschool.educationsystemapp.mapper

import uz.itschool.educationsystemapp.dto.CourseDto
import uz.itschool.educationsystemapp.module.Course

class CourseMapper {
    fun dtoToEntity(dto: CourseDto):Course{
        return Course(
            dto.courseId,
            dto.courseName,
            dto.duration,
            dto.deleted
        )
    }

    fun entityToDto(entity: Course):CourseDto{
        return CourseDto(
            entity.courseId,
            entity.courseName,
            entity.duration,
            entity.deleted
        )
    }
}