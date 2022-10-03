package com.example.daltonismopat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import com.example.daltonismopat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val setTeste1Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            binding.apply {
                testeDaltonismo.resp1 = result.data!!.getIntExtra("VALOR_DIGITADO", 0).toString()
                invalidateAll()
            }
        }else{
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
    }

    val setTeste2Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            binding.apply {
                testeDaltonismo.resp2 = result.data!!.getIntExtra("VALOR_DIGITADO", 0).toString()
                invalidateAll()
            }
        }else{
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
    }

    val setTeste3Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            binding.apply {
                testeDaltonismo.resp3 = result.data!!.getIntExtra("VALOR_DIGITADO", 0).toString()
                //textViewResposta3.text = result.data!!.getIntExtra("VALOR_DIGITADO", 0).toString()
                invalidateAll()
            }
        }else{
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
    }

    lateinit var binding: ActivityMainBinding

    var testeDaltonismo: TesteDaltonismo = TesteDaltonismo("", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.testeD = testeDaltonismo

        binding.buttonTeste1.setOnClickListener{
            val intent = Intent(this, TesteActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putInt("idImagem", R.drawable.teste1)
            bundle.putString("valorDigitado", testeDaltonismo.resp1)
            intent.putExtras(bundle)

            setTeste1Launcher.launch(intent)
        }

        binding.buttonTeste2.setOnClickListener{
            val intent = Intent(this, TesteActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putInt("idImagem", R.drawable.teste2)
            bundle.putString("valorDigitado", testeDaltonismo.resp2)
            intent.putExtras(bundle)

            setTeste2Launcher.launch(intent)
        }

        binding.buttonTeste3.setOnClickListener{
            val intent = Intent(this, TesteActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putInt("idImagem", R.drawable.teste3)
            bundle.putString("valorDigitado", testeDaltonismo.resp3)
            intent.putExtras(bundle)

            setTeste3Launcher.launch(intent)
        }

        binding.buttonVerificar.setOnClickListener{
            //apply está trabalhando com a tela testeD
            binding.apply{
                if(testeD!!.resp1 == "29" || testeD!!.resp2 == "74" || testeD!!.resp3 == "8"){
                    textViewResultado.text = "Você não é daltônico!"
                }else{
                    textViewResultado.text = "Procure um oftomologista!"
                }
                //buttonVerificar.text = "Resultado do Teste"
                invalidateAll()
            }
            //Toast.makeText(this, binding.editTextNome.text.toString(), Toast.LENGTH_SHORT).show()
            //Log.i("Daltonismo", binding.testeD.toString())
        }

    }
}
