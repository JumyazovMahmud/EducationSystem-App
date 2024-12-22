package uz.itschool.educationsystemapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("test_course")
class TestCourse(
    @PrimaryKey(autoGenerate = true)
    var testCourseId: Int,
    var courseName: String,
    var topic: String,
    var duration: String,
    var deleted: Boolean = false
)

