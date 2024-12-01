package com.example.tugasretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasretrofit.database.Bookmark
import com.example.tugasretrofit.databinding.ItemPesantrenBinding
import com.example.tugasretrofit.model.Pesantren

class PesantrenAdapter(private val pesantrenList: List<Pesantren>,
                       private val onAddBookmarkClicked: (Pesantren) -> Unit
) : RecyclerView.Adapter<PesantrenAdapter.PesantrenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesantrenViewHolder {
        val binding = ItemPesantrenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PesantrenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PesantrenViewHolder, position: Int) {
        val pesantren = pesantrenList[position]
        holder.bind(pesantren, onAddBookmarkClicked)
    }

    override fun getItemCount(): Int = pesantrenList.size

    class PesantrenViewHolder(private val binding: ItemPesantrenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pesantren: Pesantren, onAddBookmarkClicked: (Pesantren) -> Unit) {
            binding.tvNama.text = pesantren.nama
            binding.tvKyai.text = pesantren.kyai
            binding.tvAlamat.text = pesantren.alamat

            binding.btnAdd.setOnClickListener {
                onAddBookmarkClicked(pesantren)
            }
        }
    }
}
