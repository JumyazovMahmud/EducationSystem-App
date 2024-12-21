package uz.itschool.educationsystemapp.dto

class CourseDto (
    var courseId: Int,
    var courseName: String,
//    var basics: Map<MutableList<String>, Int>,
//    var occupations:  Map<MutableList<String>, Int>,
//    var conversations:  Map<MutableList<String>, Int>,
//    var places:  Map<MutableList<String>, Int>,
//    var familyMembers:  Map<MutableList<String>, Int>,
//    var foods:  Map<MutableList<String>, Int>,
    var duration :Int,
    var deleted : Boolean = false
)