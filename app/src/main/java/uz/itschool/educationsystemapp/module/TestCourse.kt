package uz.itschool.educationsystemapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("test_course")
class TestCourse(
    var courseName: String,
    var topic: String,
    var duration: String
)

