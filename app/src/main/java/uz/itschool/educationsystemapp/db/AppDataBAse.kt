package uz.itschool.educationsystemapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.module.Enrollment
import uz.itschool.educationsystemapp.module.Student
import uz.itschool.educationsystemapp.module.TestCourse


@Database(entities = [Course::class, Enrollment::class, Student::class, TestCourse::class], version = 1, exportSchema = false)
    abstract class AppDataBase: RoomDatabase() {

        abstract fun getStudentRepository(): StudentRepository
        abstract fun getCourseRepository(): CourseRepository
        abstract fun getEnrollmentRepository(): EnrollmentRepository
        abstract fun getTestCourseRepository(): TestCourseRepository


        companion object{
            const val DB_NAME = "education_system"
            var instance: AppDataBase? = null

            fun getInstance(context: Context): AppDataBase {
                if (instance == null){
                    instance = Room.databaseBuilder(context,
                        AppDataBase::class.java, DB_NAME
                    )
                        .allowMainThreadQueries()
                        .build();

                }
                return instance!!

            }
        }



    //Room.databaseBuilder(context, RepoDatabase.class, DB_NAME)
    //  .addMigrations(FROM_1_TO_2)
    //.build();
    //



    }

