import java.util.ArrayList;
import java.util.List;

public class MontadorAmbiente {

    private static final int HORAS_NO_MES = 730;

    public boolean provisionar(SolicitacaoAmbiente solicitacao) {
        FabricaNuvem fabrica = solicitacao.getProvedor();
        Configuracao configuracao = Configuracao.getInstance();
        HistoricoAuditoria auditoria = HistoricoAuditoria.getInstance();
        String nome = solicitacao.getNome();
        String provedor = fabrica.getNomeProvedor();

        double custo = estimarCusto(fabrica, solicitacao);
        double orcamento = configuracao.getOrcamentoMensalMaximo();

        if (custo > orcamento) {
            String motivo = String.format("custo estimado de R$ %.2f acima do orcamento de R$ %.2f", custo, orcamento);
            System.out.println(String.format("Ambiente %s (%s) RECUSADO: %s%n", nome, provedor, motivo));
            auditoria.registrar(nome, provedor, "RECUSADO: " + motivo);
            return false;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int numero = 1; numero <= solicitacao.getQuantidadeMaquinas(); numero++) {
            maquinas.add(fabrica.criarMaquinaVirtual(numero));
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento(1);
        FilaMensagens fila = fabrica.criarFila(1);

        Ambiente ambiente = new Ambiente(nome, provedor, configuracao.getRegiaoPadrao(), maquinas, armazenamento, fila, custo);
        System.out.println(ambiente.getResumo());
        auditoria.registrar(nome, provedor, "ACEITO");
        return true;
    }

    private double estimarCusto(FabricaNuvem fabrica, SolicitacaoAmbiente solicitacao) {
        double custoMaquinas = solicitacao.getQuantidadeMaquinas() * fabrica.getCustoHoraMaquina() * HORAS_NO_MES;
        double custoArmazenamento = solicitacao.getGbArmazenamento() * fabrica.getCustoGbArmazenamento();
        return custoMaquinas + custoArmazenamento + fabrica.getCustoMensalFila();
    }
}
