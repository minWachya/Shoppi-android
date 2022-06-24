package com.example.shoppi.network

import com.example.shoppi.model.Category
import com.example.shoppi.model.CategoryDetail
import com.example.shoppi.model.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

// retrofit 라이브러리 사용법 따라 생성함
// 어떤 주소와 통신할지 선언
interface ApiClient {
    @GET("categories.json")    // 달라지는 주소만 선언
    suspend fun getCategories(): List<Category> // 카테고리 목록 데이터 받아오기

    @GET("fashion-female.json")
    suspend fun getCategoryDetail(): CategoryDetail

    @GET("products/{productId}.json")
    suspend fun getProductDetail(@Path("productId") productId: String): Product

    // ApiClient 객체 생성
    companion object {

        private const val baseUrl = "https://shoppi-e99cf-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient {
            // okhttp에서 로그 확인용 client
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            // baseUrl: firebase에서 봤던 값
            // addConverterFactory: http 응답 결과을 프로젝트에서 사용하는 객체로 변환하는 방법
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}