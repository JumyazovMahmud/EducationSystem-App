package uz.itschool.educationsystemapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.module.Enrollment
import uz.itschool.educationsystemapp.module.Student

@Database(entities = [Course::class, Enrollment::class, Student::class], version = 1)
    abstract class AppDataBase: RoomDatabase() {

        abstract fun getStudentRepository(): StudentRepository
        abstract fun getCourseRepository(): CourseRepository
//        abstract fun getEnrollmentRepository():

        companion object{
            const val DB_NAME = "education_system"
            var instance: AppDataBase? = null

            fun getInstance(context: Context): AppDataBase {
                if (instance == null){
                    instance = Room.databaseBuilder(context,
                        AppDataBase::class.java, DB_NAME
                    )
                        .allowMainThreadQueries()
                        .build()
                }
                return instance!!

            }
        }



    }