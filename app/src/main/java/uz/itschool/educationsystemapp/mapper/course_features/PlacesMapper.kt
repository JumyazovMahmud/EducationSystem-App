package uz.itschool.educationsystemapp.mapper.course_features

import uz.itschool.educationsystemapp.dto.course_features.PlacesDto
import uz.itschool.educationsystemapp.module.course_features.Places

class PlacesMapper {
    fun dtoToEntity(dto:PlacesDto):Places{
        return Places(
            dto.id,
            dto.courseName,
            dto.word,
            dto.definition,
            dto.example
        )
    }

    fun entityToDto(entity: Places):PlacesDto{
        return PlacesDto(
            entity.id,
            entity.courseName,
            entity.word,
            entity.definition,
            entity.example
        )
    }
}