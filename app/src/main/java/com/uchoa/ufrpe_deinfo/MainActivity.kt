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

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeToLogin()
    }

    fun changeToLogin(){
        val intent = Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 4000)
    }

    fun Intent.change(){
        startActivity(this)
        finish()
    }
}