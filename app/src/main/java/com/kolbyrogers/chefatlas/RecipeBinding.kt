package com.kolbyrogers.chefatlas

import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.kolbyrogers.chefatlas.model.Recipe
import com.squareup.picasso.Picasso

class RecipeBinding {

    companion object {

        @BindingAdapter("recipeClickListener")
        @JvmStatic
        fun onClickRecipe(recipeRow: ConstraintLayout, recipe: Recipe) {
            recipeRow.setOnClickListener{
                Log.d("Bind", "onClickRecipe: CLICKED $recipe")
                RecipeFragment.callbacks?.onRecipeSelected(recipe)
            }
        }

        @BindingAdapter("setInstructions")
        @JvmStatic
        fun setInstructions(textView: TextView, instructions: String) {
            textView.text = "$instructions"
        }

        @BindingAdapter("setPrepTime")
        @JvmStatic
        fun setPrepTime(textView: TextView, time: Int) {
            textView.text = "$time mins"
        }

        @BindingAdapter("setServings")
        @JvmStatic
        fun setServings(textView: TextView, servings: Int) {
            textView.text = "Serves $servings"
        }

        @BindingAdapter("setPrice")
        @JvmStatic
        fun setPrice(textView: TextView, price: Double) {
            var adjPrice = price.toString().dropLast(2)
            val price = adjPrice.toCharArray().let {
                for (i in 0 until it.lastIndex)
                    it[i] = it[i+1]
                it[it.lastIndex] = adjPrice[it.lastIndex-1]
                it[it.lastIndex-1] = adjPrice[it.lastIndex-2]
                it[it.lastIndex-2] = adjPrice[it.lastIndex]
                String(it)
            }
            textView.text = "$$price per"
        }

        @BindingAdapter("setDescription")
        @JvmStatic
        fun setDescription(textView: TextView, description: String) {
            textView.text = description
        }

        @BindingAdapter("setTitle")
        @JvmStatic
        fun setTitle(textView: TextView, title: String) {
            textView.text = title
        }

        @BindingAdapter("setImage")
        @JvmStatic
        fun setImage(imageView: ImageView, imageUrl: String) {
            Picasso.get().load(imageUrl)
                .into(imageView)
        }
    }
}