package com.test.midas.koin

import com.google.gson.GsonBuilder
import com.test.midas.BuildConfig
import com.test.midas.service.ApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS


val networkModule = module {
    single {
        initRetrofit()
    }
}

fun initRetrofit(): ApiServices {

    val timeout: Long = 30

    val client =
        OkHttpClient.Builder()
            .callTimeout(timeout, SECONDS)
            .connectTimeout(timeout, SECONDS)
            .writeTimeout(timeout, SECONDS)
            .readTimeout(timeout, SECONDS)

    if (BuildConfig.BUILD_TYPE == "debug") {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS
        val headerLogging = HttpLoggingInterceptor()
        headerLogging.level = HttpLoggingInterceptor.Level.BODY

        client.addInterceptor(headerLogging)
        client.addInterceptor(logging)
    }

    val gson = GsonBuilder()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://midas-be-task.herokuapp.com/midas/config/v1/")
        .client(client.build())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    return retrofit.create(ApiServices::class.java)
}
