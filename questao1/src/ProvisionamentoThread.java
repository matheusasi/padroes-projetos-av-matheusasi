public class ProvisionamentoThread extends Thread {

    private final MontadorAmbiente montador;
    private final SolicitacaoAmbiente solicitacao;

    public ProvisionamentoThread(MontadorAmbiente montador, SolicitacaoAmbiente solicitacao) {
        this.montador = montador;
        this.solicitacao = solicitacao;
    }

    public void run() {
        montador.provisionar(solicitacao);
    }
}
