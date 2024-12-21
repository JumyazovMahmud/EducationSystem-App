package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity

@Entity("occupations")
class Occupations (
    var courseName: String,
    var word: String,
    var definition: String,
    var example: String
)