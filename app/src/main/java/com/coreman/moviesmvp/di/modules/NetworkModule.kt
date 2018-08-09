package com.coreman.moviesmvp.di.modules

import com.coreman.moviesmvp.util.API_KEY
import com.coreman.moviesmvp.util.BASE_URL
import com.coreman.moviesmvp.api.MoviesApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {

        val interceptors = arrayListOf<Interceptor>()

        val keyInterceptor = Interceptor { chain ->

            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()

            val requestBuilder = original.newBuilder()
                    .url(url)

            val request = requestBuilder.build()
            return@Interceptor chain.proceed(request)
        }

        interceptors.add(keyInterceptor)
        return interceptors
    }

    @Provides
    fun provideMovieApi(retrofit: Retrofit) : MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    fun provideRetrofit(interceptors: ArrayList<Interceptor>) : Retrofit {
        val clientBuilder = OkHttpClient.Builder()
        if (!interceptors.isEmpty()) {
            interceptors.forEach { interceptor ->
                clientBuilder.addInterceptor(interceptor)
            }
        }
        return Retrofit.Builder()
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

}