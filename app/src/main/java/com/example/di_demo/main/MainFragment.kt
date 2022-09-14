package com.example.di_demo.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.auth_impl.AuthActivity
import com.example.component.findDependency
import com.example.di_demo.databinding.FragmentFirstBinding
import com.example.feature_toggles.core.FeatureToggleStorage
import com.example.feature_toggles.main.NextButtonDisableAuthToggle
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @Inject
    lateinit var featureToggleStorage: FeatureToggleStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireContext().findDependency<MainFragmentComponent.Parent>()
            .mainFragmentComponentFactory()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            if (featureToggleStorage.get(NextButtonDisableAuthToggle::class)) {
                Toast.makeText(requireContext(), "Auth disabled!", Toast.LENGTH_LONG).show()
            } else {
                requireActivity().startActivity(Intent(context, AuthActivity::class.java))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}