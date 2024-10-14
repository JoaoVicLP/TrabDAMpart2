package com.example.trabdam

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabdam.databinding.ActivitySegundaTelaBinding
import org.example.Personagem

class SegundaTelaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaTelaBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        // config inicial
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonVoltar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //config botao voltar
        binding.buttonVoltar.setOnClickListener {
            finish()
        }


        // variaveis de atributos
        var forca = binding.textViewForca.text.toString().toInt()
        var destreza = binding.textViewDestreza.text.toString().toInt()
        var constituicao = binding.textViewConstituicao.text.toString().toInt()
        var inteligencia = binding.textViewInteligencia.text.toString().toInt()
        var sabedoria = binding.textViewSabedoria.text.toString().toInt()
        var carisma = binding.textViewCarisma.text.toString().toInt()
        var valorTotal = binding.textViewTotal.text.toString().toInt()
        var limite = false
        val personagem = intent.getSerializableExtra("PersonagemInfos", Personagem::class.java)


        binding.buttonFinal.setOnClickListener{
            if (personagem != null && limite == true) {
                personagem.forc = forca
                personagem.dest = destreza
                personagem.cons = constituicao
                personagem.inte = inteligencia
                personagem.sabe = sabedoria
                personagem.cari = carisma
                personagem.setMods()
                personagem.setVida()
                val intent = Intent(this, TerceiraTelaActivity::class.java)
                intent.putExtra("PersonagemInfos2", personagem)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Use todos os pontos", Toast.LENGTH_SHORT).show()
            }
        }


        //config botoes menos
        binding.buttonLess1.setOnClickListener{
            forca -= 1
            valorTotal += 1
            if(forca >= 8) {
                salvarForca(forca, valorTotal)
                limite = false
            }else{
                forca = restituirForca()
                valorTotal = restituirTotal()
            }
        }
        binding.buttonLess2.setOnClickListener{
            destreza -= 1
            valorTotal += 1
            if(destreza >= 8) {
                salvarDestreza(destreza, valorTotal)
                limite = false
            }else{
                destreza = restituirDestreza()
                valorTotal = restituirTotal()

            }
        }
        binding.buttonLess3.setOnClickListener{
            constituicao -= 1
            valorTotal += 1
            if(constituicao >= 8) {
                salvarConstituicao(constituicao, valorTotal)
                limite = false
            }else{
                constituicao = restituirConstituicao()
                valorTotal = restituirTotal()
            }
        }
        binding.buttonLess4.setOnClickListener{
            inteligencia -= 1
            valorTotal += 1
            if(inteligencia >= 8) {
                salvarInteligencia(inteligencia, valorTotal)
                limite = false
            }else{
                inteligencia = restituirInteligencia()
                valorTotal = restituirTotal()
            }
        }
        binding.buttonLess5.setOnClickListener{
            sabedoria -= 1
            valorTotal += 1
            if(sabedoria >= 8) {
                salvarSabedoria(sabedoria, valorTotal)
                limite = false
            }else{
                sabedoria = restituirSabedoria()
                valorTotal = restituirTotal()
            }
        }
        binding.buttonLess6.setOnClickListener{
            carisma -= 1
            valorTotal += 1
            if(carisma >= 8) {
                salvarCarima(carisma, valorTotal)
                limite = false
            }else{
                carisma = restituirCarisma()
                valorTotal = restituirTotal()
            }
        }


        //config botao mais
        binding.buttonPlus1.setOnClickListener{
            if(limite != true) {
                forca += 1
                valorTotal -= 1
                if (forca <= 15) {
                    salvarForca(forca, valorTotal)
                    limite = verifcadorTotal(valorTotal)
                } else {
                    forca = restituirForca()
                    valorTotal = restituirTotal()
                }
            }
        }
        binding.buttonPlus2.setOnClickListener{
            if(limite != true) {
                destreza += 1
                valorTotal -= 1
                if (destreza <= 15) {
                    salvarDestreza(destreza, valorTotal)
                    limite = verifcadorTotal(valorTotal)
                } else {
                    destreza = restituirDestreza()
                    valorTotal = restituirTotal()
                }
            }
        }
        binding.buttonPlus3.setOnClickListener{
            if(limite != true) {
                constituicao += 1
                valorTotal -= 1
                if (constituicao <= 15) {
                    salvarConstituicao(constituicao, valorTotal)
                    limite = verifcadorTotal(valorTotal)
                } else {
                    constituicao = restituirConstituicao()
                    valorTotal = restituirTotal()
                }
            }
        }
        binding.buttonPlus4.setOnClickListener{
            if(limite != true) {
                inteligencia += 1
                valorTotal -= 1
                if (inteligencia <= 15) {
                    salvarInteligencia(inteligencia, valorTotal)
                    limite = verifcadorTotal(valorTotal)
                } else {
                    inteligencia = restituirInteligencia()
                    valorTotal = restituirTotal()
                }
            }
        }
        binding.buttonPlus5.setOnClickListener{
            if(limite != true) {
                sabedoria += 1
                valorTotal -= 1
                if (sabedoria <= 15) {
                    salvarSabedoria(sabedoria, valorTotal)
                    limite = verifcadorTotal(valorTotal)
                } else {
                    sabedoria = restituirSabedoria()
                    valorTotal = restituirTotal()
                }
            }
        }
        binding.buttonPlus6.setOnClickListener{
            if(limite != true) {
                carisma += 1
                valorTotal -= 1
                if (carisma <= 15) {
                    salvarCarima(carisma, valorTotal)
                    limite = verifcadorTotal(valorTotal)
                } else {
                    carisma = restituirCarisma()
                    valorTotal = restituirTotal()
                }
            }
        }

    }


    //funcoes

    fun verifcadorTotal(valorTotal: Int): Boolean{
        if(valorTotal == 0){
            return true
        }else{
            return false
        }
    }

    fun salvarTotal(valorTotal: Int){
        binding.textViewTotal.text = valorTotal.toString()
    }

    fun restituirTotal(): Int{
        var valorTotal = binding.textViewTotal.text.toString().toInt()
        return valorTotal
    }

    fun salvarCarima(carisma: Int, valorTotal: Int){
        binding.textViewCarisma.text = carisma.toString()
        salvarTotal(valorTotal)
    }

    fun restituirCarisma(): Int {
        var carisma = binding.textViewCarisma.text.toString().toInt()
        return carisma
    }
    fun salvarForca(forca: Int, valorTotal: Int) {
        binding.textViewForca.text = forca.toString()
        salvarTotal(valorTotal)
    }

    fun restituirForca(): Int {
        val forca = binding.textViewForca.text.toString().toInt()
        return forca
    }

    fun salvarDestreza(destreza: Int, valorTotal: Int) {
        binding.textViewDestreza.text = destreza.toString()
        salvarTotal(valorTotal)
    }

    fun restituirDestreza(): Int {
        val destreza = binding.textViewDestreza.text.toString().toInt()
        return destreza
    }

    fun salvarConstituicao(constituicao: Int, valorTotal: Int) {
        binding.textViewConstituicao.text = constituicao.toString()
        salvarTotal(valorTotal)
    }

    fun restituirConstituicao(): Int {
        val constituicao = binding.textViewConstituicao.text.toString().toInt()
        return constituicao
    }

    fun salvarInteligencia(inteligencia: Int, valorTotal: Int) {
        binding.textViewInteligencia.text = inteligencia.toString()
        salvarTotal(valorTotal)
    }

    fun restituirInteligencia(): Int {
        val inteligencia = binding.textViewInteligencia.text.toString().toInt()
        return inteligencia
    }

    fun salvarSabedoria(sabedoria: Int, valorTotal: Int) {
        binding.textViewSabedoria.text = sabedoria.toString()
        salvarTotal(valorTotal)
    }

    fun restituirSabedoria(): Int {
        val sabedoria = binding.textViewSabedoria.text.toString().toInt()
        return sabedoria
    }
}