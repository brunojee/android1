package br.com.brunoportela.projetofinalandroid1.atividades


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.brunoportela.projetofinalandroid1.R
import br.com.brunoportela.projetofinalandroid1.util.Utilitarios
import br.com.brunoportela.projetofinalandroid1.vo.ItemListagemPrincipalVO
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.activity_principal_listagem.view.*

class PrincipalActivity : AppCompatActivity() {

    val listaBanner  = listOf("#FF0000", "#0009FF", "#E600FF", "#00E6FF", "#00FF5E", "#FFFF00", "#FFAB00")
    var indiceBanner = 0

    var adapter: TabelaPrincipalAdapter? = null
    var listaNoticias = ArrayList<ItemListagemPrincipalVO>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        // ####### Validando usuário Logado ##################
        val idUsuario = Utilitarios.validarUsuarioLogado(intent)
        if(idUsuario == null){
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
        }
        // ###################################################




        // ######### LISTAGEM #############
        for (i in 1..1000){
            listaNoticias.add(ItemListagemPrincipalVO("Título " + i, "Descrição do item " + i, R.drawable.abc_ic_menu_overflow_material))
        }




        adapter = TabelaPrincipalAdapter(this, listaNoticias)

        listagemDinamica.adapter = adapter




        botaoIrPerfil.setOnClickListener{
            val intent = Utilitarios.novaIntent(this, PerfilActivity::class.java, idUsuario!!)
            startActivity(intent)
        }


        // Iniciar Banner
        rotacionarBanner();
    }


    class TabelaPrincipalAdapter : BaseAdapter {
        var itemList = ArrayList<ItemListagemPrincipalVO>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<ItemListagemPrincipalVO>) : super() {
            this.context = context
            this.itemList = foodsList
        }

        override fun getCount(): Int {
            return itemList.size
        }

        override fun getItem(position: Int): Any {
            return itemList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val item = this.itemList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.activity_principal_listagem, null)
            foodView.titulo.setText(item.titulo)
            foodView.detalhe.setText(item.descricao)
            //foodView.imagem.setImageResource(item.imagem!!)

            return foodView
        }
    }





    fun rotacionarBanner(){

        banner.setBackgroundColor(Color.parseColor(listaBanner.get(indiceBanner)))
        banner.setText("Banner " + (indiceBanner+1))

        if(indiceBanner >= listaBanner.size -1){
            indiceBanner = 0;
        } else {
            indiceBanner++;
        }

        Handler().postDelayed({
           rotacionarBanner()
        }, 5000)
    }







    override fun onBackPressed() {
        finish()
        System.exit(0);
    }


}
