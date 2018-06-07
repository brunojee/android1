package br.com.brunoportela.projetofinalandroid1.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.brunoportela.projetofinalandroid1.dao.UsuarioDao
import br.com.brunoportela.projetofinalandroid1.entidades.Usuario

@Database(entities = [(Usuario::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}