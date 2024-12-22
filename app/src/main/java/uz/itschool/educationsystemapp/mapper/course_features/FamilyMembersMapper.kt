package uz.itschool.educationsystemapp.mapper.course_features

import uz.itschool.educationsystemapp.dto.course_features.FamilyMembersDto
import uz.itschool.educationsystemapp.module.course_features.FamilyMembers

class FamilyMembersMapper {
    fun dtoToEntity(dto: FamilyMembersDto):FamilyMembers{
        return FamilyMembers(
            dto.courseName,
            dto.word,
            dto.definition,
            dto.example
        )
    }
    fun entityToDto(entity: FamilyMembers):FamilyMembersDto{
        return FamilyMembersDto(
            entity.courseName,
            entity.word,
            entity.definition,
            entity.example
        )
    }
}