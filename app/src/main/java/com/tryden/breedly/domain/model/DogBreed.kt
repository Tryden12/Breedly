package com.tryden.breedly.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tryden.breedly.utils.inchesToFeet

/**
 * This is the Dog Breed Entity class for DogBreeds Database
 * We are also using it as data class for the UI and Room entity.
 */
@Entity
data class DogBreed(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false,
    val barking: Int = 0,
    val playfulness: Int = 0,
    val protectiveness: Int = 0,
    val shedding: Int = 0,
    val trainability: Int = 0,
    val drooling: Int = 0,
    val energy: Int = 0,
    val grooming: Int = 0,
    @ColumnInfo(name="image_link")
    val imageLink: String = "",
    @ColumnInfo(name="coat_length")
    val coatLength: Int = 0,
    @ColumnInfo(name="good_with_children")
    val goodWithChildren: Int = 0,
    @ColumnInfo(name="good_with_other_dogs")
    val goodWithOtherDogs: Int = 0,
    @ColumnInfo(name="good_with_strangers")
    val goodWithStrangers: Int = 0,
    @ColumnInfo(name="max_height_female")
    val maxHeightFemale: Double = 0.0,
    @ColumnInfo(name="max_height_male")
    val maxHeightMale: Double = 0.0,
    @ColumnInfo(name="min_height_female")
    val minHeightFemale: Double  = 0.0,
    @ColumnInfo(name="min_height_male")
    val minHeightMale: Double = 0.0,
    @ColumnInfo(name="max_weight_female")
    val maxWeightFemale: Double = 0.0,
    @ColumnInfo(name="max_weight_male")
    val maxWeightMale: Double = 0.0,
    @ColumnInfo(name="min_weight_female")
    val minWeightFemale: Double = 0.0,
    @ColumnInfo(name="min_weight_male")
    val minWeightMale: Double = 0.0,
    @ColumnInfo(name="max_life_expectancy")
    val maxLifeExpectancy: Double = 0.0,
    @ColumnInfo(name="min_life_expectancy")
    val minLifeExpectancy: Double = 0.0,

    // Calculated in domain layer mapping
    @ColumnInfo(name = "avg_weight")
    val avgWeight: String = "",
    @ColumnInfo(name = "avg_height")
    val avgHeight: String = "",
    @ColumnInfo(name = "avg_life_expectancy")
    val avgLifeExp: String = ""
)