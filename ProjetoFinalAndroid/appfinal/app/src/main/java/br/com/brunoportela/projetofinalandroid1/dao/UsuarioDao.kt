package br.com.brunoportela.projetofinalandroid1.dao

import android.arch.persistence.room.*
import br.com.brunoportela.projetofinalandroid1.entidades.Usuario

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirUsuario(evt: Usuario)

    @Update
    fun atualizarUsuario(evt: Usuario)

    @Query("SELECT * FROM usuario WHERE email = :email AND senha = :senha")
    fun obterUsuario(email:String, senha:String): Array<Usuario>

}