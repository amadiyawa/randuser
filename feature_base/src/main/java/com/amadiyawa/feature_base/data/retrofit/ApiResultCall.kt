package com.amadiyawa.feature_base.data.retrofit

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class ApiResultCall<T>(
    private val delegate: Call<T>
) : Call<ApiResult<T>> {
    override fun execute(): Response<ApiResult<T>> {
        throw UnsupportedOperationException("ApiResultCall doesn't support execute")
    }

    override fun enqueue(callback: Callback<ApiResult<T>>) {
        delegate.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Success(response.body()!!)))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Exception(t)))
            }
        })
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun clone(): Call<ApiResult<T>> = ApiResultCall(delegate.clone())

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}