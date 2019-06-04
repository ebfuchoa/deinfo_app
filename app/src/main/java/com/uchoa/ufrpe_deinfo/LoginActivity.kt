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

import android.app.ProgressDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"

    //Variáveis globais
    private var email:String? = null
    private var senha:String? = null

    //Elementos da Interface UI
    private var tvEsqueceuSenha: TextView? = null
    private var etEmail: TextView? = null
    private var etSenha: TextView? = null
    private var btnLogin: TextView? = null
    private var btnCriarConta: TextView? = null
    private var mProgressoBar: ProgressDialog? = null

    //Referências ao Banco de dados
    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //verifica apenas a versão do android é superior a do Lollipop, caso seja, não precisa mudar a cor.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.setStatusBarColorTo(R.color.colorPrimary)
        }

        //Função de início
        inicializar()
    }


    /*
        Função cujo objetivo é de mudar a cor da status barras do android, onde fica as informações de hora e bateria

     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun Window.setStatusBarColorTo(color: Int){
        this.clearFlags(android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.statusBarColor = ContextCompat.getColor(baseContext, color)
    }

    private fun inicializar(){
        tvEsqueceuSenha = findViewById(R.id.tv_esqueceu_sua_senha) as TextView
        etEmail         = findViewById(R.id.et_email) as EditText
        etSenha         = findViewById(R.id.et_senha) as EditText
        btnLogin        = findViewById(R.id.btn_login) as Button
        btnCriarConta   = findViewById(R.id.btn_registrar_conta) as Button
        mProgressoBar   = ProgressDialog(this)

        mAuth           = FirebaseAuth.getInstance()

        tvEsqueceuSenha!!.setOnClickListener{startActivity(Intent(this@LoginActivity, EsqueceuSenhaActivity::class.java))}

        btnLogin!!.setOnClickListener { startActivity(Intent(this@LoginActivity, PrincipalActivity::class.java)) }

        btnCriarConta!!.setOnClickListener { startActivity(Intent(this@LoginActivity, CriarContaActivity::class.java)) }

        btnLogin!!.setOnClickListener { loginUsuario()}
    }


    private fun loginUsuario(){
        email = etEmail?.text.toString()
        senha = etSenha?.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(senha)){
            mProgressoBar!!.setMessage("Verificando o usuário...")
            mProgressoBar!!.show()

            Log.d(TAG, "Login do usuário")

            mAuth!!.signInWithEmailAndPassword(email!!, senha!!).addOnCompleteListener(this){
                task ->

                mProgressoBar!!.hide()

                //Autenticando o usuário, atualizando Ui com as informações do login
                if(task.isSuccessful){
                    Log.d(TAG, "Logado com sucesso!")
                    updateUi()
                }else{
                    Log.d(TAG, "Erro ao logar", task.exception)
                    Toast.makeText(this@LoginActivity, "Falha na autenticação", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this, "Entre com mais detalhes", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUi(){
        val intent = Intent(this@LoginActivity, PrincipalActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
