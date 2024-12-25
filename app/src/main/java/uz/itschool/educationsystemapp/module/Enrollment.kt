package uz.itschool.educationsystemapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("enrollment")
class Enrollment (
    @PrimaryKey(autoGenerate = true)
    var enrollmentId: Int,
    var studentId: Int,
    var courseId: Int,
    var enrollment: String,
    var deleted : Boolean = false
)