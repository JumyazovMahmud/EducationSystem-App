package uz.itschool.educationsystemapp.util

interface RepositoryCRUD<E,I> {
    //E - entity
    //I - integer

    fun create(entity: E)


}