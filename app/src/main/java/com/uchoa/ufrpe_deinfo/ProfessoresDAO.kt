package com.uchoa.ufrpe_deinfo

enum class ProfessoresDAO(val codigo:Int, val nome:String, val descricao:String, val resumo:String, val linhaPesquisa:String, val lattes:String) {

    GILBERTO(1,"GILBERTO AMADO DE AZEVEDO CYSNEIROS FILHO",
        getDescricaoProf(1),
        getResumo(1),
        getLinhaPesquisa(1),
        getLattes(1)
    ),

    TIAGO(2,"TIAGO ALESSANDRO ESPÍNOLA FERREIRA",
        getDescricaoProf(2),
        getResumo(2),
        getLinhaPesquisa(2),
        getLattes(2)
    ),

    GUSTAVO(3,"GUSTAVO RAU DE ALMEIDA CALLOU",
        getDescricaoProf(3),
        getResumo(3),
        getLinhaPesquisa(3),
        getLattes(3)
    ),

    ERICA(4,"ERICA TEIXEIRA GOMES DE SOUSA",
        getDescricaoProf(4),
        getResumo(4),
        getLinhaPesquisa(4),
        getLattes(4)
    ),

    FERNANDO(5,"FERNANDO ANTONIO AIRES LINS",
        getDescricaoProf(5),
        getResumo(5),
        getLinhaPesquisa(5),
        getLattes(5)
    ),

    ADENILTON(6,"ADENILTON JOSÉ DA SILVA",
        getDescricaoProf(6),
        getResumo(6),
        getLinhaPesquisa(6),
        getLattes(6)
    ),

    GABRIEL(7,"GABRIEL ALVES DE ALBUQUERQUE JUNIOR",
        getDescricaoProf(7),
        getResumo(7),
        getLinhaPesquisa(7),
        getLattes(7)
    )
}

fun getDescricaoProf(prof: Int):String{
    val descricao = when(prof) {
        1 -> "Possui graduação em Ciência da Computação pela Universidade Federal de Pernambuco (1998), mestrado em Ciência da " +
                "Computação pela Universidade Federal de Pernambuco (2001) e PhD in Computer Science pela City, University of London (2011) " +
                "e fez pós-doutorado na The Open University (UK) em 2016. Atualmente é professor adjunto da Universidade Federal Rural " +
                "de Pernambuco. Tem experiência na área de Ciência da Computação, com ênfase em Engenharia de Software, atuando principalmente nos " +
                "seguintes temas: rastreamento de software, engenharia de requisitos, desenvolvimento de aplicações para dispositivos móveis e " +
                "desenvolvimentos de aplicações para web. Outras áreas de interesse inclui: web services e computação em nuvem."

        2 -> "Possui graduação em Bacharelado em Física - Departamento de Física (1995), mestrado em Física pela Universidade Federal de Pernambuco (1998), " +
                "doutorado em Ciências da Computação pela Universidade Federal de Pernambuco (2006). Atualmente é professor associado da " +
                "Universidade Federal Rural de Pernambuco. É um dos fundadores do Programa de Pós-graduação em Informática Aplicada da UFRPE, " +
                "onde encontra-se com coordenador. Também é membro permanente do Programa de Pós-Graduação em Biometria e Estatística Aplicada " +
                "da UFRPE. Tem experiência na área de Ciência da Computação e Física, com ênfase em Inteligência Artificial, computação Quântica " +
                "e computação científica, atuando principalmente nos seguintes temas: previsão, sistemas híbridos, algoritmos de busca, " +
                "aprendizagem de máquina, séries temporais, redes neurais artificiais e econofísca. Bolsista de Produtividade CNPq."

        3 -> "Professor do Departamento de Computação da Universidade Federal Rural de Pernambuco. Graduado em Ciência da Computação pela " +
                "Universidade Católica de Pernambuco (2005), mestrado(2009) e doutorado(2013) em Ciência da Computação pela Universidade " +
                "Federal de Pernambuco com período sanduíche na Alemanha pela Bergische Universität Wuppertal (2011/2012). " +
                "Principal experiência focada em Avaliação de Desempenho e Dependabilidade de Sistemas. Atua principalmente nos seguintes " +
                "temas: redes de Petri, modelagem de desempenho, dependabilidade e sustentabilidade; e estimativa de consumo de energia, " +
                "impacto ambiental, desempenho e redes de computadores."

        4 -> "Doutora em Ciências da Computação (2015). Mestre em Ciências da Computação pela Universidade Federal de Pernambuco (2009). " +
                "Graduada em Engenharia Elétrica Eletrônica pela Universidade de Pernambuco (2004). Técnica em Telecomunicações pelo " +
                "Centro Federal de Educação Tecnológica de Pernambuco (2002). Professora da Universidade Federal Rural de Pernambuco. " +
                "Membro do programa de pós-graduação em informática aplica da UFRPE. Mãe de uma filha e esteve em licença maternidade em 2016."

        5 -> "Possui graduação em Engenharia da Computação pela Universidade de Pernambuco (POLI/UPE 2004), mestrado em Ciências da Computação " +
                "pela Universidade Federal de Pernambuco (CIn/UFPE 2007) e doutorado em Ciência da Computação na Universidade Federal de " +
                "Pernambuco (CIn/UFPE 2012), onde parte do doutoramento foi realizado no laboratório HP Labs Palo Alto (Estados Unidos). " +
                "Atualmente, é professor adjunto da Universidade Federal Rural de Pernambuco. Tem experiência na área de Ciência da Computação, " +
                "com ênfase na parte de sistemas distribuídos, computação orientada a serviço (SOC), computação em nuvem, computação móvel, " +
                "Internet das Coisas, avaliação de desempenho e segurança da informação. "

        6 -> "Possui graduação em Licenciatura Plena em Matemática pela Universidade Federal Rural de Pernambuco(2008), " +
                "mestrado em Ciências da Computação pela Universidade Federal de Pernambuco(2011) e doutorado em " +
                "Ciências da Computação pela Universidade Federal de Pernambuco(2015). Atualmente é Professor Adjunto da " +
                "Universidade Federal de Pernambuco, Revisor de periódico da Neurocomputing (Amsterdam), Revisor de periódico da " +
                "Engineering Applications of Artificial Intelligence, Revisor de periódico da PLoS One e Revisor de periódico da " +
                "MECHANICAL SYSTEMS AND SIGNAL PROCESSING. Tem experiência na área de Ciência da Computação, com ênfase em Inteligência " +
                "Artificial. Atuando principalmente nos seguintes temas:Computação Quântica, Redes Neurais Quânticas, Redes Neurais Artificiais."

        7 -> "Possui graduação em Engenharia da Computação pela Universidade de Pernambuco (2004), mestrado em Ciências da Computação pela " +
                "Universidade Federal de Pernambuco (2007) e doutorado em Ciências da Computação pela Universidade Federal de Pernambuco (2013). " +
                "Tem experiência na área de ciência da computação, com ênfase em pesquisa operacional e performabilidade. " +
                "Além disso, atuou desde 2001 no desenvolvimento de aplicações JEE. Professor adjunto da Universidade Federal Rural " +
                "de Pernambuco (UFRPE), no departamento de estatística e informática (DEINFO), atua como pesquisador principalmente nas " +
                "áreas de avaliação de performabilidade e ciência de dados."

        else -> "Não existe o professor"
    }
    return descricao
}

