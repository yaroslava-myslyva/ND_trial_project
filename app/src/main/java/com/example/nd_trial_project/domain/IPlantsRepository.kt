package com.example.nd_trial_project.domain

import androidx.lifecycle.LiveData
import com.example.nd_trial_project.data.Plant

interface IPlantsRepository {
    /**
     *  Method for getting all plants.
     */
    fun fetchAllPlants(): LiveData<List<Plant>>
}