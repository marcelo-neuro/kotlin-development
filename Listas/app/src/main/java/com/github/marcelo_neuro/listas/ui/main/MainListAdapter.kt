package com.github.marcelo_neuro.listas.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.marcelo_neuro.listas.R
import com.github.marcelo_neuro.listas.data.ObraArte
import com.github.marcelo_neuro.listas.databinding.ObraDeArteItemBinding
import com.squareup.picasso.Picasso

class MainListAdapter(
    private val onClick: (ObraArte) -> Unit
) : RecyclerView.Adapter<MainListAdapter.ObraViewHolder> () {

    private var lista = listOf<ObraArte>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObraViewHolder {
        val binding = ObraDeArteItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ObraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObraViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount() = lista.size

    inner class ObraViewHolder(private val binding: ObraDeArteItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(obra: ObraArte) {
            binding.tvTitulo.text = obra.titulo
            binding.tvDescricao.text = obra.descricao
            Picasso.get()
                .load(obra.imagem)
                .error(R.drawable.erro)
                .placeholder(R.drawable.loading)
                .into(binding.ivObraDeArte)

            binding.root.setOnClickListener {
                onClick(obra)
            }
        }
    }


}