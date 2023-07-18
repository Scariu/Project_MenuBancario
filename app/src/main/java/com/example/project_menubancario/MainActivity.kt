package com.example.project_menubancario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project_menubancario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonListo.setOnClickListener {
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.radioButtonVerSaldo ->
                    binding.editTextMonto.setText(saldo.toString())
                R.id.radioButtonIngresar -> ingresarSaldo()
                R.id.radioButtonRetirar -> retirarSaldo()
                R.id.radioButtonSalir -> finish()
            }
        }
    }

    private fun retirarSaldo() {
        saldo -= binding.editTextMonto.text.toString().toInt()
        mostrarMensaje("Su saldo ha sido retirado correctamente.")
    }

    private fun ingresarSaldo() {
        saldo += binding.editTextMonto.text.toString().toInt()
        mostrarMensaje("Su saldo ha sido ingresado correctamente.")
    }

    private fun mostrarMensaje(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
    }
}

