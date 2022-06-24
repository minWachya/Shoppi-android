package com.example.shoppi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppi.model.CartProduct

@Database(entities = [CartProduct::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    // Dao에 접근하는 메서드
    abstract fun cartProductDao(): CartProductDao
}