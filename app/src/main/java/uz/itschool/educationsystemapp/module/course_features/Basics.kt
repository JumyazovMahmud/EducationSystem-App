package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity

@Entity("basics")
class Basics (
    var courseName: String,
    var topic: String,
    var info: String // The information about the topic
)