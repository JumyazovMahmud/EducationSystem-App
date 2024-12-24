package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.mapper.course_features.BasicsMapper
import uz.itschool.educationsystemapp.module.course_features.Basics
import uz.itschool.educationsystemapp.util.CRUD

class BasicsService(context: Context) : CRUD<BasicsDto, Basics, Int>{
    private var basicsRepository = AppDataBase.getInstance(context).getBasicsRepository()
    private var basicsMapper = BasicsMapper()
    override fun create(dto: BasicsDto): ResponseDto<BasicsDto?> {
        if(this.basicsMapper.dtoToEntity(dto) in this.basicsRepository.getAllBasics()){
            return ResponseDto<BasicsDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        this.basicsRepository.addBasics(this.basicsMapper.dtoToEntity(dto))
        return ResponseDto<BasicsDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

    override fun update(dto: BasicsDto, id: Int): ResponseDto<BasicsDto?> {
        if(this.basicsRepository.getBasicsById(id) != null){
            this.basicsRepository.updateBasicsById(dto.id,dto.courseName,dto.topic,dto.info)
            return ResponseDto<BasicsDto?>(
                0,
                "OK",
                dto,
                true)
        }

        return ResponseDto<BasicsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun update(dto: BasicsDto, courseName: String): ResponseDto<BasicsDto?>{
        if(this.basicsRepository.getBasicsByCourseName(courseName) != null){
            this.basicsRepository.updateBasicsByCourseName(dto.courseName,dto.topic,dto.info)
            return ResponseDto<BasicsDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<BasicsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun get(id: Int): ResponseDto<BasicsDto?> {
        if(this.basicsRepository.getBasicsById(id) != null){
            return ResponseDto<BasicsDto?>(
                0,
                "OK",
                this.basicsMapper.entityToDto(
                    this.basicsRepository.getBasicsById(id)!!),
                true)
        }
        return ResponseDto<BasicsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
    fun get(courseName: String): ResponseDto<BasicsDto?>{
        if(this.basicsRepository.getBasicsByCourseName(courseName) != null){
            return ResponseDto<BasicsDto?>(
                0,
                "OK",
                this.basicsMapper.entityToDto(
                    this.basicsRepository.getBasicsByCourseName(courseName)!!),
                true)
        }
        return ResponseDto<BasicsDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun delete(id: Int): ResponseDto<BasicsDto?> {
        return ResponseDto<BasicsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }


}