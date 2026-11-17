public class CertificadoAutenticidade extends ServicoAdicional {

    public CertificadoAutenticidade(Fatura fatura) {
        super(fatura);
    }

    protected String getNomeServico() {
        return "Certificado de autenticidade";
    }

    protected double getCustoServico() {
        return 300.00;
    }
}
