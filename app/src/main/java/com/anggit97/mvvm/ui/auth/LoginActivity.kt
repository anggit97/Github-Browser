package com.anggit97.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anggit97.core.utils.ViewModelFactory
import com.anggit97.core.utils.toast
import com.anggit97.data.user.UserItem
import com.anggit97.mvvm.R
import com.anggit97.mvvm.dagger.AuthenticationProvder
import com.anggit97.mvvm.dagger.DaggerAppComponent
import com.anggit97.mvvm.dagger.AppModule
import com.anggit97.network.AuthenticationInterceptor
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var authenticationInterceptor: AuthenticationInterceptor

    private lateinit var viewModel: LoginViewModel

    private var userData: MutableList<UserItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initInjector()

        init()

        btn_login.setOnClickListener {
            authenticationInterceptor.password = et_password.text.toString()
            authenticationInterceptor.username = et_username.text.toString()
            viewModel.getUsers(et_username.text.toString())
        }
    }

    private fun initInjector() {
        DaggerAppComponent
            .builder()
            .appModule(AppModule())
            .build()
            .inject(this)
    }

    private fun init() {
        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(LoginViewModel::class.java)

        initObserver()
    }

    private fun initObserver() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is LoginState.ShowLoading -> toast("Loading.")
                is LoginState.HideLoading -> toast("Complete.")
            }
        })

        viewModel.result.observe(this, Observer { data ->
            e("DATA : ", data.toString())
        })

        viewModel.error.observe(this, Observer { error ->
            e("Error : ", error)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}
