package br.com.brunoportela.projetofinalandroid1.atividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import br.com.brunoportela.projetofinalandroid1.database.ConexaoBanco
import br.com.brunoportela.projetofinalandroid1.util.Utilitarios
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        botaoIrAutenticar.setOnClickListener{

            val campos = HashMap<String, String>()
            campos.put("email",            nome.text.toString())
            campos.put("senha",            senha.text.toString())


            // Validando campos
            try {
                validarCampos(campos)

                val conexao = ConexaoBanco.obterConexao(applicationContext)


                // Verificar se ja existe o usuário
                val u = conexao.usuarioDao().loginUsuario(campos.get("email") as String, campos.get("senha") as String)

                if(u == null){
                    Utilitarios.mostrarMensagem(this, "Email/Senha inválidos")
                } else {
                    val intent = Utilitarios.novaIntent(this, PrincipalActivity::class.java, u.idUsuario)
                    startActivity(intent)
                }



            }catch (ex : Exception){
                Utilitarios.mostrarMensagem(this, ex.message!!)
            }




        }
    }


    fun validarCampos(campos : HashMap<String, String>)  {


        if(campos == null){
            throw Exception("Parâmetro inválido")
        } else {
            val email            = campos.get("email");
            val senha            = campos.get("senha");

            if(email == null || senha == null) {
                throw Exception("Preencha todos os campos")
            }

            if(!Utilitarios.isEmailValid(email)){
                throw Exception("Email inválido")
            }

            if(senha.length == 0){
                throw Exception("O campo senha é obrigatório")
            }

        }
    }

}
