package com.kolbyrogers.chefatlas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kolbyrogers.chefatlas.model.Recipe

private const val TAG = "RecipeActivity"
class RecipeActivity : AppCompatActivity(), RecipeFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (currentFragment == null) {
            val fragment = RecipeFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
        }
    }

    override fun onRecipeSelected(recipe: Recipe) {
        Log.d(TAG, "onRecipeSelected: $recipe")
        val fragment = InstructionsFragment.newInstance(recipe)
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left,
                                 R.anim.slide_out_right, R.anim.slide_in_right)
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}