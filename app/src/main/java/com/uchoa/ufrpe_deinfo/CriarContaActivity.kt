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
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CriarContaActivity : AppCompatActivity() {

    //Elementos da Interface do Usuário
    private var etPrimeiroNome: EditText?      = null
    private var etSobrenome: EditText?         = null
    private var etEmail: EditText?             = null
    private var etSenha: EditText?             = null
    private var btnCriarConta: Button?         = null
    private var mProgressoBar: ProgressDialog? = null

    //Referências ao Banco de Dados
    private var mDataBaseReference: DatabaseReference? = null // Referência ao banco
    private var mDataBase: FirebaseDatabase?           = null // Instância do banco
    private var mAuth: FirebaseAuth?                   = null // Método de Autenticação

    //Valor de Tag
    private val TAG = "CriarContaActivity"

    //Variáveis globais
    private var primeiroNome: String? = null
    private var sobrenome: String?    = null
    private var email: String?        = null
    private var senha: String?        = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)

        inicializar()
    }

    private fun inicializar(){
        etPrimeiroNome = findViewById(R.id.et_primeiro_nome) as EditText
        etSobrenome    = findViewById(R.id.et_sobrenome) as EditText
        etEmail        = findViewById(R.id.et_email) as EditText
        etSenha        = findViewById(R.id.et_senha) as EditText
        btnCriarConta  = findViewById(R.id.btn_registrar_conta) as Button
        mProgressoBar  = ProgressDialog(this)

        //Declarar instâncias do Firebase
        mDataBase          = FirebaseDatabase.getInstance()
        mDataBaseReference = mDataBase!!.reference!!.child("Usuario")
        mAuth              = FirebaseAuth.getInstance()

        btnCriarConta!!.setOnClickListener { criarNovaConta() }

    }

    private fun criarNovaConta(){
        primeiroNome = etPrimeiroNome?.text.toString()
        sobrenome    = etSobrenome?.text.toString()
        email        = etEmail?.text.toString()
        senha        = etSenha?.text.toString()

        if(!TextUtils.isEmpty(primeiroNome) && !TextUtils.isEmpty(sobrenome)
            && !TextUtils.isEmpty(email)&& !TextUtils.isEmpty(senha)){

            Toast.makeText(this, "Informações preenchidas corretamente", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Entre com mais detalhes.", Toast.LENGTH_SHORT).show()
        }

        mProgressoBar!!.setMessage("Registrando usuário...")
        mProgressoBar!!.show()

        mAuth!!.createUserWithEmailAndPassword(email!!, senha!!).addOnCompleteListener(this){task ->
            mProgressoBar!!.hide()

            if(task.isSuccessful){
                Log.d(TAG, "CreateUserWithEmail:Sucess")

                val userId = mAuth!!.currentUser!!.uid

                //Após criar a conta, deve ser verificado o email
                verificarEmail()

                val currentUserDB = mDataBaseReference!!.child(userId)
                currentUserDB.child("primeiroNome").setValue(primeiroNome)
                currentUserDB.child("sobrenome").setValue(sobrenome)

                //Atualizar as informações no banco de dados
                atualizarUsuarioUI()

            }else{
                Log.w(TAG, "CreateUserWithEmail:Failure", task.exception)
                Toast.makeText(this@CriarContaActivity, "Autenticação falhou.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun atualizarUsuarioUI(){
        //iniciar a nova atividade
        val intent = Intent(this@CriarContaActivity, PrincipalActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verificarEmail(){
        val mUser = mAuth!!.currentUser
        mUser!!.sendEmailVerification().addOnCompleteListener(this){task ->
            if(task.isSuccessful){
                Toast.makeText(this@CriarContaActivity, "Verificação de email enviado para "+mUser.getEmail(),
                    Toast.LENGTH_SHORT).show()
            }else{
                Log.e(TAG, "sendEmailVerification", task.exception)
                Toast.makeText(this@CriarContaActivity, "Falha ao enviar a verificação de email.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
