package dev.marsellus

import com.fasterxml.jackson.annotation.JsonProperty

fun main() {

    val person = Person(name = "Marsellus", age = 25)

    println("Hello $person!")
}

data class Person(@get:JsonProperty("name") val name: String, val age: Int, val gender: String = "Male")