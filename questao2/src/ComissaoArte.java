public class ComissaoArte implements RegraComissao {

    public String getNome() {
        return "Arte";
    }

    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}
