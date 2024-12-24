package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("basics")
class Basics (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var courseName: String,
    var topic: String,
    var info: String // The information about the topic
)