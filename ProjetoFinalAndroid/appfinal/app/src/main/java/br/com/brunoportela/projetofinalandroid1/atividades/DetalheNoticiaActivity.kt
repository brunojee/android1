package br.com.brunoportela.projetofinalandroid1.atividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoportela.projetofinalandroid1.R
import br.com.brunoportela.projetofinalandroid1.vo.ItemListagemPrincipalVO
import kotlinx.android.synthetic.main.activity_detalhe_noticia.*

class DetalheNoticiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_noticia)

        botaoFecharDetalhe.setOnClickListener {
            finish()
        }

        carregarNotifica();
    }

    fun carregarNotifica(){
        val noticia = intent.extras.get("itemNoticia") as ItemListagemPrincipalVO


        if(noticia == null){
            finish()
        } else {

            titulo.setText(noticia.titulo)
            descricao.setText(noticia.descricao)
            if(noticia.imagem != null){
                imagem.setImageResource(noticia.imagem!!)
            }
        }
    }
}
