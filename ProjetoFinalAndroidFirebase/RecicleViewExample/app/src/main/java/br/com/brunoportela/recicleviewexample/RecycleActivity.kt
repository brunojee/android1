package br.com.brunoportela.recicleviewexample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class RecycleActivity : AppCompatActivity() {

    lateinit var lista : RecyclerView
    var dados : MutableList<Aluno> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)


        val y = Aluno()
        y.nome = "Joao"
        y.matricula = "123"

        dados.add(y)



        val x = Aluno()
        x.nome = "Maria"
        x.matricula = "899"

        dados.add(x)

        val adpt = AdaptadorAluno(this)

        lista = findViewById(R.id.recView)
        lista.itemAnimator = DefaultItemAnimator()
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adpt

    }

    inner class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtNomeAluno : TextView
        var txtMatriculaAluno : TextView


        init {
            txtNomeAluno = itemView.findViewById(R.id.txtNome)
            txtMatriculaAluno = itemView.findViewById(R.id.txtMatricula)
        }
    }

    inner class AdaptadorAluno (private val cxt: Context) : RecyclerView.Adapter<AlunoViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
            val v = LayoutInflater.from(cxt).inflate(R.layout.content_recycle, parent, false)
            return AlunoViewHolder(v)
        }

        override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
            val x = dados[position]
            holder.txtNomeAluno.text = x.nome
            holder.txtMatriculaAluno.text = x.matricula
        }

        override fun getItemCount(): Int {
            return dados.size
        }

    }

}
