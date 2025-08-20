package br.com.marcelo_neuro.easyaddress.data.model

data class Endereco(
    val id: Int? = null,
    val nomeUsuario: String,
    val cep: String,
    val logradouro: String? = null,
    val numero: String? = null,
    val bairro: String? = null,
    val cidade: String? = null,
    val uf: String? = null,
    val tipo: String
) {
}