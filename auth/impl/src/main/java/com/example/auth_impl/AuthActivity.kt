package com.example.auth_impl

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.auth_api.AuthDependencies
import com.example.auth_impl.databinding.ActivityAuthBinding
import com.example.auth_impl.di.DaggerAuthScreenComponent
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: AuthViewModel

    private val binding: ActivityAuthBinding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

//        DaggerAuthScreenComponent.factory()
//            .create(this)
//            .inject(this)
//
//        or
        DaggerAuthScreenComponent.factory().create(
            this,
            findDependency<AuthDependencies>()
        )
        viewModel.userName.observe(this) { userName ->
            binding.textviewUser.text = "Username: $userName"
        }

        viewModel.isAuthButtonVisible.observe(this) { isVisible ->
            binding.btnAuth.isVisible = isVisible
        }

        binding.btnAuth.setOnClickListener { viewModel.onAuthClicked() }
    }
}