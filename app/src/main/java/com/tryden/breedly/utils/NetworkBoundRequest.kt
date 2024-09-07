package com.tryden.breedly.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(
    // responsible for getting data from database
    crossinline query: () -> Flow<ResultType>,
    // responsible for fetching new data from rest api
    crossinline fetch: suspend () -> RequestType,
    // responsible for taking data from fetch and saving it to database
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    // responsible for deciding new data from api is needed or cache is enough
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {

    // get one list of restaurant from database
    val data = query().first()

    // if its time to update cache if data is decent or not
    val flow = if (shouldFetch(data)) {

        // loading and cache data
        emit(Resource.Loading(data))

        try {

            // save data to catch
            saveFetchResult(fetch())

            // new data from api
            query().map { Resource.Success(it) }
        } catch (t: Throwable) {

            // error and cache data
            query().map { Resource.Error(t, it) }
        }
    } else {

        // cache data
        query().map { Resource.Success(it) }
    }

    // get all
    emitAll(flow)
}.flowOn(Dispatchers.IO)
