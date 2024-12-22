package uz.itschool.educationsystemapp.mapper

import uz.itschool.educationsystemapp.dto.StudentsDto
import uz.itschool.educationsystemapp.module.Student

class StudentMapper {
    fun dtoToEntity(dto: StudentsDto):Student{
        return Student(
            dto.studentId,
            dto.name,
            dto.email,
            dto.username,
            dto.password,
            dto.phone,
            dto.deleted
        )
    }

    fun entityToDto(entity: Student):StudentsDto{
        return StudentsDto(
            entity.studentId,
            entity.name,
            entity.email,
            entity.username,
            entity.password,
            entity.phone,
            entity.deleted
        )
    }
}