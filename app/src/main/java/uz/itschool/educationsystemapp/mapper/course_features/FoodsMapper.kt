package uz.itschool.educationsystemapp.mapper.course_features

import uz.itschool.educationsystemapp.dto.course_features.FoodsDto
import uz.itschool.educationsystemapp.module.course_features.Foods

class FoodsMapper {
    fun dtoToEntity(dto: FoodsDto): Foods {
        return Foods(
            dto.courseName,
            dto.word,
            dto.definition,
            dto.example
        )
    }

    fun entityToDto(entity: Foods):FoodsDto{
        return FoodsDto(
            entity.courseName,
            entity.word,
            entity.definition,
            entity.example
        )
    }
}