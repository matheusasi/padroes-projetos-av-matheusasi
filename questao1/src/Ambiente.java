import java.util.List;

public class Ambiente {

    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;
    private final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, FilaMensagens fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public String getResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("===== Ambiente provisionado =====\n");
        resumo.append("Ambiente: ").append(nome).append("\n");
        resumo.append("Provedor: ").append(provedor).append("\n");
        resumo.append("Regiao: ").append(regiao).append("\n");
        for (MaquinaVirtual maquina : maquinas) {
            resumo.append("Maquina virtual: ").append(maquina.getId()).append("\n");
        }
        resumo.append("Armazenamento: ").append(armazenamento.getId()).append("\n");
        resumo.append("Fila de mensagens: ").append(fila.getId()).append("\n");
        resumo.append(String.format("Custo mensal estimado: R$ %.2f%n", custoMensal));
        return resumo.toString();
    }
}
