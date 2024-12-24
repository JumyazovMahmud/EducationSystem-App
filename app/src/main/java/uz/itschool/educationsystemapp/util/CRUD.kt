package uz.itschool.educationsystemapp.util

import uz.itschool.educationsystemapp.dto.ResponseDto

interface CRUD<T,K, I> {
    //T - dto
    //K - entity
    //I - integer

    fun create(dto: T): ResponseDto<T?>

    fun update(dto:T, id: I):ResponseDto<T?>

    fun get(id:I):ResponseDto<T?>

    fun delete(id: I): ResponseDto<T?>
}