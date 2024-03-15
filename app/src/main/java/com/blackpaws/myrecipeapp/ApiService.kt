package com.blackpaws.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
private const val CATEGORIES_ENDPOINT = "categories.php"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET(CATEGORIES_ENDPOINT)
    suspend fun getCategories(): CategoriesResponse
}