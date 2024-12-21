package uz.itschool.todoapp.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.itschool.todoapp.module.ToDoItem

@Dao
interface ToDoRepository {

        @Query("SELECT * FROM todo_items where deleted = false ")
        fun getAllToDoItems(): List<ToDoItem>

        @Insert
        fun addToDoItem(toDoItem: ToDoItem)

        @Query("UPDATE todo_items SET deleted = true WHERE id = :id") //DELETE FROM todo_items WHERE id = :id
        fun deleteToDoItem(id: Int)

        @Query("SELECT * FROM todo_items WHERE id = :id")
        fun getToDoItemById(id: Int): ToDoItem

        @Query("UPDATE todo_items SET title = :title, description = :description, date = :date WHERE id = :id")
        fun updateToDoItem(id: Int, title: String, description: String, date: String)

}