package br.com.marcelo_neuro.easyaddress.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.marcelo_neuro.easyaddress.R
import br.com.marcelo_neuro.easyaddress.databinding.ActivityMainBinding
import br.com.marcelo_neuro.easyaddress.databinding.ItemEnderecoBinding
import br.com.marcelo_neuro.easyaddress.ui.form.FormActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainListAddressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MainListAddressAdapter(
            listOf(),
            onEdit = { address ->
                // abrir formulário em modo edição
                val intent = Intent(
                    this,
                    FormActivity::class.java
                ).apply {
                    //putExtra(FormActivity.EXTRA_ADDRESS_ID, address.id)
                }
                startActivity(intent)
            },
            onDelete = {address -> address.id?.let { id-> viewModel.deleteAddress(id) }}
            )

        binding.recyclerViewAddresses.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAddresses.adapter = adapter
        binding.fabAddEndereco.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.state.collectLatest {
                state -> when (state) {
                    is UiState.Loading -> {

                    }
                is UiState.Success -> {
                    adapter.updateData(state.enderecos)
                }
                is UiState.Error -> {
                    Toast.makeText(this@MainActivity, state.mensagem, Toast.LENGTH_SHORT).show()
                }
            }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAddress()
    }
}