# ☕ Kopi dan Nyemil - Mobile Ordering Application

**Kopi dan Nyemil** adalah aplikasi pemesanan makanan dan minuman berbasis Android yang dibangun menggunakan bahasa pemrograman Kotlin. Aplikasi ini mengusung arsitektur modern *Single-Activity* dengan *Jetpack Navigation Component*, menggunakan *Shared ViewModel* untuk manajemen data lokal, serta dirancang dengan tampilan UI bertema khas *Royal Blue Dark* dan *Web Golden*.

---

## 📸 Screenshots Application

| Splash Screen | Sign Up / Auth | Login User | Register |
|:---:|:---:|:---:|:---:|
| `![Splash](screenshots/welcome.jpeg)` | `![Sign Up](screenshots/signup.png)` | `![Login](screenshots/login.png)` | `![Register](screenshots/registrasi.png)` |

| Home Menu | User Profile | Form Order | Konfirmasi Pesanan |
|:---:|:---:|:---:|:---:|
| `![Home](screenshots/home.png)` | `![Profile](screenshots/profile.png)` | `![Order](screenshots/order.png)` | `![Confirmation](screenshots/konfiramsi.png)` |

> *Catatan: Ganti path `screenshots/filename.png` di atas dengan direktori/link gambar screenshot aplikasi Anda.*

---

## ✨ Fitur Utama

1. **Alur Otentikasi & Navigasi Mulus:**
   - Halaman Splash/Welcome interaktif yang langsung dibersihkan dari *back stack* saat masuk ke modul otentikasi.
   - Pilihan masuk via Login User atau pendaftaran akun baru melalui Register.
   - Pembersihan riwayat (*pop up to inclusive*) agar pengguna tidak bisa kembali ke halaman otentikasi menggunakan tombol *back* fisik setelah berhasil masuk.

2. **Daftar Menu Interaktif (RecyclerView):**
   - Menampilkan daftar menu makanan dan minuman (Kopi Susu Gula Aren, Cappuccino, Matcha Latte, Donat Cokelat, Croissant Butter).
   - Format harga otomatis berstandar Rupiah (`Rp XX.XXX`).
   - Kartu menu bertema *Web Golden* dengan elevasi bayangan 3D dan ikon/foto khusus.

3. **Sinkronisasi Data Real-Time (Shared ViewModel):**
   - Perubahan nama akun pada halaman **Profile Setting** secara *real-time* memperbarui ucapan salam (*greeting*) di halaman **Home**.
   - Penggunaan satu wadah memori lokal (*Shared ViewModel*) tanpa dependensi *database* eksternal.

4. **Validasi Form & Kontrol Keyboard:**
   - Validasi pesan kesalahan (*error layout*) dinamis berwarna merah yang otomatis hilang saat pengguna mulai mengetik.
   - Penutupan *soft-keyboard* otomatis saat menekan tombol simpan profil.
   - Navigasi *keyboard* `actionNext` untuk mempermudah pengisian antar kolom.

5. **Form Pemesanan & Alur Checkout:**
   - Pengisian rincian alamat pengiriman, nama penerima, dan detail patokan lokasi.
   - Layar konfirmasi pesanan dengan indikator status OK statis dan tombol navigasi kembali ke Home.

---

## 🛠️ Teknologi & Pustaka yang Digunakan

* **Language:** Kotlin
* **Build System:** Gradle (Kotlin DSL - `build.gradle.kts`)
* **Minimum SDK:** API 24 (Android 7.0 Nougat)
* **Target SDK:** API 34 (Android 14)
* **Architecture Pattern:** Single-Activity Architecture dengan Multiple Fragments
* **Jetpack Components:**
  * **ViewBinding:** Akses *layout* XML secara aman tanpa `findViewById`.
  * **Navigation Component:** Pengelolaan *NavGraph*, *Fragment Container View*, dan navigasi antar layar terpusat.
  * **ViewModel & LiveData:** Pengelolaan status (*state management*) dan observasi data *real-time*.
* **UI Components:**
  * Material Design 3 (`Google Material Components`)
  * `RecyclerView` & `CardView`
  * `BottomNavigationView`
  * Custom XML Vector Drawables

---

## 🎨 Palet Warna & Tema

* **Primary Background:** Royal Blue Dark (`#00296B`)
* **Secondary / Accent:** Web Golden (`#FFD500`)
* **Status Icon:** Emerald Green (`#4CAF50`)
* **Force Dark Mode:** Diaktifkan secara penuh pada aplikasi.

---

## 🚀 Cara Menjalankan Aplikasi

### Prasyarat
* **Android Studio:** Hedgehog (2023.1.1) atau versi yang lebih baru.
* **JDK:** Version 17.
* **Perangkat / Emulator:** Android 7.0 (API Level 24) atau yang lebih baru.

### Langkah-Langkah Instalasinya

1. **Clone Repository:**
   ```bash
   git clone [https://github.com/username/kopi-dan-nyemil.git](https://github.com/username/kopi-dan-nyemil.git)
