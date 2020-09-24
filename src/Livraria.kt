class Livraria
constructor(
    val nome: String,
    val dataCriacao: String
) : IBibliotecaLivraria {

    private val catalogo = mutableSetOf<Livro>();
    private val colecoes = mutableMapOf<String, List<Livro>>()
    private val livrosVendidos = mutableListOf<Livro>()

    override fun cadastrarLivro(livroCadastro: Livro) {
        catalogo.add(livroCadastro);
        println("Livro cadastrado com sucesso!")
    }

    override fun cadastrarColecao(chave: String, valor: List<Livro>) {
        colecoes[chave] = valor
    }

    override fun consultarLivro(nomeObra: String?, codigo: String?) {
        // Aqui a prioridade da busca é sempre pelo nome da obra
        nomeObra?.let {
            val contemTitulo = catalogo.filter {
                it.getTitulo().contains(nomeObra)
            }
            decidirImpressao(contemTitulo, "Livro")
            return
        }
        codigo?.let {
            val contemCodigo = catalogo.filter {
                it.getCodigo() == codigo;
            }
            decidirImpressao(contemCodigo, "Livro")
            return
        }
    }

    override fun consultarColecao(chaveConsulta: String) {
        if (colecoes.containsKey(chaveConsulta)) {
            println("$colecoes")
            return
        }
        decidirImpressao(listOf(), "Coleção")
    }

    override fun alugarLivro(livroAlugar: Livro) {
        if (catalogo.contains(livroAlugar)) {
            catalogo.forEach {
                if (it.getTitulo() == livroAlugar.getTitulo()) {
                    it.setEstadoAtual("Alugado")
                    catalogo.remove(livroAlugar)
                }
            }
            println("Livro alugado")
        }
    }

    override fun alugarColecao(chaveColecao: String) {
        this.colecoes.remove(chaveColecao)
        println("Coleção Alugada")
    }

    override fun efetuarVenda(livroCompra: Livro) {
        if (this.catalogo.contains(livroCompra)) {
            this.livrosVendidos.add(livroCompra)
            this.catalogo.remove(livroCompra)
        }
    }

    override fun verificarEstoque() {
        var livrosDisponiveis = 0
        var livrosAlugados = 0
         catalogo.forEach {
            when {
                it.getEstadoAtual() == "Disponivel" -> livrosDisponiveis++
                it.getEstadoAtual() == "Alugado" -> livrosAlugados++
            }
        }

        this.colecoes.forEach {
            it.value.forEach {
                when {
                    it.getEstadoAtual() == "Disponivel" -> livrosDisponiveis++
                    it.getEstadoAtual() == "Alugado" -> livrosAlugados++
                }
            }
        }

        val totalLivrosVendidos = valorLivrosVendidos()

        println("Livros Disponiveis: ${livrosDisponiveis}")
        println("Livros Alugados: ${livrosAlugados}")
        println("Livros Vendidos: R$ ${totalLivrosVendidos}")
    }

    private fun decidirImpressao(livros: List<Livro>, tipoConsulta: String) {
       if (livros.isEmpty()) {
           println("$tipoConsulta não encontrado")
       } else {
           println(livros)
       }
    }

    private fun valorLivrosVendidos(): Double {

        var soma = 0.0
        for (livro in this.livrosVendidos) {
            soma += livro.getPrecoVenda()
        }

        return soma
    }
}