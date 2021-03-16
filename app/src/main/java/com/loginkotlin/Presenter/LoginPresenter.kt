package com.loginkotlin.Presenter

import com.loginkotlin.Model.User
import com.loginkotlin.View.ILoginView

class LoginPresenter(internal var iLoginView: ILoginView):ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        val user = User(email,password)
        val isLoginCode = user.isDataValid()

        if(isLoginCode == 0)
            iLoginView.onLoginError("email must not be null")
        else if(isLoginCode == 1)
            iLoginView.onLoginError("Wrong email address")
        else if(isLoginCode == 2)
            iLoginView.onLoginError("email must be greater than 6")
        else
            iLoginView.onLoginSuccess("login success")
    }
}