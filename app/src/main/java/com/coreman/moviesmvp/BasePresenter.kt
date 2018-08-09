package com.coreman.moviesmvp

interface BasePresenter<in T> {

    fun attachView(view: T)
}