fun getResumo(prof: Int):String{
    val descricao = when(prof) {
        1 -> "Professor no Departamento de Estatística e Informática da UFRPE com experiência na área de Ciência da Computação, com ênfase em Engenharia de Software. \n"

        2 -> "Professor no Departamento de Estatística e Informática da UFRPE com experiência na área de Ciência da Computação e Física. \n"

        3 -> "Professor no Departamento de Estatística e Informática da UFRPE com experiência focada em Avaliação de Desempenho e Dependabilidade de Sistemas. \n"

        4 -> "Professora no Departamento de Estatística e Informática da UFRPE e membro do programa de pós-graduação em informática aplica da UFRPE. \n"

        5 -> "Professor no Departamento de Estatística e Informática da UFRPE com experiência na área de Ciência da Computação, " +
                "com ênfase na parte de SD, SOC, computação em nuvem, Mobile, IoT, avaliação de desempenho e segurança da informação. \n"

        6 -> "Professor no Departamento de Estatística e Informática da UFRPE com experiência na área de Ciência da Computação, com ênfase em Inteligência Artificial. \n"

        7 -> "Professor Adjunto no Departamento de Estatística e Informática da UFRPE e atua como pesquisador principalmente nas áreas de avaliação de performabilidade e ciência de dados. \n"

        else -> "Não existe o professor"
    }
    return descricao
}

fun getLinhaPesquisa(prof: Int):String{
    val lPesquisa = when(prof) {
        1 -> "Engenharia de Software e Sistemas Computacionais"
        2 -> "Inteligência e Modelagem Computacional"
        3 -> "Análise de Desempenho e Dependabilidade de Sistemas - ADDS"
        4 -> "Engenharia de Software e Sistemas Computacionais"
        5 -> "Engenharia de Software e Sistemas Computacionais "
        6 -> "Inteligência e Modelagem Computacional  "
        7 -> "Inteligência e Modelagem Computacional "
        else -> "Não existe disciplina para o professor"
    }
    return lPesquisa
}

fun getLattes(prof: Int):String{
    val lattes = when(prof) {
        1 -> "CV Lattes: http://lattes.cnpq.br/0534822491953359"

        2 -> "CV Lattes: http://lattes.cnpq.br/6747136646016870"

        3 -> "CV Lattes: http://lattes.cnpq.br/3146558967986940"

        4 -> "CV Lattes: http://lattes.cnpq.br/9899077867723655"

        5 -> "CV Lattes: http://lattes.cnpq.br/2475965771605110"

        6 -> "CV Lattes: http://lattes.cnpq.br/0314035098884256"

        7 -> "CV Lattes: http://lattes.cnpq.br/1399502815770584"

        else -> "Não existe endereço do lattes"
    }
    return lattes
}