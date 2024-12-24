package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import androidx.compose.runtime.traceEventEnd
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.dto.course_features.ConversationsDto
import uz.itschool.educationsystemapp.mapper.course_features.ConversationsMapper
import uz.itschool.educationsystemapp.module.course_features.Conversations
import uz.itschool.educationsystemapp.util.CRUD

class ConversationsService(context: Context) : CRUD<ConversationsDto, Conversations, Int> {
    private var conversationsRepository = AppDataBase.getInstance(context).getConversationsRepository()
    private var conversationsMapper = ConversationsMapper()
    override fun create(dto: ConversationsDto): ResponseDto<ConversationsDto?> {
        if(this.conversationsMapper.dtoToEntity(dto) in this.conversationsRepository.getAllConversations()){
            return ResponseDto<ConversationsDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        this.conversationsRepository.addConversations(
            this.conversationsMapper.dtoToEntity(dto)
        )
        return ResponseDto<ConversationsDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

    override fun update(dto: ConversationsDto, id: Int): ResponseDto<ConversationsDto?> {
        if(this.conversationsRepository.getConversationsById(id) != null){
            this.conversationsRepository.updateConversationsById(dto.id,dto.courseName,dto.description,dto.conversation)
            return ResponseDto<ConversationsDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<ConversationsDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    fun update(dto: ConversationsDto, courseName: String): ResponseDto<ConversationsDto?>{
        if (this.conversationsRepository.getConversationsByName(courseName) != null){
            this.conversationsRepository.updateConversationsByCourseName(dto.id,dto.courseName,dto.description,dto.conversation)
            return ResponseDto<ConversationsDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<ConversationsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun get(id: Int): ResponseDto<ConversationsDto?> {
        if(this.conversationsRepository.getConversationsById(id) != null){
            return ResponseDto<ConversationsDto?>(
                0,
                "OK",
                this.conversationsMapper.entityToDto(
                    this.conversationsRepository.getConversationsById(id)!!),
                true)
        }
        return ResponseDto<ConversationsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun get(courseName: String): ResponseDto<ConversationsDto?>{
        if(this.conversationsRepository.getConversationsByName(courseName) != null){
            return ResponseDto<ConversationsDto?>(
                0,
                "OK",
                this.conversationsMapper.entityToDto(
                    this.conversationsRepository.getConversationsByName(courseName)!!),
                true)
        }
        return ResponseDto<ConversationsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun delete(id: Int): ResponseDto<ConversationsDto?> {
        return ResponseDto<ConversationsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
}