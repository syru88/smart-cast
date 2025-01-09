package dev.marsellus

import com.fasterxml.jackson.annotation.JsonProperty
import dev.marsellus.model.Description
import dev.marsellus.model.Details
import dev.marsellus.model.Pet

fun main() {

    val person = Person(name = "Marsellus", age = 25, details = "details", /*other = "other"*/)
    val pet = Pet(id = 1L, name = "Pet", details = Details(description = Description("other information")))

    println("Hello $person!")
    requireNotNull(pet.details)
    println("Hello ${pet.details.description}")
}

data class Person(@get:JsonProperty("name") val name: String, val age: Int, val details: String, /*val other: String*/)