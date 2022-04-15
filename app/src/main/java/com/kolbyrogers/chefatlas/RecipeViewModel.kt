package com.kolbyrogers.chefatlas

import androidx.lifecycle.*
import com.kolbyrogers.chefatlas.model.Recipe

class RecipeViewModel: ViewModel() {

    val recipesLiveData: LiveData<List<Recipe>> = DataSource().fetchRecipes()

}