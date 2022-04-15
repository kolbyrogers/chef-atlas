package com.kolbyrogers.chefatlas.model

import com.google.gson.annotations.SerializedName

class RecipeResponse {
    @SerializedName("results")
    lateinit var results: List<Recipe>
}