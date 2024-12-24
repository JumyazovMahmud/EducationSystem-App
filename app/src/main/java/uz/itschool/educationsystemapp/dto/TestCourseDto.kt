package uz.itschool.educationsystemapp.dto

class TestCourseDto (
    var testCourseId: Int,
    var courseName: String,
    var topic: String,
    var duration: Int,
    var deleted: Boolean = false
)