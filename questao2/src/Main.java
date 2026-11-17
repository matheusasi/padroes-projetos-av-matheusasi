public class Main {

    public static void main(String[] args) {
        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        Lote quadro = new Lote("Quadro a Oleo", "Arte", 1000.00, 1400.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletronicos", 2000.00, 3000.00, new ComissaoEletronicos());

        quadro.acompanhar(ana);
        quadro.acompanhar(bruno);
        quadro.acompanhar(carla);
        quadro.acompanhar(painel);
        quadro.acompanhar(auditor);

        notebook.acompanhar(ana);
        notebook.acompanhar(carla);
        notebook.acompanhar(painel);
        notebook.acompanhar(auditor);

        System.out.println("===== Lances no quadro =====");
        quadro.darLance(ana, 1100.00);
        quadro.darLance(bruno, 1120.00);
        quadro.darLance(bruno, 1200.00);

        System.out.println();
        System.out.println("Carla deixou de acompanhar o quadro");
        quadro.deixarDeAcompanhar(carla);
        quadro.darLance(ana, 1500.00);

        System.out.println();
        System.out.println("===== Lances no notebook =====");
        notebook.darLance(carla, 2200.00);
        notebook.darLance(ana, 2250.00);
        notebook.darLance(ana, 2400.00);

        System.out.println();
        System.out.println("===== Campanha de comissao =====");
        System.out.println("Regra do quadro antes: " + quadro.getRegraComissao().getNome());
        quadro.trocarRegraComissao(new ComissaoEletronicos());
        System.out.println("Regra do quadro depois: " + quadro.getRegraComissao().getNome());

        System.out.println();
        System.out.println("===== Encerramento =====");
        mostrarEncerramento(quadro);
        quadro.darLance(bruno, 2000.00);
        mostrarEncerramento(notebook);

        System.out.println();
        new AcertoVendedor().imprimir(quadro);

        System.out.println();
        Fatura fatura = new FaturaLote(quadro);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        new ImpressoraFatura().imprimir(fatura);

        System.out.println();
        auditor.imprimirRegistros();
    }

    private static void mostrarEncerramento(Lote lote) {
        if (lote.encerrar()) {
            System.out.println(String.format("Lote %s vendido por R$ %.2f para %s",
                    lote.getNome(), lote.getValorVenda(), lote.getMaiorLance().getAutor().getNome()));
        } else {
            System.out.println(String.format("Lote %s nao vendido: maior lance de R$ %.2f abaixo da reserva de R$ %.2f",
                    lote.getNome(), lote.getLanceAtual(), lote.getPrecoReserva()));
        }
    }
}
