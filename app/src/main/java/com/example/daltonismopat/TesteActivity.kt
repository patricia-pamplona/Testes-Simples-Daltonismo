package com.example.daltonismopat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.daltonismopat.databinding.ActivityMainBinding
import com.example.daltonismopat.databinding.ActivityTesteBinding

class TesteActivity : AppCompatActivity() {

    lateinit var binding: ActivityTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pegando valores recebidos como parâmetros
        val params = intent.extras
        val idImagem = params?.getInt("idImagem")
        val valorDigitado = params?.getString("valorDigitado")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)

        if (idImagem != null) {
            binding.imageView.setImageResource(idImagem)
        }

        //valor de entrada do valor a ser digitado, inicializado acima no oncreate
        if(valorDigitado != null){
            binding.editTextValor.setText(valorDigitado)
        }

        binding.buttonOk.setOnClickListener{
            val intent = Intent()
            val bundle = Bundle()

            bundle.putInt("VALOR_DIGITADO", binding.editTextValor.text.toString().toInt())
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            onBackPressed()
        }

        binding.buttonCancelar.setOnClickListener{

            setResult(RESULT_CANCELED)
            onBackPressed()
        }


    }
}