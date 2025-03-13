package dev.marsellus

import dev.marsellus.model.Details
import dev.marsellus.model.Pet

fun main() {

    val pet = Pet(id = 1L, name = "Pet", details = Details(description = "other information"))

    println("Hello world")
    requireNotNull(pet.details)
    log(pet.details.description)
}

private fun log(value: String) {
    println("log: $value")
}
