public class EmbalagemEspecial extends ServicoAdicional {

    public EmbalagemEspecial(Fatura fatura) {
        super(fatura);
    }

    protected String getNomeServico() {
        return "Embalagem especial";
    }

    protected double getCustoServico() {
        return 180.00;
    }
}
