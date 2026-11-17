public class SeguroTransporte extends ServicoAdicional {

    public SeguroTransporte(Fatura fatura) {
        super(fatura);
    }

    protected String getNomeServico() {
        return "Seguro de transporte";
    }

    protected double getCustoServico() {
        return getValorVenda() * 0.015;
    }
}
