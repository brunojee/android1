package br.com.brunoportela.projetofinalandroid1.service

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import android.content.Context
import br.com.brunoportela.projetofinalandroid1.database.ConexaoBanco
import br.com.brunoportela.projetofinalandroid1.entidades.Usuario

class UsuarioService {

    fun inserirUsuario(u: Usuario, applicationContext: Context){
        val conexao = ConexaoBanco.obterConexao(applicationContext)
        conexao.usuarioDao().inserirUsuario(u)
    }

    fun atualizarUsuario(u: Usuario, applicationContext: Context){
        val conexao = ConexaoBanco.obterConexao(applicationContext)
        conexao.usuarioDao().atualizarUsuario(u)
    }

    fun obterUsuario(email:String, applicationContext: Context): Usuario {
        val conexao = ConexaoBanco.obterConexao(applicationContext)
        return conexao.usuarioDao().obterUsuario(email)
    }

    fun obterUsuarioPorId(idUsuario:Int, applicationContext: Context): Usuario {
        val conexao = ConexaoBanco.obterConexao(applicationContext)
        return conexao.usuarioDao().obterUsuarioPorId(idUsuario)
    }

    fun loginUsuario(email:String, senha:String, applicationContext: Context): Usuario {
        val conexao = ConexaoBanco.obterConexao(applicationContext)
        return conexao.usuarioDao().loginUsuario(email, senha)
    }


}