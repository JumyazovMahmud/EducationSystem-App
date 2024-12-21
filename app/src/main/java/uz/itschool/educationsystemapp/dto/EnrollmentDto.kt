package uz.itschool.educationsystemapp.dto

class EnrollmentDto (
    var studentId: Int,
    var courseId: Int,
    var enrollment: String,
    var deleted : Boolean = false
)