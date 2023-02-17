package com.example.nd_trial_project.presentation.gallery

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nd_trial_project.data.Plant
import com.example.nd_trial_project.TAG
import com.example.nd_trial_project.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        var list = mutableListOf<Plant>()
        viewModel.getAllPlants().observe(viewLifecycleOwner) {
            list = it as MutableList<Plant>
            setRecyclerView(list)
            Log.d(TAG, "observe: $list")
        }
        Log.d(TAG, "before set : $list")


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