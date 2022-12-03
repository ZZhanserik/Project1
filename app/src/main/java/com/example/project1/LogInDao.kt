package com.example.project1

import androidx.room.*

@Dao
interface LogInDao {
    @Query("SELECT * FROM user_inf_table")
    fun getAll(): List<LogIn>

    @Query("SELECT * FROM user_inf_table WHERE password LIKE :roll LIMIT 1")
    suspend fun findByRoll(roll: Int): LogIn

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: LogIn)

    @Delete
    suspend fun delete(student: LogIn)

    @Query("DELETE FROM user_inf_table")
    suspend fun deleteAll()
}