package uz.itschool.educationsystemapp.mapper

import androidx.room.Entity
import uz.itschool.educationsystemapp.dto.TestCourseDto
import uz.itschool.educationsystemapp.module.TestCourse

class TestCourseMapper {
    fun dtoToEntity(dto: TestCourseDto):TestCourse{
        return TestCourse(
            dto.testCourseId,
            dto.courseName,
            dto.topic,
            dto.duration,
            dto.deleted
        )
    }

    fun entityToDto(entity: TestCourse):TestCourseDto{
        return TestCourseDto(
            entity.testCourseId,
            entity.courseName,
            entity.topic,
            entity.duration,
            entity.deleted
        )
    }
}