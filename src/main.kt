fun main() {
    val livraria = Livraria("Paginas viradas", "23/09/2020")
    val livro = Livro(
        "As aventuras de Bob",
        "1",
        "Carlos Lima",
    "2020",
        37.90,
        12.70,
        "Disponivel",
    )
    val livro2 = Livro(
        "As aventuras de Bob 2",
        "2",
        "Carlos Lima",
        "2020",
        37.90,
        12.70,
        "Disponivel",
    )
    livraria.cadastrarLivro(livro)
    livraria.cadastrarLivro(livro2)

    livraria.verificarEstoque()
    livraria.cadastrarColecao("As aventuras de Bob", listOf(livro, livro2))
    livraria.consultarColecao("As aventuras de Bob")
    livraria.consultarColecao("")
    livraria.verificarEstoque()
    livraria.efetuarVenda(livro2)
    livraria.verificarEstoque()
    livraria.consultarLivro(null)   // Estava comecando a implementar os conceitos de null safety

}