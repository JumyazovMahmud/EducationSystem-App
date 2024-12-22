package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import uz.itschool.educationsystemapp.dto.course_features.FoodsDto
import uz.itschool.educationsystemapp.module.course_features.Foods
import uz.itschool.educationsystemapp.util.CRUD

class FoodsService(context: Context) : CRUD<FoodsDto, Foods, Int> {
    override fun create(dto: FoodsDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(dto: FoodsDto, id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(id: Int): Foods? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}