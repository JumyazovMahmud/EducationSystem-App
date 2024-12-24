package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.ConversationsDto
import uz.itschool.educationsystemapp.module.course_features.Conversations
import uz.itschool.educationsystemapp.util.CRUD

class ConversationsService(context: Context) : CRUD<ConversationsDto, Conversations, Int> {
    override fun create(dto: ConversationsDto): ResponseDto<ConversationsDto?> {
        TODO("Not yet implemented")
    }

    override fun update(dto: ConversationsDto, id: Int): ResponseDto<ConversationsDto?> {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): ResponseDto<ConversationsDto?> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): ResponseDto<ConversationsDto?> {
        TODO("Not yet implemented")
    }
}