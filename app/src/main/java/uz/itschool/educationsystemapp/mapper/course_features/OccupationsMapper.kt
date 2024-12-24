package uz.itschool.educationsystemapp.mapper.course_features

import uz.itschool.educationsystemapp.dto.course_features.OccupationsDto
import uz.itschool.educationsystemapp.module.course_features.Occupations

class OccupationsMapper {
    fun dtoToEntity(dto: OccupationsDto):Occupations{
        return Occupations(
            dto.id,
            dto.courseName,
            dto.word,
            dto.definition,
            dto.example
        )
    }

    fun entityToDto(entity: Occupations):OccupationsDto{
        return OccupationsDto(
            entity.id,
            entity.courseName,
            entity.word,
            entity.definition,
            entity.example
        )
    }
}