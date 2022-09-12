package com.example.auth_impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.auth_impl.databinding.ActivityAuthBinding
import com.example.auth_impl.di.AuthScreenMergeComponent
import com.example.component.findDependency
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
//        DaggerAuthScreenMergeComponent.factory()
//            .create(
//                this,
//                findDependency<AuthDependencies>()
//            )
//            .inject(this)

        findDependency<AuthScreenMergeComponent.ParentComponent>()
            .authScreenMergeComponentFactory()
            .create(this)
            .inject(this)


        viewModel.userName.observe(this) { userName ->
            binding.textviewUser.text = userName
        }

        viewModel.isAuthButtonVisible.observe(this) { isVisible ->
            binding.btnAuth.isVisible = isVisible
        }

        binding.btnAuth.setOnClickListener { viewModel.onAuthClicked() }
    }
}