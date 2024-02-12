package ru.pet.passmanager.platform

import kotlinx.coroutines.*

/**
 * Базовый UseCase для бизнес логики
 */
abstract class BaseUseCase<in Params, out Type> where Type : Any {

    abstract suspend fun execute(params: Params): Either<Failure, Type>
    open suspend operator fun invoke(
        scope: CoroutineScope,
        params: Params,
    ): Either<Failure, Type> {
        return try {
            execute(params)
        } catch (e: Exception) {
            Either.Left(Failure.Message(e.message.orEmpty()))
        }
    }
}