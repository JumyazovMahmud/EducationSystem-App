package uz.itschool.educationsystemapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("course")
class Course (
    @PrimaryKey(autoGenerate = true)
    var courseId: Int = 0,
    var courseName: String,
//    var basics: Map<MutableList<String>, Int>,
//    var occupations:  Map<MutableList<String>, Int>,
//    var conversations:  Map<MutableList<String>, Int>,
//    var places:  Map<MutableList<String>, Int>,
//    var familyMembers:  Map<MutableList<String>, Int>,
//    var foods:  Map<MutableList<String>, Int>,
    var duration :Int,
    var deleted : Boolean = false


) {
    constructor( courseName: String, duration: Int) : this(
        courseId = 0,
        courseName,
        duration,
    )
}