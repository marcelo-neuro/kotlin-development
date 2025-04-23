package com.example.geradorsenha_jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.fragment.findNavController
import com.example.geradorsenha_jetpacknavigation.databinding.FragmentFirstBinding
import com.example.geradorsenha_jetpacknavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    private var tamanho = 8
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container,
            false)

        binding.seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress:
            Int, fromUser: Boolean) {
                tamanho = progress.coerceAtLeast(4)
                binding.tvTamanho.text = "Tamanho da senha: $tamanho"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        binding.btnConfirmar.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(tamanho)
            findNavController().navigate(action)

        }
        return binding.root
    }
}