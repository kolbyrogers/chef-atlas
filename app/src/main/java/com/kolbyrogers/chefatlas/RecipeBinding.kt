package com.kolbyrogers.chefatlas

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class RecipeBinding {

    companion object {

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