package com.kolbyrogers.chefatlas

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kolbyrogers.chefatlas.model.Recipe

private const val ARG_RECIPE = "recipe"
class RecipeFragment : Fragment() {
    interface Callbacks {
        fun onRecipeSelected(recipeId: Recipe)
    }

    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var mView: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

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
        var callbacks: Callbacks? = null

        fun newInstance(recipe: Recipe): RecipeFragment {
            val args = Bundle().apply {
                putSerializable(ARG_RECIPE, recipe)
            }
            return RecipeFragment().apply {
                arguments = args
            }
        }
    }
}