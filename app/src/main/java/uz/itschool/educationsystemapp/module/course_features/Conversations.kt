package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity

@Entity("conversations")
class Conversations (
    var courseName: String,
    var description: String,
    var conversation: String
)