class Funcionario
constructor(
    override val nome: String,
    override val rg: String,
    override val historicoAlugueis: String,
    private val vendas: MutableList<Livro>
) : Pessoa(nome, rg, historicoAlugueis) {
}