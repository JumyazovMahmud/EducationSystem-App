package uz.itschool.educationsystemapp.db

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.dto.CourseDto
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.module.Student

interface CourseRepository {
    @Query("SELECT * FROM course where deleted = false ")
    fun getAllToCourses(): List<Course?>

    @Insert
    fun addCourse(course: Course)

    @Query("UPDATE course SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM course WHERE courseId = :id")
    fun getCourseById(id: Int): Course?

    @Query("UPDATE course SET courseName = :name, duration = :duration WHERE courseId = :id")
    fun updateCourse(id: Int, name: String, duration: Int)
}