package uz.itschool.educationsystemapp.db.course_features

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.itschool.educationsystemapp.module.course_features.Conversations
@Dao

interface ConversationsRepository {
    @Query("SELECT * FROM conversations")
    fun getAllConversations(): List<Conversations?>

    @Insert
    fun addConversations(conversations: Conversations)

//    @Query("UPDATE basics SET deleted = true WHERE courseId = :id") //DELETE FROM todo_items WHERE id = :id
//    fun deleteCourseById(id: Int)

    @Query("SELECT * FROM conversations WHERE courseName = :name")
    fun getConversationsByName(name: String): Conversations?

    @Query("SELECT * FROM conversations WHERE id=:id")
    fun getConversationsById(id: Int): Conversations?

    @Query("UPDATE conversations SET courseName = :name, description = :description, conversation = :conversation WHERE id = :id")
    fun updateConversationsById(id: Int, name: String, description : String, conversation: String)

    @Query("UPDATE conversations SET description = :description, conversation = :conversation WHERE  courseName = :name")
    fun updateConversationsByCourseName(name: String, description : String, conversation: String)
}