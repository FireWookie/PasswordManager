package ru.pet.passmanager.platform

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.orbitmvi.orbit.annotation.OrbitDsl
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.annotation.OrbitInternal
import org.orbitmvi.orbit.syntax.simple.SimpleContext
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent

interface MviComponent<STATE: Any, ACTION: Any, SIDE_EFFECT: Any, STORE> where STORE: MviStore<STATE, ACTION, SIDE_EFFECT> {

    private val ioScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO + SupervisorJob())

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

    @OptIn(OrbitInternal::class)
    fun <S : Any, SE : Any> SimpleSyntax<S, SE>.reduceLocal(reducer: SimpleContext<S>.() -> S) {
        ioScope.launch {
            containerContext.reduce { reducerState ->
                SimpleContext(reducerState).reducer()
            }
        }
    }
}