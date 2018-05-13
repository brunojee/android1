package br.com.brunoportela.projetofinalandroid1.atividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import br.com.brunoportela.projetofinalandroid1.util.Utilitarios
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        // ####### Validando usuário Logado ##################
        val idUsuario = Utilitarios.validarUsuarioLogado(intent)
        if(idUsuario == null){
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
        }
        // ###################################################






        botaoIrPerfil.setOnClickListener{









            val intent = Utilitarios.novaIntent(this, PerfilActivity::class.java, idUsuario!!)
            startActivity(intent)
        }
    }


}
