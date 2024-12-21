package uz.itschool.educationsystemapp.dto

class StudentsDto (
    var studentId: Int,
    var name: String,
    var email: String,
    var username :String,
    var password: String,
    var phone: String,
    var deleted : Boolean = false
)