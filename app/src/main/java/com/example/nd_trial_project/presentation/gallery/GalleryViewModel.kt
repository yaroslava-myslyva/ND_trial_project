package com.example.nd_trial_project.presentation.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.nd_trial_project.data.Plant
import com.example.nd_trial_project.data.PlantsRepositoryImpl
import com.example.nd_trial_project.domain.IPlantsRepository

class GalleryViewModel : ViewModel() {
    private val repository: IPlantsRepository = PlantsRepositoryImpl()
    fun getAllPlants(): LiveData<List<Plant>> = repository.fetchAllPlants()
}