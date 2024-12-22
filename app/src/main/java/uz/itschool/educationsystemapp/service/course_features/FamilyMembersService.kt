package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.dto.course_features.FamilyMembersDto
import uz.itschool.educationsystemapp.module.course_features.FamilyMembers
import uz.itschool.educationsystemapp.util.CRUD

class FamilyMembersService(context: Context) : CRUD<FamilyMembersDto, FamilyMembers, Int> {
    override fun create(dto: FamilyMembersDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: FamilyMembersDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): FamilyMembers? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}