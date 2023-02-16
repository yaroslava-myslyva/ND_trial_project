package com.example.nd_trial_project

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.nd_trial_project.databinding.ItemGalleryBinding
import kotlin.properties.Delegates

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    private lateinit var fragment: GalleryFragment
    private lateinit var list: List<Plant>
    private var width by Delegates.notNull<Int>()
    private var numberOfColumns by Delegates.notNull<Int>()

    fun setFragment(fragment: GalleryFragment) {
        this.fragment = fragment
    }

    fun setList(list: List<Plant>) {
        this.list = list
    }

    fun setWindowWidth(width: Int?) {
        this.width = width ?: 0
    }

    fun setGridNumberOfColumns(number: Int) {
        this.numberOfColumns = number
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        Log.d(TAG, "onCreateViewHolder()")

        val binding = ItemGalleryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder()")
        if (width > 0) {
            Log.d(TAG, "true")
            holder.itemView.layoutParams.width = width / numberOfColumns
            holder.itemView.layoutParams.height = width / numberOfColumns
        }

        val plant = list[position]
        holder.bind(plant)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount() ${list.size}")

        return list.size
    }


    inner class GalleryViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plant: Plant) {
            binding.text.text = plant.name
            Glide.with(itemView)
                .load(plant.imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade(1500))
                .into(binding.image)
            Log.d(TAG, "bind()")

            itemView.setOnClickListener {
                Log.d(TAG, "click")
                val bundle = bundleOf("url" to plant.websiteUrl)
                fragment.findNavController().navigate(R.id.destination_website_fragment, bundle)

            }
        }
    }
}