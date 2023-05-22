package com.example.currencyconvert.core.extensions

import com.haroldadmin.cnradapter.NetworkResponse

suspend fun <T : Any, E : Any> NetworkResponse<T, E>.doOnSuccess(block: suspend (T) -> Unit): NetworkResponse<T, E> {
    if (this is NetworkResponse.Success) {
        block(this@doOnSuccess.body)
    }
    return this
}

inline fun <S, E> NetworkResponse<S, E>.doOnError(
    block: NetworkResponse.Error<S, E>.() -> Unit
): NetworkResponse<S, E> {
    if (this is NetworkResponse.Error) {
        block(this)
    }
    return this
}

fun <S, E, M> NetworkResponse<S, E>.convert(func: (S) -> M): NetworkResponse<M, E> = when (this) {
    is NetworkResponse.Success -> NetworkResponse.Success(func(body), response)
    is NetworkResponse.ServerError -> NetworkResponse.ServerError(body, response)
    is NetworkResponse.NetworkError -> NetworkResponse.NetworkError(error)
    is NetworkResponse.UnknownError -> NetworkResponse.UnknownError(error, response)
}