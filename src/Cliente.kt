class Cliente
constructor(
    override val nome: String,
    override val rg: String,
    override val historicoAlugueis: String,
    private val compras: MutableList<Livro>
) : Pessoa(nome, rg, historicoAlugueis) {

}