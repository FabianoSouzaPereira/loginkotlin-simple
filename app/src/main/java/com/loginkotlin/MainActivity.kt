package com.loginkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.loginkotlin.Presenter.ILoginPresenter
import com.loginkotlin.Presenter.LoginPresenter
import com.loginkotlin.View.ILoginView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ILoginView {

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        loginPresenter = LoginPresenter(this)

        //Event
        btn_login.setOnClickListener{
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toasty.success(this,message,Toast.LENGTH_SHORT).show();
    }

    override fun onLoginError(message: String) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show();
    }


}