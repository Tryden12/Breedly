package com.tryden.breedly.utils

object Constants {

    /** API **/
    const val BASE_URL      = "https://api.api-ninjas.com/v1/"
    const val API_KEY_NAME  = "X-Api-Key"
    const val API_KEY_VALUE = "uQMzA1oELLsTA/b4LM1pOQ==cL4MiVL01VrZk1hD"
    const val DB_NAME       = "dog_breeds_db"

    /** Route **/
    const val HOME_ROUTE          = "home"
    const val BREED_DETAILS_ROUTE = "details/{breedId}"
    const val FAVORITES_ROUTE     = "favorites"
    const val BREED_ID_KEY        = "breedId"

    /** Error State **/
    const val ERROR_MESSAGE_TO_USER = "Oh no! There seems to be an issue. Please try again soon."

    /** Attribute Labels & value addition(s) **/
    const val TRAINABILITY    = "Trainability"
    const val ENERGY          = "Energy"
    const val PLAYFULNESS     = "Playfulness"
    const val BARKING         = "Barking"
    const val PROTECTIVENESS  = "Protectiveness"
    const val SHEDDING        = "Shedding"
    const val LBS             = " lbs"

    /** Favorite Tag **/
    const val FAVORITE = "Favorite"

}