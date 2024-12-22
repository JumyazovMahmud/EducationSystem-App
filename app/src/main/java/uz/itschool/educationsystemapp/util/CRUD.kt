package uz.itschool.educationsystemapp.util

interface CRUD<T,K, I> {
    //T - dto
    //K - entity
    //I - integer

    fun create(dto: T): Boolean

    fun update(dto:T, id: I):Boolean

    fun get(id:I):K?

    fun delete(id: I): Boolean
}