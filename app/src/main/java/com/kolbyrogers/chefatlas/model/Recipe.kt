package com.kolbyrogers.chefatlas.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Recipe(
    @SerializedName("aggregateLikes")
    var aggregateLikes: Int,
    @SerializedName("extendedIngredients")
    var extendedIngredients: List<ExtendedIngredient>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String = "",
    @SerializedName("instructions")
    var instructions: String,
    @SerializedName("pricePerServing")
    var pricePerServing: Double,
    @SerializedName("readyInMinutes")
    var readyInMinutes: Int,
    @SerializedName("servings")
    var servings: Int,
    @SerializedName("sourceName")
    var sourceName: String,
    @SerializedName("sourceUrl")
    var sourceUrl: String,
    @SerializedName("summary")
    var summary: String,
    @SerializedName("title")
    var title: String,
) : Serializable