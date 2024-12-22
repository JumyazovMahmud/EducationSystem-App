package uz.itschool.educationsystemapp.db

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.Enrollment
import uz.itschool.educationsystemapp.module.Student

interface EnrollmentRepository {
    @Query("SELECT * FROM enrollment where deleted = false ")
    fun getAllEnrollment(): List<Enrollment?>

    @Insert
    fun addEnrollment(enrollment: Enrollment)

    @Query("UPDATE enrollment SET deleted = true WHERE studentId = :studentId and courseId = :courseId") //DELETE FROM todo_items WHERE id = :id
    fun deleteEnrollmentById(studentId: Int, courseId: Int)

    @Query("SELECT * FROM enrollment WHERE studentId = :studentId and courseId = :courseId")
    fun getEnrollmentById(studentId: Int, courseId: Int): Enrollment?

    @Query("UPDATE enrollment SET enrollment = :enrollment WHERE studentId = :studentId and courseId = :courseId")
    fun updateEnrollment(studentId: Int, courseId: Int, enrollment: String)
}