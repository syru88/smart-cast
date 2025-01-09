package dev.marsellus

import com.fasterxml.jackson.annotation.JsonProperty
import dev.marsellus.model.Details
import dev.marsellus.model.Pet

fun main() {

    val person = Person(
        name = "Marsellus",
        age = 25, details = "details",
        other = "another"
    )
    val pet = Pet(id = 1L, name = "Pet", details = Details(description = "other information"))

    println("Hello $person!")
    requireNotNull(pet.details)
    log(pet.details.description)
}

private fun log(value: String) {
    println("log: $value")
}

data class Person(
    @get:JsonProperty("name")
    val name: String,
    val age: Int,
    val details: String,
    val other: String,
)