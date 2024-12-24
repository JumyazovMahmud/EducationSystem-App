package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.dto.course_features.PlacesDto
import uz.itschool.educationsystemapp.mapper.course_features.PlacesMapper
import uz.itschool.educationsystemapp.module.course_features.Places
import uz.itschool.educationsystemapp.util.CRUD

class PlacesService(context: Context):CRUD<PlacesDto, Places, Int> {
    private var placesRepository = AppDataBase.getInstance(context).getPlacesRepository()
    private var placesMapper = PlacesMapper()
    override fun create(dto: PlacesDto): ResponseDto<PlacesDto?> {
        if(this.placesMapper.dtoToEntity(dto) in this.placesRepository.getAllPlaces()){
            return ResponseDto<PlacesDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        this.placesRepository.addPlaces(
            this.placesMapper.dtoToEntity(dto)
        )
        return ResponseDto<PlacesDto?>(
            0,
            "OK",
            dto,
            true)
    }

    override fun update(dto: PlacesDto, id: Int): ResponseDto<PlacesDto?> {
        if(this.placesRepository.getPlacesById(id) != null){
            this.placesRepository.updatePlacesById(dto.id,dto.courseName,dto.word,dto.example)
            return ResponseDto<PlacesDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<PlacesDto?>(
            -1,
            "Not Found",
            null,
            false)
    }
    fun update(dto: PlacesDto, courseName: String): ResponseDto<PlacesDto?> {
        if(this.placesRepository.getPlacesByName(courseName) != null){
            this.placesRepository.updatePlacesByCourseName(dto.courseName,dto.word,dto.example)
            return ResponseDto<PlacesDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<PlacesDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun get(id: Int): ResponseDto<PlacesDto?>  {
        if(this.placesRepository.getPlacesById(id) != null){
            return ResponseDto<PlacesDto?>(
                0,
                "OK",
                this.placesMapper.entityToDto(
                    this.placesRepository.getPlacesById(id)!!),
                true)
        }
        return ResponseDto<PlacesDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    fun get(courseName: String): ResponseDto<PlacesDto?>{
        if(this.placesRepository.getPlacesByName(courseName) != null){
            return ResponseDto<PlacesDto?>(
                0,
                "OK",
                this.placesMapper.entityToDto(
                    this.placesRepository.getPlacesByName(courseName)!!),
                true)
        }
        return ResponseDto<PlacesDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun delete(id: Int): ResponseDto<PlacesDto?> {
        return ResponseDto<PlacesDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
}