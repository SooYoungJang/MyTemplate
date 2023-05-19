package com.sooyoung.domain.base

import kotlinx.coroutines.flow.Flow

interface FlowBaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): Flow<R>
}

interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): R
}
