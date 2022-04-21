package com.kolbyrogers.chefatlas

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kolbyrogers.chefatlas.model.Recipe

private const val ARG_RECIPE = "recipe"
class InstructionsFragment : Fragment() {
    private lateinit var recipe: Recipe

    private lateinit var viewBanner: ImageView
    private lateinit var viewTitle: TextView
    private lateinit var viewTime: TextView
    private lateinit var viewServings: TextView
    private lateinit var viewPrice: TextView
    private lateinit var viewDescription: TextView

    private lateinit var mRecipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipe = arguments?.getSerializable(ARG_RECIPE) as Recipe
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instructions, container, false)

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        viewBanner = view.findViewById(R.id.viewBanner) as ImageView
        viewTitle = view.findViewById(R.id.viewTitle) as TextView
        viewTime = view.findViewById(R.id.viewTime) as TextView
        viewPrice = view.findViewById(R.id.viewPrice) as TextView
        viewServings = view.findViewById(R.id.viewServings) as TextView
        viewDescription = view.findViewById(R.id.viewDescription) as TextView

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
    }

    private fun updateUI() {
        RecipeBinding.setImage(viewBanner, recipe.image)
        RecipeBinding.setTitle(viewTitle, recipe.title)
        RecipeBinding.setPrepTime(viewTime, recipe.readyInMinutes)
        RecipeBinding.setServings(viewServings, recipe.servings)
        RecipeBinding.setPrice(viewPrice, recipe.pricePerServing)
        RecipeBinding.setInstructions(viewDescription, recipe.summary)
    }

    companion object {
        var callbacks: RecipeFragment.Callbacks? = null

        fun newInstance(recipe: Recipe): InstructionsFragment {
            val args = Bundle().apply {
                putSerializable(ARG_RECIPE, recipe)
            }
            return InstructionsFragment().apply {
                arguments = args
            }
        }
    }
}