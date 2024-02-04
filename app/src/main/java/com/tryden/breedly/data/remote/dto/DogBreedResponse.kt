package com.tryden.breedly.data.remote.dto

import com.squareup.moshi.Json

data class DogBreedResponse(
    val name: String,
    val barking: Int,
    val playfulness: Int,
    val protectiveness: Int,
    val shedding: Int,
    val trainability: Int,
    val drooling: Int,
    val energy: Int,
    val grooming: Int,

    @Json(name="image_link")
    val imageLink: String,
    @Json(name="coat_length")
    val coatLength: Int,
    @Json(name="good_with_children")
    val goodWithChildren: Int,
    @Json(name="good_with_other_dogs")
    val goodWithOtherDogs: Int,
    @Json(name="good_with_strangers")
    val goodWithStrangers: Int,
    @Json(name="max_height_female")
    val maxHeightFemale: Double,
    @Json(name="max_height_male")
    val maxHeightMale: Double,
    @Json(name="min_height_female")
    val minHeightFemale: Double,
    @Json(name="min_height_male")
    val minHeightMale: Double,
    @Json(name="max_weight_female")
    val maxWeightFemale: Double,
    @Json(name="max_weight_male")
    val maxWeightMale: Double,
    @Json(name="min_weight_female")
    val minWeightFemale: Double,
    @Json(name="min_weight_male")
    val minWeightMale: Double,
    @Json(name="max_life_expectancy")
    val maxLifeExpectancy: Double,
    @Json(name="min_life_expectancy")
    val minLifeExpectancy: Double
)