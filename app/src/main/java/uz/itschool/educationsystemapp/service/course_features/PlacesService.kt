package uz.itschool.educationsystemapp.service.course_features

import uz.itschool.educationsystemapp.dto.course_features.PlacesDto
import uz.itschool.educationsystemapp.module.course_features.Places
import uz.itschool.educationsystemapp.util.CRUD

class PlacesService:CRUD<PlacesDto, Places, Int> {
    override fun create(dto: PlacesDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: PlacesDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Places? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}