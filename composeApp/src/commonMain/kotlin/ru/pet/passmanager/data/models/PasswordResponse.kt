package ru.pet.passmanager.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PasswordResponse(
    val id: Long,
    val name: String,
    val password: String
)
