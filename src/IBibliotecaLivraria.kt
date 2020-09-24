interface IBibliotecaLivraria {
    fun cadastrarLivro(livroCadastro: Livro)
    fun cadastrarColecao(chave: String, valor: List<Livro>)
    fun consultarLivro(nomeObra: String? = null, codigo: String? = null)
    fun consultarColecao(chaveConsulta: String)
    fun alugarLivro(livro: Livro)
    fun alugarColecao(chaveColecao: String)
    fun efetuarVenda(livroCompra: Livro)
    fun verificarEstoque()
}