package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity

@Entity
class Places (
    var courseName: String,
    var word: String,
    var definition: String,
    var example: String
)