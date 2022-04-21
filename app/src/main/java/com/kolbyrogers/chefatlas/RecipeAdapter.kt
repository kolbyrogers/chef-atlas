package com.kolbyrogers.chefatlas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kolbyrogers.chefatlas.databinding.RecipeRowBinding
import com.kolbyrogers.chefatlas.model.Recipe

class RecipeAdapter(private val recipes: List<Recipe>)
    : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    class RecipeHolder(private val binding: RecipeRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindRecipe (recipe: Recipe) {
            binding.recipe = recipe
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RecipeHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecipeRowBinding.inflate(inflater, parent, false)
                return RecipeHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        return RecipeHolder.from(parent)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        val recipe = recipes[position]
        holder.bindRecipe(recipe)
    }
}