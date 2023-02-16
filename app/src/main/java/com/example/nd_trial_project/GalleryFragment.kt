package com.example.nd_trial_project

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nd_trial_project.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private val list = listOf<Plant>(
        Plant(
            "Солейролія",
            "https://rastenievod.com/wp-content/uploads/2016/09/3-60.jpg",
            "https://faterra.com/uk/katalog-kimnatnikh-roslin/soleirolia-ua.html"
        ),
        Plant(
            "Діффенбахія",
            "https://rastenievod.com/wp-content/uploads/2016/06/13-41.jpg",
            "https://faterra.com/uk/katalog-kimnatnikh-roslin/dyffenbakhiia-ua.html"
        ),
        Plant(
            "Хлорофітум",
            "https://rastenievod.com/wp-content/uploads/2016/08/3-45.jpg",
            "https://faterra.com/uk/katalog-kimnatnikh-roslin/khlorofitumchlorophytumua.html"
        ),
        Plant(
            "Аспарагус",
            "https://rastenievod.com/wp-content/uploads/2016/09/7-26.jpg",
            "https://faterra.com/uk/katalog-kimnatnikh-roslin/asparagus-ua.html"
        ),
        Plant(
            "Аспленіум",
            "https://rastenievod.com/wp-content/uploads/2016/09/7-46.jpg",
            "https://faterra.com/uk/katalog-kimnatnikh-roslin/asplenium-ua.html"
        ),
        Plant(
            "Пуансетія",
            "https://rastenievod.com/wp-content/uploads/2016/06/2-86.jpg",
            "https://faterra.com/uk/katalog-kimnatnikh-roslin/poinsettia-ua.html"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(list)
    }

    private fun setRecyclerView(list: List<Plant>) {

        val adapter = GalleryAdapter()
        adapter.setFragment(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            adapter.setWindowWidth(activity?.windowManager?.currentWindowMetrics?.bounds?.width())
        } else {
            adapter.setWindowWidth(activity?.windowManager?.defaultDisplay?.width)
        }
        val numberOfColumns = 2
        adapter.setGridNumberOfColumns(numberOfColumns)
        adapter.setList(list)
        binding.galleryList.adapter = adapter
        binding.galleryList.run {
            layoutManager = GridLayoutManager(context, numberOfColumns)

        }

        Log.d(TAG, "setRecyclerView()")
    }


}