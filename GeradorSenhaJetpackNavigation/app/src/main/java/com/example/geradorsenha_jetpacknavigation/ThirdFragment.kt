package com.example.geradorsenha_jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.geradorsenha_jetpacknavigation.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container,
            false)

        val length = ThirdFragmentArgs.fromBundle(requireArguments()).tamanhoSenha
        val senha = gerarSenha(length)
        binding.tvSenha.text = "Senha gerada: \n$senha"

        return binding.root
    }

    private fun gerarSenha(tamanho: Int): String {
        val chars =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#\$%&*"
        return (1..tamanho).map { chars.random() }.joinToString("")
    }
}