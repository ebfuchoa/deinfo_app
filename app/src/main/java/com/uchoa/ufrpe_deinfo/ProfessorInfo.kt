package com.uchoa.ufrpe_deinfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_professor_info.*

class ProfessorInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professor_info)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.title = "Professor"

        val bundle: Bundle = intent.extras
        val nome = bundle.getString("nome")
        val descricao = bundle.getString("descricao")
        val imagem = bundle.getInt("imagem")

        ivProfessorImagem.setImageResource(imagem)
        tvNome.text = nome
        tvDescricao.text = descricao

    }
}
