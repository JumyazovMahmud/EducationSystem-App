package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.EnrollmentDto
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.module.Enrollment
import uz.itschool.educationsystemapp.util.CRUD

class EnrollmentService(context: Context) : CRUD<EnrollmentDto, Enrollment, Int> {
    private var enrollmentRepository = AppDataBase.getInstance(context)
    override fun create(dto: EnrollmentDto): ResponseDto<EnrollmentDto?> {
        TODO("Not yet implemented")
    }

    override fun update(dto: EnrollmentDto, id: Int): ResponseDto<EnrollmentDto?> {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): ResponseDto<EnrollmentDto?> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): ResponseDto<EnrollmentDto?> {
        TODO("Not yet implemented")
    }

}