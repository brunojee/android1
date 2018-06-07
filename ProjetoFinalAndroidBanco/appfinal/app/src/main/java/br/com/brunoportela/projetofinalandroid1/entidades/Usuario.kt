package br.com.brunoportela.projetofinalandroid1.entidades

import android.arch.persistence.room.*

@Entity(tableName = "usuario")
data class Usuario (
        @PrimaryKey(autoGenerate = true) var idUsuario: Int = 0,
        @ColumnInfo(name = "nome") var nome: String = "",
        @ColumnInfo(name = "email") var email: String = "",
        @ColumnInfo(name = "senha") var senha: String = "",
        @ColumnInfo(name = "matricula") var matricula: String = "",
        @ColumnInfo(name = "foto") var foto: String = "",
        @ColumnInfo(name = "telefone") var telefone: String = ""
)
