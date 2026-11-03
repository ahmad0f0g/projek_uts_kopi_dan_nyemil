package com.example.kopidannyemil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kopidannyemil.MenuItem
import com.example.kopidannyemil.R
import java.text.NumberFormat
import java.util.Locale

class MainViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>("Pengguna")
    val userName: LiveData<String> = _userName

    private val _menuList = MutableLiveData<List<MenuItem>>()
    val menuList: LiveData<List<MenuItem>> = _menuList

    init {
        loadDummyMenu()
    }

    fun setUserName(name: String) {
        if (name.isNotBlank()) {
            _userName.value = name
        }
    }

    private fun loadDummyMenu() {
        val items = listOf(
            MenuItem("Kopi Susu Gula Aren", "Espresso segar dengan campuran susu cair dan gula aren murni", 22000, R.drawable.kopi_susu_gula_aren),
            MenuItem("Cappuccino", "Espresso khas dipadu dengan lapisan foam susu tebal", 25000, R.drawable.cappucino),
            MenuItem("Matcha Latte", "Teh hijau matcha Jepang dipadukan dengan susu hangat", 24000, R.drawable.matcha_latte),
            MenuItem("Donat Cokelat", "Donat kentang lembut topping meses cokelat melimpah", 12000, R.drawable.donat_coklat),
            MenuItem("Croissant Butter", "Kue pastry renyah dengan aroma mentega gurih", 18000, R.drawable.croissant_butter)
        )
        _menuList.value = items
    }

    // Format harga otomatis menjadi Rupiah (misal: Rp 22.000)
    fun formatRupiah(number: Int): String {
        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        numberFormat.maximumFractionDigits = 0
        return numberFormat.format(number).replace("Rp", "Rp ")
    }
}