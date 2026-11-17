public class ComissaoImoveis implements RegraComissao {

    private static final double FIXO = 1500.00;

    public String getNome() {
        return "Imoveis";
    }

    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + FIXO;
    }
}
