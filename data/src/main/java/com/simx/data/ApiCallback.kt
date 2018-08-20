package com.simx.data

import com.simx.model.ResponseDiscovery
import io.reactivex.internal.operators.observable.ObservableOnErrorNext

interface ApiCallback {
    fun onNext(responseDiscovery: ResponseDiscovery)
    fun onError(throwable: Throwable)
}