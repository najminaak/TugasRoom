package com.example.tugasretrofit.model

data class Pesantren(
    val id: Int,
    val nama: String,
    val nspp: String,
    val alamat: String,
    val kyai: String,
    val kab_kota: KabKota,
    val provinsi: Provinsi
)

data class KabKota(
    val id: String,
    val nama: String
)

data class Provinsi(
    val id: String,
    val nama: String
)
