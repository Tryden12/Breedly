package com.tryden.breedly.utils

fun inchesToFeet(inches: Int) : String {
    val feet = inches / 12
    val leftOver = inches % 12
    return "$feet' $leftOver\""
}