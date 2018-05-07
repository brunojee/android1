typealias Desconto = (Double) -> Double

class Matricula(val nome: String, val valor: Double, val desconto: Desconto) {
    fun calcularDesconto(): Double {
        return desconto(valor)
    }
}

fun main(args: Array<String>) {

	val alunoAtual = Matricula("José", 250.0, desconto = { desconto: Double -> desconto * 0})
    val exalunoAtual = Matricula("Maria", 300.0, desconto = { desconto: Double -> desconto * 0.20 })
  
    println("${exalunoAtual.nome} R$ %.2f por mês de desconto.".format(exalunoAtual.calcularDesconto()))
    println("${alunoAtual.nome}   R$ %.2f por mês de desconto.".format(alunoAtual.calcularDesconto()))
}