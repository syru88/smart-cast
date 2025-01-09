package dev.marsellus

import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.client.models.Details
import org.openapitools.client.models.Pet

fun main() {

    val person = Person(name = "Marsellus", age = 25, details = "other info")
    val pet = Pet(id = 1L, name = "Pet", details = Details(description = "other information"))

    println("Hello $person!")
    println("Hello ${pet.details.description}")
}

data class Person(@get:JsonProperty("name") val name: String, val age: Int, val details: String, val other: String = "other")