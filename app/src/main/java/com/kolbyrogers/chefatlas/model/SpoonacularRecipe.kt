package com.kolbyrogers.chefatlas.model


import com.google.gson.annotations.SerializedName

data class SpoonacularRecipe(
    @SerializedName("recipes")
    val recipes: List<Recipe>
)