package br.com.marcelo_neuro.easyaddress.data

import br.com.marcelo_neuro.easyaddress.data.api.RetrofitClient
import br.com.marcelo_neuro.easyaddress.data.model.Endereco
import retrofit2.Response

class EnderecoRepository {

    private val api = RetrofitClient.instance

    suspend fun getCep(cep: String): Response<Endereco> = api.getCep(cep)
    suspend fun getAll(): Response<List<Endereco>> = api.getEndercos()
    suspend fun create(address: Endereco): Response<Endereco> = api.criarEndereco(address)
    suspend fun update(id: Int, address: Endereco): Response<Endereco> = api.atualizarEndereco(id, address)
    suspend fun delete(id: Int): Response<Unit> = api.apagarEndereco(id)

}