package uz.itschool.educationsystemapp.mapper.course_features

import uz.itschool.educationsystemapp.dto.course_features.ConversationsDto
import uz.itschool.educationsystemapp.module.course_features.Conversations

class ConversationsMapper {
    fun dtoToEntity(dto:ConversationsDto):Conversations{
        return Conversations(
            dto.courseName,
            dto.description,
            dto.conversation
        )
    }


    fun entityToDto(entity: Conversations):ConversationsDto{
        return ConversationsDto(
            entity.courseName,
            entity.description,
            entity.conversation
        )
    }
}