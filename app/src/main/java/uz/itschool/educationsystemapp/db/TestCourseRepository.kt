package uz.itschool.educationsystemapp.db

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.TestCourse

interface TestCourseRepository {
    @Query("SELECT * FROM test_course where deleted = false ")
    fun getAllTestCourse(): List<TestCourse?>

    @Insert
    fun addTestCourse(testCourse: TestCourse)

    @Query("UPDATE test_course SET deleted = true WHERE testCourseId = :id") //DELETE FROM todo_items WHERE id = :id
    fun deleteTestCourseById(id: Int)

    @Query("UPDATE test_course SET deleted = true WHERE courseName = :courseName") //DELETE FROM todo_items WHERE id = :id
    fun deleteTestCourseByCourseName(courseName: String)

    @Query("SELECT * FROM test_course WHERE testCourseId = :id")
    fun getTestCourseById(id: Int): TestCourse?

    @Query("SELECT * FROM test_course WHERE courseName = :courseName")
    fun getTestCourseByCourseName(courseName: String): TestCourse?

    @Query("UPDATE test_course SET courseName = :courseName, topic = :topic, duration = :duration WHERE testCourseId = :id")
    fun updateTestCourseById(id: Int, courseName: String, topic: String, duration : Int)

    @Query("UPDATE test_course SET topic = :topic, duration = :duration WHERE courseName = :courseName")
    fun updateTestCourseByCourseName(courseName: String, topic: String, duration : Int)
}