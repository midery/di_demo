package com.example.auth_impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.auth_impl.databinding.ActivityAuthBinding
import com.example.auth_impl.di.DaggerAuthScreenComponentWithComponentDep
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

//        findDependency<AuthScreenMergeComponent.ParentComponent>()
//            .authScreenMergeComponentFactory()
//            .create(this)
//            .inject(this)

        DaggerAuthScreenComponentWithComponentDep.factory()
            .create(
                authActivity = this,
                authDependencies = findDependency(),
                resourcesDependencies = findDependency()
            )
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