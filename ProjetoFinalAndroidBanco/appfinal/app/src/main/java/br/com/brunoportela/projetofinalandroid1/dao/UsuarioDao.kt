package br.com.brunoportela.projetofinalandroid1.dao

import android.arch.persistence.room.*
import br.com.brunoportela.projetofinalandroid1.entidades.Usuario

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirUsuario(u: Usuario)

    @Update
    fun atualizarUsuario(u: Usuario)

    @Query("SELECT * FROM usuario WHERE email = :email LIMIT 1")
    fun obterUsuario(email:String): Usuario

    @Query("SELECT * FROM usuario WHERE idUsuario = :idUsuario LIMIT 1")
    fun obterUsuarioPorId(idUsuario:Int): Usuario

    @Query("SELECT * FROM usuario WHERE email = :email AND senha = :senha LIMIT 1")
    fun loginUsuario(email:String, senha:String): Usuario
}