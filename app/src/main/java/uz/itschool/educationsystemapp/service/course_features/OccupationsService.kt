package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.dto.course_features.OccupationsDto
import uz.itschool.educationsystemapp.module.course_features.Occupations
import uz.itschool.educationsystemapp.util.CRUD

class OccupationsService(context: Context) : CRUD<OccupationsDto, Occupations, Int> {
    override fun create(dto: OccupationsDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: OccupationsDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Occupations? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}