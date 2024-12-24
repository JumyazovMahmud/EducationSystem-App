package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.EnrollmentDto
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.mapper.EnrollmentMapper


class EnrollmentService(context: Context)  {
    private var enrollmentRepository = AppDataBase.getInstance(context).getEnrollmentRepository()
    private var enrollmentMapper = EnrollmentMapper()
     fun create(dto: EnrollmentDto): ResponseDto<EnrollmentDto?> {
        if(this.enrollmentMapper.dtoToEntity(dto) in this.enrollmentRepository.getAllEnrollment()){
            return ResponseDto<EnrollmentDto?>(
                -1,
                "It already exists",
                null,
                false
            )
        }
        this.enrollmentRepository.addEnrollment(
            this.enrollmentMapper.dtoToEntity(dto)
        )
        return ResponseDto<EnrollmentDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

     fun update(dto: EnrollmentDto, studentId: Int, courseId: Int): ResponseDto<EnrollmentDto?> {
        if(this.enrollmentRepository.getEnrollmentById(studentId, courseId) != null){
            this.enrollmentRepository.updateEnrollment(dto.courseId,dto.studentId,dto.enrollment)
            return ResponseDto<EnrollmentDto?>(
                0,
                "OK",
                dto,
                true
            )
        }
         return ResponseDto<EnrollmentDto?>(
             -1,
             "Not Found",
             null,
             false
         )
    }

     fun get(studentId: Int, courseId: Int): ResponseDto<EnrollmentDto?> {
        if(this.enrollmentRepository.getEnrollmentById(studentId, courseId) != null){
            return ResponseDto<EnrollmentDto?>(
                0,
                "OK",
                this.enrollmentMapper.entityToDto(
                    this.enrollmentRepository.getEnrollmentById(studentId, courseId)!!
                ),
                true
            )
        }

         return ResponseDto<EnrollmentDto?>(
             -1,
             "Not Found",
             null,
             false
         )
    }

     fun delete(studentId: Int, courseId: Int): ResponseDto<EnrollmentDto?> {
         if(this.enrollmentRepository.getEnrollmentById(studentId, courseId) != null){
             this.enrollmentRepository.deleteEnrollmentById(studentId, courseId)
             return ResponseDto<EnrollmentDto?>(
                 0,
                 "OK",
                 this.enrollmentMapper.entityToDto(
                     this.enrollmentRepository.getEnrollmentById(studentId, courseId)!!
                 ),
                 true
             )
         }
         return ResponseDto<EnrollmentDto?>(
             -1,
             "Not Found",
             null,
             false
         )
    }

}