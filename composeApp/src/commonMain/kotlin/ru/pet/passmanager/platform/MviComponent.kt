package ru.pet.passmanager.platform

import org.koin.core.component.KoinComponent
import org.orbitmvi.orbit.annotation.OrbitDsl
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.SimpleContext
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent

interface MviComponent<STATE: Any, ACTION: Any, SIDE_EFFECT: Any, STORE> where STORE: MviStore<STATE, ACTION, SIDE_EFFECT> {
    val store: STORE
    fun dispatch(action: ACTION)

    @OrbitDsl
    fun intent(
        registerIdling: Boolean = true,
        transformer: suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit
    ) = store.intent(registerIdling) { transformer() }

    @OrbitDsl
    fun blockingIntent(
        registerIdling: Boolean = true,
        transformer: suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit
    ) = store.blockingIntent(registerIdling) { transformer() }

}