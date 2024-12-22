package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.dto.EnrollmentDto
import uz.itschool.educationsystemapp.module.Enrollment
import uz.itschool.educationsystemapp.util.CRUD

class EnrollmentService(context: Context) : CRUD<EnrollmentDto, Enrollment, Int> {
    override fun create(dto: EnrollmentDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: EnrollmentDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Enrollment? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}