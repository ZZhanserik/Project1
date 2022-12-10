package com.example.project1.data.local
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project1.domain.LogIn

@Database(entities = [LogIn :: class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginDao() : LogInDao
    companion object{

        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getDatabase(context: MainData): AppDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}