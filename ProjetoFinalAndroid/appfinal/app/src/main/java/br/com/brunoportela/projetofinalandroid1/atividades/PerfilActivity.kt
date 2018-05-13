package br.com.brunoportela.projetofinalandroid1.atividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import br.com.brunoportela.projetofinalandroid1.database.ConexaoBanco
import br.com.brunoportela.projetofinalandroid1.util.Utilitarios
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // ####### Validando usuário Logado ##################
        val idUsuario = Utilitarios.validarUsuarioLogado(intent)
        if(idUsuario == null){
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
        }
        // ###################################################


        val usuario = ConexaoBanco.obterConexao(applicationContext).usuarioDao().obterUsuarioPorId(idUsuario!!)

        email.setText(usuario.email)
        nome.setText(usuario.nome)
        matricula.setText(usuario.matricula)
        telefone.setText(usuario.telefone)





        botaoSalvarPerfil.setOnClickListener{


            val campos = HashMap<String, String>()
            campos.put("nome",             nome.text.toString())
            campos.put("senha",             senha.text.toString())
            campos.put("senhaConfirmacao",  senhaConfirmacao.text.toString())
            campos.put("matricula",         matricula.text.toString())
            campos.put("telefone",          telefone.text.toString())

            try {
                validarCampos(campos)

                val usuarioBanco = ConexaoBanco.obterConexao(applicationContext).usuarioDao().obterUsuarioPorId(idUsuario)

                usuarioBanco.nome       = campos.get("nome") as String
                usuarioBanco.matricula  = campos.get("matricula") as String
                usuarioBanco.telefone   = campos.get("telefone") as String

                ConexaoBanco.obterConexao(applicationContext).usuarioDao().atualizarUsuario(usuarioBanco)

                this.finish()


                val intent = Utilitarios.novaIntent(this, PrincipalActivity::class.java, idUsuario!!)
                startActivity(intent)


                Utilitarios.mostrarMensagem(this, "Dados salvos com sucesso")


            }catch (ex : Exception){
                Utilitarios.mostrarMensagem(this, ex.message!!)
            }

        }
    }


    fun validarCampos(campos : HashMap<String, String>) {


        if (campos == null) {
            throw Exception("Parâmetro inválido")
        } else {
            val senha            = campos.get("senha") as String;
            val senhaConfirmacao = campos.get("senhaConfirmacao")as String;

            if (senha != null && senha.length > 0) {


                // Validar email já existente


                if (senha.length < 6) {
                    throw Exception("A senha deverá conter no mínimo 6 caracteres")
                }

                // Validar se existe uma letra maiúscula

                // Validar caractere especial

                // Validar numero


                if (!senha.equals(senhaConfirmacao)) {
                    throw Exception("As senhas estão diferentes")
                }
            }

        }
    }
}
