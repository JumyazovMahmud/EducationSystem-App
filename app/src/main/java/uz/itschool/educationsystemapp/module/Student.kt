package uz.itschool.educationsystemapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("student")
class Student (
    @PrimaryKey(autoGenerate = true)
    var studentId :Int,
    var name: String,
    var email: String,
    var username :String,
    var password: String,
    var phone: String,
    var deleted : Boolean = false
)


