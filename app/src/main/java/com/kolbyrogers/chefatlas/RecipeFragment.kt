package com.kolbyrogers.chefatlas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kolbyrogers.chefatlas.databinding.RecipeRowBinding
import com.kolbyrogers.chefatlas.model.Recipe
import com.squareup.picasso.Picasso

class RecipeFragment : Fragment() {

    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipeViewModel= ViewModelProviders.of(this).get(RecipeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_recipe, container, false)

        recipeRecyclerView = mView.findViewById(R.id.recipe_recycler_view)
        recipeRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipeViewModel.recipesLiveData.observe(
            viewLifecycleOwner,
            Observer { recipes ->
                Log.d("DataSource", "onViewCreated: LiveData received: $recipes")
                recipeRecyclerView.adapter = RecipeAdapter(recipes)
            }
        )
    }

    companion object {
        fun newInstance() = RecipeFragment()
    }

}