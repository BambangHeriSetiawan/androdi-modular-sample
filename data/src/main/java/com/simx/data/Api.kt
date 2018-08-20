package com.simx.data

import com.simx.model.ResponseDiscovery
import io.reactivex.Observable
import okhttp3.logging.HttpLoggingInterceptor
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface Api {
    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("discover/movie")
    fun getdiscoveryMovie(
            @Query("api_key") api_key:String
    ): Observable<ResponseDiscovery>

    object Factory {
        val retrofit: Retrofit? = null
        val retrofitConfig: Retrofit
            get() = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client())
                    .build()

        fun create(): Api {
            return retrofitConfig.create(Api::class.java)
        }

        private fun client(): OkHttpClient {
            return OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
        }
    }
}