package br.com.brunoportela.projetofinalandroid1.atividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoIrLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
        }

        botaoIrNovoUsuario.setOnClickListener{
            val intent = Intent(this, NovoUsuarioActivity::class.java )
            startActivity(intent)
        }

        botaoIrEsqueciSenha.setOnClickListener {
            val intent = Intent(this, RedefinirSenhaActivity::class.java )
            startActivity(intent)
        }
    }
}
