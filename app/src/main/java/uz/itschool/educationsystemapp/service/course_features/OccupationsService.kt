package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.OccupationsDto
import uz.itschool.educationsystemapp.mapper.course_features.OccupationsMapper
import uz.itschool.educationsystemapp.module.course_features.Occupations
import uz.itschool.educationsystemapp.util.CRUD

class OccupationsService(context: Context) : CRUD<OccupationsDto, Occupations, Int> {
    private var occupationsRepository = AppDataBase.getInstance(context).getOccupationsRepository()
    private var occupationsMapper = OccupationsMapper()
    override fun create(dto: OccupationsDto): ResponseDto<OccupationsDto?> {
        if(this.occupationsMapper.dtoToEntity(dto) in this.occupationsRepository.getAllOccupations()){
            return ResponseDto<OccupationsDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        this.occupationsRepository.addOccupations(
            this.occupationsMapper.dtoToEntity(dto)
        )
        return ResponseDto<OccupationsDto?>(
            0,
            "OK",
            dto,
            true)
    }

    override fun update(dto: OccupationsDto, id: Int): ResponseDto<OccupationsDto?> {
        if(this.occupationsRepository.getOccupationsById(id) != null){
            this.occupationsRepository.updateOccupationsById(dto.id,dto.courseName,dto.word,dto.example)
            return ResponseDto<OccupationsDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<OccupationsDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    fun update(dto: OccupationsDto, courseName: String): ResponseDto<OccupationsDto?> {
        if(this.occupationsRepository.getOccupationsByName(courseName) != null) {
            this.occupationsRepository.updateOccupationsByCourseName(
                dto.courseName,
                dto.word,
                dto.example
            )
            return ResponseDto<OccupationsDto?>(
                0,
                "OK",
                dto,
                true
            )
        }
        return ResponseDto<OccupationsDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun get(id: Int): ResponseDto<OccupationsDto?> {
        if(this.occupationsRepository.getOccupationsById(id) != null){
            return ResponseDto<OccupationsDto?>(
                0,
                "OK",
                this.occupationsMapper.entityToDto(
                    this.occupationsRepository.getOccupationsById(id)!!),
                true)
        }
        return ResponseDto<OccupationsDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun delete(id: Int): ResponseDto<OccupationsDto?> {
        return ResponseDto<OccupationsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
}