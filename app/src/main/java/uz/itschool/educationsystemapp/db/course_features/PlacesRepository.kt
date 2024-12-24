package uz.itschool.educationsystemapp.db.course_features

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.course_features.Foods
import uz.itschool.educationsystemapp.module.course_features.Occupations
import uz.itschool.educationsystemapp.module.course_features.Places

interface PlacesRepository {
    @Query("SELECT * FROM places")
    fun getAllPlaces(): List<Places?>

    @Insert
    fun addPlaces(places: Places)

//    @Query("UPDATE basics SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
//    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM places WHERE courseName = :name")
    fun getPlacesByName(name: String): Places?

    @Query("SELECT * FROM places WHERE id=:id")
    fun getPlacesById(id: Int): Places?

    @Query("UPDATE places SET courseName = :name, word = :word, example = :example WHERE id = :id")
    fun updatePlacesById(id: Int, name: String, word : String, example: String)

    @Query("UPDATE occupations SET word = :word, example = :example WHERE  courseName = :name")
    fun updatePlacesByCourseName( name: String, word : String, example: String)
}