public class ComissaoVeiculos implements RegraComissao {

    private static final double LIMITE = 5000.00;

    public String getNome() {
        return "Veiculos";
    }

    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, LIMITE);
    }
}
