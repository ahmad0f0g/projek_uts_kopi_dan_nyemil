package com.example.kopidannyemil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.kopidannyemil.R
import com.example.kopidannyemil.databinding.FragmentLoginBinding
import com.example.kopidannyemil.viewmodel.MainViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Otomatis hilangkan pesan error merah saat mengetik
        binding.etUsernameLogin.doOnTextChanged { _, _, _, _ -> binding.tilUsernameLogin.error = null }
        binding.etPasswordLogin.doOnTextChanged { _, _, _, _ -> binding.tilPasswordLogin.error = null }

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsernameLogin.text.toString().trim()
            val password = binding.etPasswordLogin.text.toString().trim()

            var isValid = true

            if (username.isEmpty()) {
                binding.tilUsernameLogin.error = "Username tidak boleh kosong"
                isValid = false
            }
            if (password.isEmpty()) {
                binding.tilPasswordLogin.error = "Password tidak boleh kosong"
                isValid = false
            }

            if (isValid) {
                viewModel.setUserName(username)

                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.splashFragment, true)
                    .build()
                findNavController().navigate(R.id.navigation_home, null, navOptions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}