package uz.itschool.educationsystemapp.module.course_features

import androidx.room.Entity

@Entity("family_members")
class FamilyMembers (
    var courseName: String,
    var word: String,
    var definition: String,
    var example: String
)