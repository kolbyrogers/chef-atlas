package com.kolbyrogers.chefatlas

import com.kolbyrogers.chefatlas.model.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("recipes/complexSearch?" +
            "apiKey=68cc9e53f1964eaa9a9d79516d32fa36" +
            "&number=40" +
            "&type=lunch" +
            "&addRecipeInformation=true"
    )
    fun fetchRecipes(): Call<RecipeResponse>
}
