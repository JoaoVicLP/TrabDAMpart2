package com.example.trabdam

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabdam.databinding.ActivitySegundaTelaBinding
import com.example.trabdam.databinding.ActivityTerceiraTelaBinding
import org.example.Personagem



class TerceiraTelaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTerceiraTelaBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTerceiraTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val personagem = intent.getSerializableExtra("PersonagemInfos2", Personagem::class.java)

            if (personagem != null) {
                val textoForca =
                    "${personagem.forc} (${personagem.modAtrForc}) (${personagem.raca.modRacaForc()})"
                val textoDestreza =
                    "${personagem.dest} (${personagem.modAtriDest}) (${personagem.raca.modRacaDest()})"
                val textoConstituicao =
                    "${personagem.cons} (${personagem.modAtriCons}) (${personagem.raca.modRacaCons()})"
                val textoInteligencia =
                    "${personagem.inte} (${personagem.modAtriInte}) (${personagem.raca.modRacaInte()})"
                val textoSabedoria =
                    "${personagem.sabe} (${personagem.modAtriSabe}) (${personagem.raca.modRacaSabe()})"
                val textoCarisma =
                    "${personagem.cari} (${personagem.modAtrCari}) (${personagem.raca.modRacaCari()})"


                binding.textViewNome.text = personagem.nome.toString()
                binding.textViewRaca.text = personagem.raca.serRaca().toString()
                binding.textViewPV.text = personagem.vida.toString()
                binding.textViewPF.text = textoForca.toString()
                binding.textViewPD.text = textoDestreza.toString()
                binding.textViewPCon.text = textoConstituicao.toString()
                binding.textViewPI.text = textoInteligencia.toString()
                binding.textViewPS.text = textoSabedoria.toString()
                binding.textViewPCar.text = textoCarisma.toString()
            } else {
                Toast.makeText(this, "VSF FDP", Toast.LENGTH_SHORT).show()

            }


    }
}