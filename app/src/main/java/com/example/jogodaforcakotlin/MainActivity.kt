package com.example.jogodaforcakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.jogodaforcakotlin.facade.Fachada

class MainActivity : AppCompatActivity() {
    private lateinit var fachada: Fachada
    private lateinit var tvdica: TextView
    private lateinit var tvpalavra: TextView
    private lateinit var tvinfos: TextView
    private lateinit var botaozinho: Button
    private lateinit var entrada: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //implementação on create da sua super classe
        setContentView(R.layout.activity_main) // activity da pasta layout do res, o xml

        this.fachada = Fachada()
        fachada.Padrao()
        fachada.start()

        this.tvdica = findViewById(R.id.TextViewDica)
        this.tvdica.text = fachada.diquinha()

        tvpalavra = findViewById(R.id.textViewPalavra)
        this.tvpalavra.text = fachada.palavrota()

        tvinfos = findViewById(R.id.textViewinfos)
        tvinfos.text = fachada.infos()

        botaozinho = findViewById(R.id.clicador)

        entrada = findViewById(R.id.TextEntrada)

        botaozinho.setOnClickListener(cliqueBotao())
    }
    inner class cliqueBotao: View.OnClickListener {
        override fun onClick(p0: View?) {
            if (this@MainActivity.fachada.terminou()) {
                this@MainActivity.botaozinho.isEnabled = false
            }
            this@MainActivity.fachada.jogar(this@MainActivity.entrada.text.toString())
            this@MainActivity.tvpalavra.text = this@MainActivity.fachada.palavrota()
            this@MainActivity.tvinfos.text = this@MainActivity.fachada.infos()
        }
    }
}

// esse layout mostra como será a aplicação
//É possível alterar o layout de 3 formas: Code, Split e Design
//E nesse layout só vai ter uma tela em branco com "hello world"

