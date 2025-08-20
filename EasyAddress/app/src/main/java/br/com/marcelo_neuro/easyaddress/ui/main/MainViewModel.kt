package br.com.marcelo_neuro.easyaddress.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.marcelo_neuro.easyaddress.data.EnderecoRepository
import br.com.marcelo_neuro.easyaddress.data.model.Endereco
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UiState {
    object Loading : UiState()
    data class Success(val enderecos: List<Endereco>) : UiState()
    data class Error(val mensagem: String) : UiState()
}

class MainViewModel(private val repo: EnderecoRepository = EnderecoRepository()) : ViewModel() {
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state

    init {
        loadAddress()
    }

    fun loadAddress() {
        _state.value = UiState.Loading
        viewModelScope.launch {
            try {
                val resp = repo.getAll()
                if (resp.isSuccessful) {
                    _state.value = UiState.Success(resp.body() ?: emptyList())
                } else {
                    _state.value = UiState.Error("Erro: ${resp.code()}")
                }
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }

    fun deleteAddress(id: Int) {
        viewModelScope.launch {
            try {
                val resp = repo.delete(id)
                if (resp.isSuccessful) {
                    loadAddress()
                } else {
                    _state.value = UiState.Error("Erro ao deletar: ${resp.code()}")
                }
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}