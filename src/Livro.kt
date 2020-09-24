class Livro
constructor(
    private var titulo: String,
    private var codigoObra: String,
    private val autor: String,
    private val anoLancamento: String,
    private var precoVenda: Double,
    private var precoAluguel: Double,
    private var estadoAtual: String = ""
) {

    init {
        setEstadoAtual(this.estadoAtual)
    }

    fun getTitulo(): String = this.titulo

    fun getCodigo(): String = this.codigoObra

    fun setPrecoAluguel(novoPreco: Double) {
        if (novoPreco > 0) this.precoAluguel = novoPreco
    }

    fun getEstadoAtual(): String = this.estadoAtual
    fun setEstadoAtual(novoEstado: String) {
        if (novoEstado != "Disponivel" || novoEstado != "Vendido" || novoEstado != "Alugado") return
        this.estadoAtual = novoEstado
    }

    fun getPrecoVenda(): Double = this.precoVenda
    fun setPrecoVenda(novoPreco: Double) {
        if (novoPreco < 0) return
        this.precoVenda = novoPreco
    }

    override fun toString(): String {
        return "Titulo da obra: $titulo, $autor"
    }
}