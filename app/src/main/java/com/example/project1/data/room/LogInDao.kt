package com.example.project1.data.room

import androidx.room.*
import com.example.project1.domain.LogIn

@Dao
interface LogInDao {
    @Query(/* value = */ "SELECT * FROM user_inf_table")
    fun getAll(): List<LogIn>

    @Query("SELECT * FROM user_inf_table WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<LogIn>

    @Query("SELECT * FROM user_inf_table WHERE password LIKE :roll LIMIT 1")
    suspend fun findByRoll(roll: Int): LogIn

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: LogIn)

    @Delete
    suspend fun delete(student: LogIn)

    @Query("DELETE FROM user_inf_table")
    suspend fun deleteAll()
}