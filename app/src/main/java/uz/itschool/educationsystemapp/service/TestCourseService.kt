package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.dto.TestCourseDto
import uz.itschool.educationsystemapp.module.TestCourse
import uz.itschool.educationsystemapp.util.CRUD

class TestCourseService(context: Context) : CRUD<TestCourseDto, TestCourse, Int>{
    override fun create(dto: TestCourseDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: TestCourseDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): TestCourse? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}