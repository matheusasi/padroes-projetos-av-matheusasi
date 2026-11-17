public class Main {
    public static void main(String[] args) throws InterruptedException {
        MontadorAmbiente montador = new MontadorAmbiente();

        SolicitacaoAmbiente loja = new SolicitacaoAmbiente("loja-virtual", new FabricaAws(), 2, 500);
        SolicitacaoAmbiente relatorios = new SolicitacaoAmbiente("relatorios", new FabricaAws(), 3, 1000);
        SolicitacaoAmbiente portal = new SolicitacaoAmbiente("portal-rh", new FabricaAzure(), 2, 800);
        SolicitacaoAmbiente dataLake = new SolicitacaoAmbiente("data-lake", new FabricaAzure(), 10, 2000);

        Thread[] threads = {
            new ProvisionamentoThread(montador, loja),
            new ProvisionamentoThread(montador, relatorios),
            new ProvisionamentoThread(montador, portal),
            new ProvisionamentoThread(montador, dataLake)
        };

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("===== Historico de auditoria =====");
        for (RegistroAuditoria registro : HistoricoAuditoria.getInstance().getRegistros()) {
            System.out.println(registro);
        }
    }
}
