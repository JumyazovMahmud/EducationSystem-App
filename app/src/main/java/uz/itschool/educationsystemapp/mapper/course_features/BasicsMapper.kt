package uz.itschool.educationsystemapp.mapper.course_features

import androidx.compose.foundation.BasicTooltipState
import androidx.compose.foundation.text.BasicSecureTextField
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.module.course_features.Basics

class BasicsMapper {
    fun dtoToEntity(dto:BasicsDto):Basics{
        return Basics(
            dto.id,
            dto.courseName,
            dto.topic,
            dto.info
        )
    }

    fun entityToDto(entity: Basics):BasicsDto{
        return BasicsDto(
            entity.id,
            entity.courseName,
            entity.topic,
            entity.info
        )
    }
}