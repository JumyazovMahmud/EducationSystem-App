package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("conversations")
class Conversations (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var courseName: String,
    var description: String,
    var conversation: String
)