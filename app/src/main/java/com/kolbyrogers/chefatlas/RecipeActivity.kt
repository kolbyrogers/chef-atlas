package com.kolbyrogers.chefatlas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, RecipeFragment.newInstance())
                .commit()
        }
    }
}