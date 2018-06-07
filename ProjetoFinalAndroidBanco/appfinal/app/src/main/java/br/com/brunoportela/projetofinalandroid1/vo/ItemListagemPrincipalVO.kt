package br.com.brunoportela.projetofinalandroid1.vo

import java.io.Serializable

class ItemListagemPrincipalVO : Serializable {

    var titulo: String? = null
    var descricao: String? = null
    var imagem: Int? = null

    constructor(titulo: String, descricao: String, imagem : Int) {
        this.titulo = titulo
        this.descricao = descricao
        this.imagem = imagem
    }
}