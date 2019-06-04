/*
    Projeto DEINFO - UFRPE
    Esse projeto tem como objetivo mapear os orientando por orientador no Programa de Pós-Graduação
    em Informática Aplicada da Universidade Federal Rural de Pernambuco

    Disciplina: Fundamentos de Programação Aplicada - FPA
    Profº Gilberto
    Aluno: Eduardo Uchôa
    Ano: 2019.1
 */
package com.uchoa.ufrpe_deinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.professor_ticket.view.*

class PrincipalActivity : AppCompatActivity() {
    private val GILBERTO  = "GILBERTO AMADO DE AZEVEDO CYSNEIROS FILHO"
    private val TIAGO     = "TIAGO ALESSANDRO ESPÍNOLA FERREIRA"
    private val GUSTAVO   = "GUSTAVO RAU DE ALMEIDA CALLOU"
    private val ADENILTON   = "ADENILTON JOSÉ DA SILVA"
    private val FERNANDO   = "FERNANDO ANTONIO AIRES LINS"
    private val ERICA   = "ERICA TEIXEIRA GOMES DE SOUSA"
    private val GABRIEL   = "GABRIEL ALVES DE ALBUQUERQUE JUNIOR"
    var listaDeProfessores = ArrayList<Professor>()
    var adapter: ProfessorAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        //load professores
        listaDeProfessores.add(Professor(
            ProfessoresDAO.GILBERTO.nome, ProfessoresDAO.GILBERTO.descricao,
            ProfessoresDAO.GILBERTO.resumo, ProfessoresDAO.GILBERTO.linhaPesquisa, ProfessoresDAO.GILBERTO.lattes, R.mipmap.gilberto))

        listaDeProfessores.add(Professor(
            ProfessoresDAO.TIAGO.nome, ProfessoresDAO.TIAGO.descricao,
            ProfessoresDAO.TIAGO.resumo,
            ProfessoresDAO.TIAGO.linhaPesquisa, ProfessoresDAO.TIAGO.lattes, R.mipmap.tiago))

        listaDeProfessores.add(Professor(
            ProfessoresDAO.GUSTAVO.nome, ProfessoresDAO.GUSTAVO.descricao,
            ProfessoresDAO.GUSTAVO.resumo, ProfessoresDAO.GUSTAVO.linhaPesquisa, ProfessoresDAO.GUSTAVO.lattes, R.mipmap.gustavo))

        listaDeProfessores.add(Professor(
            ProfessoresDAO.ADENILTON.nome, ProfessoresDAO.ADENILTON.descricao,
            ProfessoresDAO.ADENILTON.resumo, ProfessoresDAO.ADENILTON.linhaPesquisa, ProfessoresDAO.ADENILTON.lattes, R.mipmap.adenilton))

        listaDeProfessores.add(Professor(
            ProfessoresDAO.FERNANDO.nome, ProfessoresDAO.FERNANDO.descricao,
            ProfessoresDAO.FERNANDO.resumo, ProfessoresDAO.FERNANDO.linhaPesquisa, ProfessoresDAO.FERNANDO.lattes, R.mipmap.fernando))

        listaDeProfessores.add(Professor(
            ProfessoresDAO.ERICA.nome, ProfessoresDAO.ERICA.descricao,
            ProfessoresDAO.ERICA.resumo, ProfessoresDAO.ERICA.linhaPesquisa, ProfessoresDAO.ERICA.lattes, R.mipmap.erica))

        listaDeProfessores.add(Professor(
            ProfessoresDAO.GABRIEL.nome, ProfessoresDAO.GABRIEL.descricao,
            ProfessoresDAO.GABRIEL.resumo, ProfessoresDAO.GABRIEL.linhaPesquisa, ProfessoresDAO.GABRIEL.lattes, R.mipmap.gabriel))

        adapter = ProfessorAdapter(this, listaDeProfessores)
        tvListProfessor.adapter = adapter
    }

    class ProfessorAdapter: BaseAdapter {
        var listaDeProfessores =  ArrayList<Professor>()
        var context: Context?= null

        constructor(context: Context, listaDeProfessores: ArrayList<Professor>):super(){
            this.listaDeProfessores = listaDeProfessores
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val professor = listaDeProfessores[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.professor_ticket, null)
            myView.tvNomeProf.text = professor.nome!!
            myView.tvResumo.text = professor.resumo!!
            myView.ivNomeImagem.setImageResource(professor.imagem!!)
            myView.ivNomeImagem.setOnClickListener {
                val intent = Intent(context, ProfessorInfo::class.java)
                intent.putExtra("nome", professor.nome!!)
                intent.putExtra("descricao", professor.descricao!!)
                intent.putExtra("imagem", professor.imagem!!)
                intent.putExtra("imagem", professor.imagem!!)
                context!!.startActivity(intent)
            }
            return myView
        }

        override fun getItem(position: Int): Any {
            return listaDeProfessores[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listaDeProfessores.size
        }

    }
}
