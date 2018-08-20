package com.simx.sample01

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class MainViewModel: ViewModel() {
    lateinit var compositeDisposable: CompositeDisposable
   var version: String = "V1.0.0"

}