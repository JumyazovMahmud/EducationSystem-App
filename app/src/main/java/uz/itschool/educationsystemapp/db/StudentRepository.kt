package uz.itschool.educationsystemapp.db

import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.Student

interface StudentRepository {
    @Query("SELECT * FROM student where deleted = false ")
    fun getAllStudents(): List<Student?>

    @Insert
    fun addStudent(student: Student)

    @Query("UPDATE student SET deleted = true WHERE studentId = :id") //DELETE FROM todo_items WHERE id = :id
    fun deleteStudentById(id: Int)

    @Query("SELECT * FROM student WHERE studentId = :id")
    fun getStudentById(id: Int): Student?

    @Query("UPDATE student SET name = :name, email = :email, phone = :phone, username = :username, password = :password WHERE studentId = :id")
    fun updateStudent(id: Int, name: String, email: String, phone: String, username: String, password: String)
}