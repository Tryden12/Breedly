package com.tryden.breedly.utils

object Constants {
    const val APP_NAME = "Breedly"


    /** API **/
    const val BASE_URL      = "https://api.api-ninjas.com/v1/"
    const val API_KEY_NAME  = "X-Api-Key"
    const val API_KEY_VALUE = "uQMzA1oELLsTA/b4LM1pOQ==cL4MiVL01VrZk1hD"
    const val DB_NAME       = "dog_breeds_db"

    /** Route **/
    const val BREEDS_LIST_ROUTE   = "breedsList"
    const val BREED_DETAILS_ROUTE = "details/{breedId}"
    const val FAVORITES_ROUTE     = "favorites"
    const val BREED_ID_KEY        = "breedId"

    /** Screen Names **/
    const val BREED_LIST = "Breed List"
    const val BREED_DETAILS = "Details"


    /** Icon Titles **/
    const val BREEDS = "Breeds"
    const val FAVORITES = "Favorites"


    /** Error & Empty States **/
    const val ERROR_MESSAGE_TO_USER = "Oh no! There seems to be an issue. Please try again soon."
    const val EMPTY_LIST = "Your favorites list is empty. You can view your favorite breeds here once " +
            "you've made your selection(s)."


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