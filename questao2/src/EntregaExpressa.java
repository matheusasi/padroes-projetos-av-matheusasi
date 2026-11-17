public class EntregaExpressa extends ServicoAdicional {

    public EntregaExpressa(Fatura fatura) {
        super(fatura);
    }

    protected String getNomeServico() {
        return "Entrega expressa";
    }

    protected double getCustoServico() {
        return 450.00;
    }
}
