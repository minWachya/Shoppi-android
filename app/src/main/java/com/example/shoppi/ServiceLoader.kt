package com.example.shoppi

import android.content.Context
import androidx.room.Room
import com.example.shoppi.database.AppDatabase
import com.example.shoppi.network.ApiClient
import com.example.shoppi.repository.cart.CartLocalDataSource
import com.example.shoppi.repository.cart.CartRepository

object ServiceLoader {
    private var apiClient: ApiClient? = null
    private var database: AppDatabase?= null
    private  var cartRepository: CartRepository ?= null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }

    private fun provideDatabase(applicationContext: Context): AppDatabase {
        return database ?: run {
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "shpooi-local"  // db 이름
            ).build().also {
                database = it
            }
        }

    }

    fun provideCartRepository(context: Context): CartRepository {
        return cartRepository ?: run {
            val dao = provideDatabase(context.applicationContext).cartProductDao()
            CartRepository(CartLocalDataSource(dao)).also {
                cartRepository = it
            }
        }
    }

}