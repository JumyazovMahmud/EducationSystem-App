package uz.itschool.educationsystemapp.service

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.StudentsDto
import uz.itschool.educationsystemapp.mapper.StudentMapper
import uz.itschool.educationsystemapp.module.Student
import uz.itschool.educationsystemapp.util.CRUD

class StudentService(context: Context) : CRUD<StudentsDto, Student, Int> {
    private var studentRepository = AppDataBase.getInstance(context).getStudentRepository()
    private var studentMapper = StudentMapper()
    override fun create(dto: StudentsDto): ResponseDto<StudentsDto?> {
        if(this.studentMapper.dtoToEntity(dto) in this.studentRepository.getAllStudents()){
            return ResponseDto<StudentsDto?>(
                -1,
                "It already exists",
                null,
                false
            )
        }
        this.studentRepository.addStudent(
            this.studentMapper.dtoToEntity(dto)
        )
        return ResponseDto<StudentsDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

    override fun update(dto: StudentsDto, id: Int): ResponseDto<StudentsDto?> {
        if(this.studentRepository.getStudentById(id) != null){
            this.studentRepository.updateStudent(dto.studentId, dto.name, dto.email, dto.phone, dto.username, dto.password)
            return ResponseDto<StudentsDto?>(
                0,
                "OK",
                dto,
                true
            )
        }
        return ResponseDto<StudentsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun get(id: Int): ResponseDto<StudentsDto?> {
        if(this.studentRepository.getStudentById(id) != null){
            return ResponseDto<StudentsDto?>(
                0,
                "OK",
                this.studentMapper.entityToDto(
                    this.studentRepository.getStudentById(id)!!),
                true
            )
        }
        return ResponseDto<StudentsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun delete(id: Int): ResponseDto<StudentsDto?> {
        if(this.studentRepository.getStudentById(id) != null){
            this.studentRepository.deleteStudentById(id)
            return ResponseDto<StudentsDto?>(
                0,
                "OK",
                this.studentMapper.entityToDto(
                    this.studentRepository.getStudentById(id)!!
                ),
                true)

        }
        return ResponseDto<StudentsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

}