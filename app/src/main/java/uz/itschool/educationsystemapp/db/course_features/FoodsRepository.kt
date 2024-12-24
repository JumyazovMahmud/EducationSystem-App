package uz.itschool.educationsystemapp.db.course_features

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.course_features.FamilyMembers
import uz.itschool.educationsystemapp.module.course_features.Foods

interface FoodsRepository {
    @Query("SELECT * FROM foods")
    fun getAllFoods(): List<Foods?>

    @Insert
    fun addFoods(foods: Foods)

//    @Query("UPDATE basics SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
//    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM foods WHERE courseName = :name")
    fun getFoodsByName(name: String): Foods?

    @Query("SELECT * FROM foods WHERE id=:id")
    fun getFoodsById(id: Int): Foods?

    @Query("UPDATE foods SET courseName = :name, word = :word, example = :example WHERE id = :id")
    fun updateFoodsById(id: Int, name: String, word : String, example: String)

    @Query("UPDATE foods SET word = :word, example = :example WHERE  courseName = :name")
    fun updateFoodsByCourseName( name: String, word : String, example: String)
}