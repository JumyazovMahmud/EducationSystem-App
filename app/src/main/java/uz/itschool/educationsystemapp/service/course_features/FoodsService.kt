package uz.itschool.educationsystemapp.service.course_features

import android.content.Context
import androidx.compose.runtime.traceEventEnd
import uz.itschool.educationsystemapp.db.AppDataBase
import uz.itschool.educationsystemapp.dto.ResponseDto
import uz.itschool.educationsystemapp.dto.course_features.BasicsDto
import uz.itschool.educationsystemapp.dto.course_features.FoodsDto
import uz.itschool.educationsystemapp.mapper.course_features.FoodsMapper
import uz.itschool.educationsystemapp.module.course_features.Foods
import uz.itschool.educationsystemapp.util.CRUD

class FoodsService(context: Context) : CRUD<FoodsDto, Foods, Int> {
    private var foodsRepository = AppDataBase.getInstance(context).getFoodsRepository()
    private var foodsMapper = FoodsMapper()
    override fun create(dto: FoodsDto): ResponseDto<FoodsDto?> {
        if(this.foodsMapper.dtoToEntity(dto) in this.foodsRepository.getAllFoods()){
            return ResponseDto<FoodsDto?>(
                -1,
                "It already exists",
                null,
                false)
        }
        this.foodsRepository.addFoods(
            this.foodsMapper.dtoToEntity(dto)
        )
        return ResponseDto<FoodsDto?>(
            0,
            "OK",
            dto,
            true
        )
    }

    override fun update(dto: FoodsDto, id: Int): ResponseDto<FoodsDto?> {
        if(this.foodsRepository.getFoodsById(id) != null){
            this.foodsRepository.updateFoodsById(dto.id,dto.courseName,dto.word,dto.example)
            return ResponseDto<FoodsDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<FoodsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    fun update(dto: FoodsDto, courseName: String): ResponseDto<FoodsDto?> {
        if(this.foodsRepository.getFoodsByName(courseName) != null){
            this.foodsRepository.updateFoodsByCourseName(dto.courseName,dto.word,dto.example)
            return ResponseDto<FoodsDto?>(
                0,
                "OK",
                dto,
                true)
        }
        return ResponseDto<FoodsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }

    override fun get(id: Int): ResponseDto<FoodsDto?> {
        if(this.foodsRepository.getFoodsById(id) != null){
            return ResponseDto<FoodsDto?>(
                0,
                "OK",
                this.foodsMapper.entityToDto(
                    this.foodsRepository.getFoodsById(id)!!),
                true
            )
        }
        return ResponseDto<FoodsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
    fun get(courseName: String): ResponseDto<FoodsDto?>{
        if(this.foodsRepository.getFoodsByName(courseName) != null){
            return ResponseDto<FoodsDto?>(
                0,
                "OK",
                this.foodsMapper.entityToDto(
                    this.foodsRepository.getFoodsByName(courseName)!!),
                true)
        }
        return ResponseDto<FoodsDto?>(
            -1,
            "Not Found",
            null,
            false)
    }

    override fun delete(id: Int): ResponseDto<FoodsDto?> {
        return ResponseDto<FoodsDto?>(
            -1,
            "Not Found",
            null,
            false
        )
    }
}