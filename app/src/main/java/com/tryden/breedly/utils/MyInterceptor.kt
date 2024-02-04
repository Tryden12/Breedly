package com.tryden.breedly.utils

import android.util.Log
import com.tryden.breedly.utils.Constants.API_KEY_NAME
import com.tryden.breedly.utils.Constants.API_KEY_VALUE
import okhttp3.Interceptor
import okhttp3.Response

/**
 * This custom interceptor class is used in the NetworkModule to add headers to the base url.
 * Headers: API Key & Host Name
 */
class MyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader(API_KEY_NAME , API_KEY_VALUE)
            .build()
        Log.d("MyInterceptor()", "request url: ${chain.request().url}")
        return chain.proceed(request)
    }
}