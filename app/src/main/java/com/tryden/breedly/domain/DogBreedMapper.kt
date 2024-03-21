package com.tryden.breedly.domain

import com.tryden.breedly.data.remote.response.DogBreedResponse
import com.tryden.breedly.domain.model.DogBreed
import javax.inject.Inject

class DogBreedMapper @Inject constructor() : Mapper<DogBreed, DogBreedResponse> {
    override fun buildFrom(value: DogBreedResponse): DogBreed {
        return DogBreed(
            barking = value.barking,
            name = value.name,
            playfulness = value.playfulness,
            protectiveness = value.protectiveness,
            shedding = value.shedding,
            trainability = value.trainability,
            drooling = value.drooling,
            energy = value.energy,
            grooming = value.grooming,
            imageLink = value.imageLink,
            coatLength = value.coatLength,
            goodWithChildren = value.goodWithChildren,
            goodWithOtherDogs = value.goodWithOtherDogs,
            goodWithStrangers = value.goodWithStrangers,
            maxHeightFemale = value.maxHeightFemale,
            maxHeightMale = value.maxHeightMale,
            minHeightFemale = value.minHeightFemale,
            minHeightMale = value.minHeightMale,
            maxWeightFemale = value.maxWeightFemale,
            maxWeightMale = value.maxWeightMale,
            minWeightFemale = value.minWeightFemale,
            minWeightMale = value.minWeightMale,
            maxLifeExpectancy = value.maxLifeExpectancy,
            minLifeExpectancy = value.minLifeExpectancy,
            avgWeight = value.getAvgWeight(),
            avgHeight = value.getAvgHeight(),
            avgLifeExp = value.getAvgLifeExp()
        )
    }
}