package br.com.brunoportela.projetofinalandroid1.atividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        botaoIrAutenticar.setOnClickListener{
            val intent = Intent(this, PrincipalActivity::class.java )
            startActivity(intent)
        }
    }
}
