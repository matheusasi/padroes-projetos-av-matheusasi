public class ComissaoEletronicos implements RegraComissao {

    private static final double MINIMO = 50.00;

    public String getNome() {
        return "Eletronicos";
    }

    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, MINIMO);
    }
}
