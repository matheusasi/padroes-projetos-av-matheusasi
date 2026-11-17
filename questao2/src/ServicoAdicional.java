public abstract class ServicoAdicional implements Fatura {

    private final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String getNomeServico();

    protected abstract double getCustoServico();

    public String getDescricao() {
        return fatura.getDescricao() + "\n"
                + String.format("Servico: %s, R$ %.2f", getNomeServico(), getCustoServico());
    }

    public double getValorVenda() {
        return fatura.getValorVenda();
    }

    public double getTotal() {
        return fatura.getTotal() + getCustoServico();
    }
}
