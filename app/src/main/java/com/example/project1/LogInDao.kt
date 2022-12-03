package com.example.project1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LogInDao {
    @Query("SELECT * FROM user_inf_table")
    fun getAll(): List<LogIn>

    /* @Query("SELECT * FROM student_table WHERE uid IN (:userIds)")
     fun loadAllByIds(userIds: IntArray): List<Student>*/

    @Query("SELECT * FROM user_inf_table WHERE password LIKE :roll LIMIT 1")
    suspend fun findByRoll(roll: Int): LogIn

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: LogIn)

    @Delete
    suspend fun delete(user: LogIn)

    @Query("DELETE FROM user_inf_table")
    suspend fun deleteAll()
}