package uz.itschool.educationsystemapp.db.course_features

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.course_features.Conversations
import uz.itschool.educationsystemapp.module.course_features.FamilyMembers
@Dao

interface FamilyMembersRepository {

    @Query("SELECT * FROM family_members")
    fun getAllFamilyMembers(): List<FamilyMembers?>

    @Insert
    fun addFamilyMembers(familyMembers: FamilyMembers)

//    @Query("UPDATE basics SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
//    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM family_members WHERE courseName = :name")
    fun getFamilyMembersByName(name: String): FamilyMembers?

    @Query("SELECT * FROM family_members WHERE id=:id")
    fun getFamilyMembersById(id: Int): FamilyMembers?

    @Query("UPDATE family_members SET courseName = :name, word = :word, example = :example WHERE id = :id")
    fun updateFamilyMembersById(id: Int, name: String, word : String, example: String)

    @Query("UPDATE family_members SET word = :word, example = :example WHERE  courseName = :name")
    fun updateConversationsByCourseName( name: String, word : String, example: String)
}