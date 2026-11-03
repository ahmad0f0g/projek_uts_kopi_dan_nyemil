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
import com.example.kopidannyemil.databinding.FragmentOrderBinding
import com.example.kopidannyemil.viewmodel.MainViewModel

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etOrderName.doOnTextChanged { _, _, _, _ -> binding.tilOrderName.error = null }
        binding.etOrderAddress.doOnTextChanged { _, _, _, _ -> binding.tilOrderAddress.error = null }
        binding.etOrderBenchmark.doOnTextChanged { _, _, _, _ -> binding.tilOrderBenchmark.error = null }

        binding.btnSubmitOrder.setOnClickListener {
            val name = binding.etOrderName.text.toString().trim()
            val address = binding.etOrderAddress.text.toString().trim()
            val benchmark = binding.etOrderBenchmark.text.toString().trim()

            var isValid = true

            if (name.isEmpty()) {
                binding.tilOrderName.error = "Nama lengkap wajib diisi"
                isValid = false
            }
            if (address.isEmpty()) {
                binding.tilOrderAddress.error = "Alamat lengkap wajib diisi"
                isValid = false
            }
            if (benchmark.isEmpty()) {
                binding.tilOrderBenchmark.error = "Patokan wajib diisi"
                isValid = false
            }

            if (isValid) {
                viewModel.setUserName(name)

                // Hapus halaman Order dari backstack agar tidak kembali saat menekan tombol back
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.navigation_order, true)
                    .build()
                findNavController().navigate(R.id.confirmationFragment, null, navOptions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}