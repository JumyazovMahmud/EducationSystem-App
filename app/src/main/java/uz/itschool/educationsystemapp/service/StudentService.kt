package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.dto.StudentsDto
import uz.itschool.educationsystemapp.module.Student
import uz.itschool.educationsystemapp.util.CRUD

class StudentService(context: Context) : CRUD<StudentsDto, Student, Int> {
    override fun create(dto: StudentsDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: StudentsDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Student? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

}