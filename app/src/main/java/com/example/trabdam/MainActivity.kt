package com.example.trabdam

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabdam.databinding.ActivityMainBinding
import org.example.Personagem
import org.example.racas.AltoElfo
import org.example.racas.AnaoColina
import org.example.racas.AnaoMontanha
import org.example.racas.Draconato
import org.example.racas.ElfoDrow
import org.example.racas.ElfoFloresta
import org.example.racas.GnomoFloresta
import org.example.racas.GnomoRochas
import org.example.racas.HalflingPesLeves
import org.example.racas.HalflingRobusto
import org.example.racas.Humano
import org.example.racas.MeioElfo
import org.example.racas.MeioOrc
import org.example.racas.Tiefling
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    val racasList = arrayOf(
        "1 - Alto Elfo",
        "2 - Elfo Floresta",
        "3 - Elfo Drow",
        "4 - Anao Colina",
        "5 - Anao Montanha",
        "6 - Draconato",
        "7 - Gnomo Floresta",
        "8 - Gnomo Rochas",
        "9 - Halfling PesLeves",
        "10 - Halfling Robusto",
        "11 - Humano",
        "12 - Meio Elfo",
        "13 - Meio Orc",
        "14 - Tiefling"
    )

    lateinit var listView: ListView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // config inicial
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonVoltar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // config botao salvar
        binding.buttonSal.setOnClickListener {
            var nome = binding.editTextNome.text.toString()
            var racaString = binding.editTextRaca.text.toString()

            if (nome.isEmpty() || racaString.isEmpty()) {
                Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val raca: Int = try {
                racaString.toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Digite um número válido para a raça", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(raca !in 1..14){
                Toast.makeText(this, "Escolha uma raça entre 1 e 14", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            var personagem: Personagem = when (raca) {
                1 -> Personagem(AltoElfo())
                2 -> Personagem(ElfoFloresta())
                3 -> Personagem(ElfoDrow())
                4 -> Personagem(AnaoColina())
                5 -> Personagem(AnaoMontanha())
                6 -> Personagem(Draconato())
                7 -> Personagem(GnomoFloresta())
                8 -> Personagem(GnomoRochas())
                9 -> Personagem(HalflingPesLeves())
                10 -> Personagem(HalflingRobusto())
                11 -> Personagem(Humano())
                12 -> Personagem(MeioElfo())
                13 -> Personagem(MeioOrc())
                14 -> Personagem(Tiefling())
                else -> Personagem(Humano())
            }

            personagem.nome = nome
            val intent = Intent(this, SegundaTelaActivity::class.java)
            intent.putExtra("PersonagemInfos", personagem)
            startActivity(intent)
            }



        // config pra listView
        listView = findViewById(R.id.customListView)
        val customBaseAdapter = CustomBaseAdapter(applicationContext, racasList)
        listView.adapter = customBaseAdapter


    }
}