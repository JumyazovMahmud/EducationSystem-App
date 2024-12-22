package uz.itschool.educationsystemapp.mapper

import uz.itschool.educationsystemapp.dto.EnrollmentDto
import uz.itschool.educationsystemapp.module.Enrollment

class EnrollmentMapper {
    fun dtoToEntity(dto: EnrollmentDto):Enrollment{
        return Enrollment(
            dto.studentId,
            dto.courseId,
            dto.enrollment,
            dto.deleted
        )
    }

    fun entityToDto(entity: Enrollment):EnrollmentDto{
        return EnrollmentDto(
            entity.studentId,
            entity.courseId,
            entity.enrollment,
            entity.deleted
        )
    }
}