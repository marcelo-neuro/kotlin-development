package br.com.marcelo_neuro.easyaddress.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marcelo_neuro.easyaddress.data.model.Endereco
import br.com.marcelo_neuro.easyaddress.databinding.ItemEnderecoBinding

class MainListAddressAdapter(
    private var items: List<Endereco>,
    private val onEdit: (Endereco) -> Unit,
    private val onDelete: (Endereco) -> Unit
) : RecyclerView.Adapter<MainListAddressAdapter.AddressViewHolder>() {

    class AddressViewHolder(val binding: ItemEnderecoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddressViewHolder {
        val binding =
            ItemEnderecoBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        return AddressViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AddressViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.txtUserName.text = item.nomeUsuario
        holder.binding.txtAddress.text =
            "${item.logradouro},${item.bairro}, ${item.cidade} - ${item.uf}"
        holder.binding.txtTipo.text = "Tipo: ${item.tipo}"
        holder.binding.btnEdit.setOnClickListener {
            onEdit(item)
        }
        holder.binding.btnDelete.setOnClickListener {
            onDelete(item)
        }
    }

    override fun getItemCount() = items.size
    fun updateData(newItems: List<Endereco>) {
        items = newItems
        notifyDataSetChanged()
    }

}