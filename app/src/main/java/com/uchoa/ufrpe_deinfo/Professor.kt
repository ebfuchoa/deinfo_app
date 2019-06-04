package com.uchoa.ufrpe_deinfo

class Professor {
    var nome:  String?          = null
    var descricao:   String?    = null
    var resumo: String?         = null
    var linhaPesquisa: String?  = null
    var lattes: String?         = null
    var imagem:    Int?         = null

    constructor(nome: String, descricao: String, resumo: String, linhaPesquisa: String, lattes: String, imagem: Int){
        this.nome           = nome
        this.descricao      = descricao
        this.resumo         = resumo
        this.linhaPesquisa  = linhaPesquisa
        this.lattes         = lattes
        this.imagem         = imagem
    }
}