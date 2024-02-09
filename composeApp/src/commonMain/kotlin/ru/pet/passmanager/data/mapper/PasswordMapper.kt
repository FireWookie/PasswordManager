package ru.pet.passmanager.data.mapper

import ru.pet.passmanager.data.models.PasswordResponse
import ru.pet.passmanager.domain.models.PasswordUI

fun PasswordResponse.toUI(): PasswordUI {
    return PasswordUI(this.id, this.name, this.password)
}