package ru.pet.passmanager.domain.models

import androidx.compose.runtime.Stable

@Stable
data class PasswordUI(
    val id: Long,
    val name: String,
    val password: String
)
