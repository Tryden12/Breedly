package com.tryden.breedly.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This is the Dog Breed Entity class for DogBreeds Database
 * We are also using it as data class for the UI and Room entity.
 */
@Entity
data class DogBreed(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false,
    val barking: Int,
    val playfulness: Int,
    val protectiveness: Int,
    val shedding: Int,
    val trainability: Int,
    val drooling: Int,
    val energy: Int,
    val grooming: Int,
    @ColumnInfo(name="image_link")
    val imageLink: String,
    @ColumnInfo(name="coat_length")
    val coatLength: Int,
    @ColumnInfo(name="good_with_children")
    val goodWithChildren: Int,
    @ColumnInfo(name="good_with_other_dogs")
    val goodWithOtherDogs: Int,
    @ColumnInfo(name="good_with_strangers")
    val goodWithStrangers: Int,
    @ColumnInfo(name="max_height_female")
    val maxHeightFemale: Double,
    @ColumnInfo(name="max_height_male")
    val maxHeightMale: Double,
    @ColumnInfo(name="min_height_female")
    val minHeightFemale: Double,
    @ColumnInfo(name="min_height_male")
    val minHeightMale: Double,
    @ColumnInfo(name="max_weight_female")
    val maxWeightFemale: Double,
    @ColumnInfo(name="max_weight_male")
    val maxWeightMale: Double,
    @ColumnInfo(name="min_weight_female")
    val minWeightFemale: Double,
    @ColumnInfo(name="min_weight_male")
    val minWeightMale: Double,
    @ColumnInfo(name="max_life_expectancy")
    val maxLifeExpectancy: Double,
    @ColumnInfo(name="min_life_expectancy")
    val minLifeExpectancy: Double
)