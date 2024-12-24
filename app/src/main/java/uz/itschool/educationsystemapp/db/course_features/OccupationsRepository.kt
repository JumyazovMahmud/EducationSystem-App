package uz.itschool.educationsystemapp.db.course_features

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.course_features.Foods
import uz.itschool.educationsystemapp.module.course_features.Occupations

interface OccupationsRepository {
    @Query("SELECT * FROM occupations")
    fun getAllOccupations(): List<Occupations?>

    @Insert
    fun addOccupations(occupations: Occupations)

//    @Query("UPDATE basics SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
//    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM occupations WHERE courseName = :name")
    fun getOccupationsByName(name: String): Foods?

    @Query("SELECT * FROM occupations WHERE id=:id")
    fun getOccupationsById(id: Int): Foods?

    @Query("UPDATE occupations SET courseName = :name, word = :word, example = :example WHERE id = :id")
    fun updateOccupationsById(id: Int, name: String, word : String, example: String)

    @Query("UPDATE occupations SET word = :word, example = :example WHERE  courseName = :name")
    fun updateOccupationsByCourseName( name: String, word : String, example: String)
}