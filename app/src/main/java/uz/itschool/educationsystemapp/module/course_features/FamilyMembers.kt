package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("family_members")
class FamilyMembers (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var courseName: String,
    var word: String,
    var definition: String,
    var example: String
)