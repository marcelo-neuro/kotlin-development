package br.com.marcelo_neuro.easyaddress.data.api

import br.com.marcelo_neuro.easyaddress.data.model.Endereco
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("cep/{cep}")
    suspend fun getCep(@Path("cep") cep: String): Response<Endereco>
    @GET("address")
    suspend fun getEndercos(): Response<List<Endereco>>
    @POST("address")
    suspend fun criarEndereco(@Body address: Endereco): Response<Endereco>
    @PUT("address/{id}")
    suspend fun atualizarEndereco(@Path("id") id: Int, address: Endereco): Response<Endereco>
    @DELETE("address/{id}")
    suspend fun apagarEndereco(@Path("id") id: Int): Response<Unit>
}