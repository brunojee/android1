package br.com.brunoportela.projetofinalandroid1.util

import android.app.Activity
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.content.Intent
import android.widget.Toast
import br.com.brunoportela.projetofinalandroid1.database.AppDatabase
import java.util.regex.Pattern
import android.view.Gravity
import br.com.brunoportela.projetofinalandroid1.atividades.LoginActivity


class Utilitarios {
    companion object {
        fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }

        fun mostrarMensagem(applicationContext : Context, texto : String) {
            val toast = Toast.makeText(applicationContext, texto, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }

        private val INTENT_USER_ID = "user_id"

        fun novaIntent(context: Context, classe : Class<*>, idUsuario : Int): Intent {
            val intent = Intent(context, classe)
            intent.putExtra(INTENT_USER_ID, idUsuario)
            return intent
        }


        fun validarUsuarioLogado(intent : Intent): Int? {
            val retorno = intent.extras.get(INTENT_USER_ID)

            if(retorno == null){
                return null
            }

            return retorno as Int?
        }

        /**
        fun novaIntentAutenticada(context: Context, intent : Intent): Intent {
            val retorno = intent.extras.get(INTENT_USER_ID)

            if(retorno == null){
                return Intent(context, LoginActivity::class.java)
            }

            intent.putExtra(INTENT_USER_ID, retorno as Int)
            return intent
        }
        **/

    }
}