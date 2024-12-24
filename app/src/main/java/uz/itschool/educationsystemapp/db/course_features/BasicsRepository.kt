package uz.itschool.educationsystemapp.db.course_features

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.course_features.Basics

interface BasicsRepository {
    @Query("SELECT * FROM basics")
    fun getAllBasics(): List<Basics?>

    @Insert
    fun addBasics(basics: Basics)

//    @Query("UPDATE basics SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
//    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM basics WHERE courseName = :name")
    fun getBasicsByCourseName(name: String): Basics?

    @Query("SELECT * FROM basics WHERE id =:id")
    fun getBasicsById(id:Int): Basics?

    @Query("UPDATE basics SET courseName = :name, topic = :topic, info = :info WHERE id = :id")
    fun updateBasicsById(id: Int, name: String, topic : String, info: String)

    @Query("UPDATE basics SET topic = :topic, info = :info WHERE courseName = :name")
    fun updateBasicsByCourseName(name: String, topic : String, info: String)
}