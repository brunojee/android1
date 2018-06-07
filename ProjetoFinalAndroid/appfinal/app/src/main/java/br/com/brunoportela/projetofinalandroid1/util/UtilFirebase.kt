package br.com.brunoportela.projetofinalandroid1.util

import com.google.firebase.auth.FirebaseAuthUserCollisionException


class UtilFirebase {
    companion object {
        fun validarExcecao(excecao : Exception): String {
            var saida : String = "Exceção não tratada! " + excecao?.message

            if(excecao is FirebaseAuthUserCollisionException){
                saida = "Usuário já existe"
            }

            return saida
        }
    }
}