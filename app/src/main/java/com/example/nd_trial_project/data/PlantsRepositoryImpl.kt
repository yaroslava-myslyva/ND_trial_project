package com.example.nd_trial_project.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nd_trial_project.domain.IPlantsRepository

class PlantsRepositoryImpl : IPlantsRepository {
    override fun fetchAllPlants(): LiveData<List<Plant>> = MutableLiveData<List<Plant>>(
        listOf<Plant>(
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

    )
}