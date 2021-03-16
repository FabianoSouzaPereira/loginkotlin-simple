package com.loginkotlin.View

interface ILoginView {
    fun onLoginSuccess(message:String)
    fun onLoginError(message:String)
}