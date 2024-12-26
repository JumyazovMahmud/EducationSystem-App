package uz.itschool.educationsystemapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("student")
class Student (
    @PrimaryKey(autoGenerate = true)
    var studentId :Int = 0,
    var name: String,
    var email: String,
    var username :String,
    var password: String,
    var phone: String,
    var deleted : Boolean = false
) {
    constructor(name: String, email: String, phone: String, username: String, password: String) : this(
        studentId = 0,
        name = name,
        email = email,
        phone = phone,
        username = username,
        password = password
    )
}


