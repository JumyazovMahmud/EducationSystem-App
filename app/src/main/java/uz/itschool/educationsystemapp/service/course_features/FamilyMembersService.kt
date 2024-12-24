package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import androidx.compose.runtime.traceEventStart
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.dto.course_features.FamilyMembersDto
import uz.itschool.educationsystemapp.mapper.course_features.FamilyMembersMapper
import uz.itschool.educationsystemapp.module.course_features.FamilyMembers
import uz.itschool.educationsystemapp.util.CRUD

class FamilyMembersService(context: Context) : CRUD<FamilyMembersDto, FamilyMembers, Int> {
    private var familyMembersRepository = AppDataBase.getInstance(context).getFamilyMembersRepository()
    private var familyMembersMapper = FamilyMembersMapper()
    override fun create(dto: FamilyMembersDto): ResponseDto<FamilyMembersDto?> {
        if(this.familyMembersMapper.dtoToEntity(dto) in this.familyMembersRepository.getAllFamilyMembers()){
            return ResponseDto<FamilyMembersDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        this.familyMembersRepository.addFamilyMembers(
            this.familyMembersMapper.dtoToEntity(dto)
        )
        return ResponseDto<FamilyMembersDto?>(
                0,
            "OK",
            dto,
            true
                )
    }

    override fun update(dto: FamilyMembersDto, id: Int): ResponseDto<FamilyMembersDto?> {
        if(this.familyMembersRepository.getFamilyMembersById(id) != null){
            this.familyMembersRepository.updateFamilyMembersById(dto.id,dto.courseName,dto.word,dto.example)
            return ResponseDto<FamilyMembersDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<FamilyMembersDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun update(dto: FamilyMembersDto, courseName: String): ResponseDto<FamilyMembersDto?> {
        if (this.familyMembersRepository.getFamilyMembersByName(courseName) != null) {
            this.familyMembersRepository.updateConversationsByCourseName(
                dto.courseName,
                dto.word,
                dto.example
            )
            return ResponseDto<FamilyMembersDto?>(
                0,
                "OK",
                dto,
                true
            )
        }
        return ResponseDto<FamilyMembersDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }


    override fun get(id: Int): ResponseDto<FamilyMembersDto?> {
        if(this.familyMembersRepository.getFamilyMembersById(id) !=null){
            return ResponseDto<FamilyMembersDto?>(
                0,
                "OK",
                this.familyMembersMapper.entityToDto(
                    this.familyMembersRepository.getFamilyMembersById(id)!!),
                true)
        }
        return ResponseDto<FamilyMembersDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun get(courseName: String): ResponseDto<FamilyMembersDto?>{
        if(this.familyMembersRepository.getFamilyMembersByName(courseName) != null){
            return ResponseDto<FamilyMembersDto?>(
                0,
                "OK",
                this.familyMembersMapper.entityToDto(
                    this.familyMembersRepository.getFamilyMembersByName(courseName)!!),
                true)
        }

        return ResponseDto<FamilyMembersDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun delete(id: Int): ResponseDto<FamilyMembersDto?> {
        return ResponseDto<FamilyMembersDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
}