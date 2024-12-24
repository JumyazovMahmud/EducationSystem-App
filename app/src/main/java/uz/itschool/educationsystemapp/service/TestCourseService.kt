package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.TestCourseDto
import uz.itschool.educationsystemapp.mapper.TestCourseMapper
import uz.itschool.educationsystemapp.module.TestCourse
import uz.itschool.educationsystemapp.util.CRUD

class TestCourseService(context: Context) : CRUD<TestCourseDto, TestCourse, Int>{
    private var testCourseRepository = AppDataBase.getInstance(context).getTestCourseRepository()
    private var testCourseMapper = TestCourseMapper()
    override fun create(dto: TestCourseDto): ResponseDto<TestCourseDto?> {
        if(this.testCourseMapper.dtoToEntity(dto) in this.testCourseRepository.getAllTestCourse()){
            return ResponseDto<TestCourseDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        return ResponseDto<TestCourseDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

    override fun update(dto: TestCourseDto, id: Int): ResponseDto<TestCourseDto?> {
        if(this.testCourseRepository.getTestCourseById(id) != null){
            this.testCourseRepository.updateTestCourseById(dto.testCourseId,dto.courseName, dto.topic, dto.duration)
            return ResponseDto<TestCourseDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<TestCourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
    fun update(dto: TestCourseDto, courseName: String): ResponseDto<TestCourseDto?> {
        if(this.testCourseRepository.getTestCourseByCourseName(courseName) != null){
            this.testCourseRepository.updateTestCourseByCourseName(dto.courseName, dto.topic, dto.duration)
            return ResponseDto<TestCourseDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<TestCourseDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun get(id: Int): ResponseDto<TestCourseDto?> {
       if(this.testCourseRepository.getTestCourseById(id) != null){
           return ResponseDto<TestCourseDto?>(
               0,
               "OK",
               this.testCourseMapper.entityToDto(
                   this.testCourseRepository.getTestCourseById(id)!!
               ),
               true
           )
       }
        return ResponseDto<TestCourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun get(courseName: String): ResponseDto<TestCourseDto?> {
        if(this.testCourseRepository.getTestCourseByCourseName(courseName) != null) {
            return ResponseDto<TestCourseDto?>(
                0,
                "OK",
                this.testCourseMapper.entityToDto(
                    this.testCourseRepository.getTestCourseByCourseName(courseName)!!
                ),
                true
            )
        }
        return ResponseDto<TestCourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )

    }

    override fun delete(id: Int): ResponseDto<TestCourseDto?> {
        if(this.testCourseRepository.getTestCourseById(id) != null){
            this.testCourseRepository.deleteTestCourseById(id)
            return ResponseDto<TestCourseDto?>(
                0,
                "OK",
                this.testCourseMapper.entityToDto(
                    this.testCourseRepository.getTestCourseById(id)!!
                ),
                true
            )
        }
        return ResponseDto<TestCourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun delete(courseName: String): ResponseDto<TestCourseDto?> {
        if (this.testCourseRepository.getTestCourseByCourseName(courseName) != null) {
            this.testCourseRepository.deleteTestCourseByCourseName(courseName)
            return ResponseDto<TestCourseDto?>(
                0,
                "OK",
                this.testCourseMapper.entityToDto(
                    this.testCourseRepository.getTestCourseByCourseName(courseName)!!
                ),
                true
            )
        }

        return ResponseDto<TestCourseDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

}