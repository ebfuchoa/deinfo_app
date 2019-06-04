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
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class EsqueceuSenhaActivity : AppCompatActivity() {

    private val TAG = "EsqueceuSenhaActivity"

    //Elementos da Interface com o usuário
    private var etEmail: EditText? = null
    private var btnSubmit: Button? = null

    //Referência ao Firebase
    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueceu_senha)

        inicializar()
    }

    private fun inicializar(){
        etEmail   = findViewById(R.id.et_email) as EditText
        btnSubmit = findViewById(R.id.btn_submit)

        mAuth = FirebaseAuth.getInstance() // Instancia a instância de autenticação com o Firebase

        btnSubmit!!.setOnClickListener { enviarSenhaEmail() }
    }

    private fun enviarSenhaEmail(){
        val email = etEmail?.text.toString()

        if(!TextUtils.isEmpty(email)){
            mAuth!!.sendPasswordResetEmail(email).addOnCompleteListener{task ->
                if(task.isSuccessful){
                    val mensagem = "Email enviado"
                    Log.d(TAG, mensagem)
                    Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
                    atualizaInterface()
                }else{
                    Log.w(TAG, task.exception!!.message)
                    Toast.makeText(this, "Nenhum usuário encontrado com esse e-mail.", Toast.LENGTH_SHORT).show()
                }

            }
        }else{
            Toast.makeText(this, "Entre com um E-mail válido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun atualizaInterface(){
        val intent = Intent(this@EsqueceuSenhaActivity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
