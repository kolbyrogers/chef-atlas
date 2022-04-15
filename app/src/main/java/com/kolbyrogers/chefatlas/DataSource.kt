package com.kolbyrogers.chefatlas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kolbyrogers.chefatlas.model.Recipe
import com.kolbyrogers.chefatlas.model.RecipeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataSource {
    private val api: Api

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Api::class.java)
    }

    fun fetchRecipes(): LiveData<List<Recipe>> {
        val responseLiveData: MutableLiveData<List<Recipe>> = MutableLiveData()
        val spoonacularRequest: Call<RecipeResponse> = api.fetchRecipes()

        spoonacularRequest.enqueue(object: Callback<RecipeResponse> {
            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.e("DataSource", "onFailure: Failed to fetch recipes", t)
            }

            override fun onResponse(
                call: Call<RecipeResponse>,
                response: Response<RecipeResponse>
            ) {
                Log.d("DataSource", "onResponse: Response Recieved: $response")
                val spoonacularResponse: RecipeResponse? = response.body()
                var recipes: List<Recipe>? = spoonacularResponse?.results
                recipes = recipes?.filterNot {
                    it.title.isBlank()
                }
                responseLiveData.value = recipes
            }
        })
        return responseLiveData
    }
}