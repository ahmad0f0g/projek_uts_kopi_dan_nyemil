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
import com.example.kopidannyemil.databinding.FragmentRegisterBinding
import com.example.kopidannyemil.viewmodel.MainViewModel

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etFullNameRegister.doOnTextChanged { _, _, _, _ -> binding.tilFullNameRegister.error = null }
        binding.etUsernameRegister.doOnTextChanged { _, _, _, _ -> binding.tilUsernameRegister.error = null }
        binding.etPasswordRegister.doOnTextChanged { _, _, _, _ -> binding.tilPasswordRegister.error = null }

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullNameRegister.text.toString().trim()
            val username = binding.etUsernameRegister.text.toString().trim()
            val password = binding.etPasswordRegister.text.toString().trim()

            var isValid = true

            if (fullName.isEmpty()) {
                binding.tilFullNameRegister.error = "Nama lengkap tidak boleh kosong"
                isValid = false
            }
            if (username.isEmpty()) {
                binding.tilUsernameRegister.error = "Username tidak boleh kosong"
                isValid = false
            }
            if (password.isEmpty()) {
                binding.tilPasswordRegister.error = "Password tidak boleh kosong"
                isValid = false
            }

            if (isValid) {
                viewModel.setUserName(fullName)

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