package br.com.brunoportela.projetofinalandroid1.atividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import br.com.brunoportela.projetofinalandroid1.database.ConexaoBanco
import br.com.brunoportela.projetofinalandroid1.entidades.Usuario
import br.com.brunoportela.projetofinalandroid1.service.UsuarioService
import br.com.brunoportela.projetofinalandroid1.util.UtilFirebase
import br.com.brunoportela.projetofinalandroid1.util.Utilitarios
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_novo_usuario.*

class NovoUsuarioActivity : AppCompatActivity() {

    var mOAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        mOAuth = FirebaseAuth.getInstance()

        botaoNovoUsuario.setOnClickListener {

            val campos = HashMap<String, String>()
            campos.put("email",            nome.text.toString())
            campos.put("senha",            senha.text.toString())
            campos.put("senhaConfirmacao", senhaConfirmacao.text.toString())


            // Validando campos
            try {
                validarCampos(campos)

                mOAuth?.let { auth ->

                    auth.createUserWithEmailAndPassword(campos.get("email") as String, campos.get("senha") as String).addOnCompleteListener({task ->

                        if(task.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java )
                            startActivity(intent)
                        } else {
                            Utilitarios.mostrarMensagem(this, UtilFirebase.validarExcecao(task.exception!!))
                        }


                    })
                }

               /* // Verificar se ja existe o usuário
                val u = UsuarioService().obterUsuario(campos.get("email") as String, applicationContext)

                if(u != null){
                    Utilitarios.mostrarMensagem(this, "Email já existe em nossa base")

                } else {
                    val usuario = Usuario()
                    usuario.email = campos.get("email") as String
                    usuario.senha = campos.get("senha") as String

                    UsuarioService().inserirUsuario(usuario, applicationContext)

                    Utilitarios.mostrarMensagem(this, "Usuário criado com sucesso!")

                    val intent = Intent(this, LoginActivity::class.java )
                    startActivity(intent)
                }*/

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
            val senhaConfirmacao = campos.get("senhaConfirmacao");

            if(email == null || senha == null || senhaConfirmacao == null) {
                throw Exception("Preencha todos os campos")
            }

            if(!Utilitarios.isEmailValid(email)){
                throw Exception("Email inválido")
            }

            // Validar email já existente


            if(senha.length == 0){
                throw Exception("O campo senha é obrigatório")
            }

            if(senha.length < 6){
                throw Exception("A senha deverá conter no mínimo 6 caracteres")
            }

            // Validar se existe uma letra maiúscula

            // Validar caractere especial

            // Validar numero


            if(!senha.equals(senhaConfirmacao)){
                throw Exception("As senhas estão diferentes")
            }




        }


    }




}
