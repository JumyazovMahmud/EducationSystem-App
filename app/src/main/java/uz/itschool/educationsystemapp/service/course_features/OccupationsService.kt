package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.dto.course_features.FoodsDto
import uz.itschool.educationsystemapp.dto.course_features.OccupationsDto
import uz.itschool.educationsystemapp.module.course_features.Occupations
import uz.itschool.educationsystemapp.util.CRUD

class OccupationsService(context: Context) : CRUD<OccupationsDto, Occupations, Int> {
    override fun create(dto: OccupationsDto): ResponseDto<OccupationsDto?> {
        TODO("Not yet implemented")
    }

    override fun update(dto: OccupationsDto, id: Int): ResponseDto<OccupationsDto?> {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): ResponseDto<OccupationsDto?> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): ResponseDto<OccupationsDto?> {
        TODO("Not yet implemented")
    }
}