package br.com.brunoportela.projetofinalandroid1.database

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

class ConexaoBanco {
    companion object {


        fun obterConexao(applicationContext: Context) : AppDatabase {
            return Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "banco-final"
            ).allowMainThreadQueries().build()
        }

    }
}