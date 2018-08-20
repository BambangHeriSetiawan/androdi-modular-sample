package com.simx.data

import android.annotation.SuppressLint
import com.simx.model.ResponseDiscovery
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class ApiRequestManager constructor(apiCallback: ApiCallback) {
    var callback: ApiCallback = apiCallback
    @SuppressLint("CheckResult")
    open fun getDiscoveryMovie(){
        Api.Factory.create().getdiscoveryMovie("280b8649d1bf789f539e3fec62c7bcfc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {callback.onNext(it)},
                        {callback.onError(it)}
                )

    }
}