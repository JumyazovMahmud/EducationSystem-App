package uz.itschool.educationsystemapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.itschool.educationsystemapp.db.course_features.BasicsRepository
import uz.itschool.educationsystemapp.db.course_features.ConversationsRepository
import uz.itschool.educationsystemapp.db.course_features.FamilyMembersRepository
import uz.itschool.educationsystemapp.db.course_features.FoodsRepository
import uz.itschool.educationsystemapp.db.course_features.OccupationsRepository
import uz.itschool.educationsystemapp.db.course_features.PlacesRepository
import uz.itschool.educationsystemapp.module.Course
import uz.itschool.educationsystemapp.module.Enrollment
import uz.itschool.educationsystemapp.module.Student
import uz.itschool.educationsystemapp.module.TestCourse
import uz.itschool.educationsystemapp.module.course_features.Basics
import uz.itschool.educationsystemapp.module.course_features.Conversations
import uz.itschool.educationsystemapp.module.course_features.FamilyMembers
import uz.itschool.educationsystemapp.module.course_features.Foods
import uz.itschool.educationsystemapp.module.course_features.Occupations
import uz.itschool.educationsystemapp.module.course_features.Places

@Database(entities = [Course::class, Enrollment::class, Student::class, TestCourse::class, Basics::class, Conversations::class, FamilyMembers::class, Foods::class, Occupations::class, Places::class], version = 1)
    abstract class AppDataBase: RoomDatabase() {

        abstract fun getStudentRepository(): StudentRepository
        abstract fun getCourseRepository(): CourseRepository
        abstract fun getEnrollmentRepository(): EnrollmentRepository
        abstract fun getTestCourseRepository(): TestCourseRepository
        abstract fun getBasicsRepository(): BasicsRepository
        abstract fun getConversationsRepository(): ConversationsRepository
        abstract fun getFamilyMembersRepository(): FamilyMembersRepository
        abstract fun getFoodsRepository(): FoodsRepository
        abstract fun getOccupationsRepository():OccupationsRepository
        abstract fun getPlacesRepository():PlacesRepository

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