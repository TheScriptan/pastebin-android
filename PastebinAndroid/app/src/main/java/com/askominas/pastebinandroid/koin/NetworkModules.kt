package com.askominas.pastebinandroid.koin

import com.askominas.pastebinandroid.api.BASE_URL
import com.askominas.pastebinandroid.api.PastebinApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

val networkModule = module {

    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    fun createPastebinApi(retrofit: Retrofit): PastebinApi {
        return retrofit.create(PastebinApi::class.java)
    }

    single { createRetrofit() }
    single { createPastebinApi(retrofit = get()) }
}
