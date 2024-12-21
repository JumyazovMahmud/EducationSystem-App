package uz.itschool.educationsystemapp.module

import androidx.room.Entity

@Entity("enrollment")
class Enrollment (
    var studentId: Int,
    var courseId: Int,
    var enrollment: String,
    var deleted : Boolean = false
)