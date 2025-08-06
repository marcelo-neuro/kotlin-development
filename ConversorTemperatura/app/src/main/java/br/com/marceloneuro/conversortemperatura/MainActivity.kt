package br.com.marceloneuro.conversortemperatura

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.marceloneuro.conversortemperatura.conversor.ConversorTemperatura
import br.com.marceloneuro.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val conversorDeTemperatura = ConversorTemperatura()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener {
            val temp = binding.etTemperature.text.toString().toDoubleOrNull()
            if(temp != null) {
                val result = if (binding.rbCelsius.isChecked) {
                    conversorDeTemperatura.celsius2Fahrenheit(temp)
                } else {
                    conversorDeTemperatura.fahrenheit2celsius(temp)
                }
                binding.tvResult.text = "$result"
            } else {
                binding.tvResult.text = "-"
                binding.etTemperature.setError("Digite um número válido")
            }
        }
    }

}