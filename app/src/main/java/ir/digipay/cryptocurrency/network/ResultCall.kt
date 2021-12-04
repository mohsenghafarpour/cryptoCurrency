package ir.digipay.cryptocurrency.network

import androidx.annotation.StringRes

sealed class ResultCall<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultCall<T>()
    data class Error(@StringRes val stringRes: Int, val errorCode: Int) : ResultCall<Nothing>()

}