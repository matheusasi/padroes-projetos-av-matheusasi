public class SolicitacaoAmbiente {

    private final String nome;
    private final FabricaNuvem provedor;
    private final int quantidadeMaquinas;
    private final int gbArmazenamento;

    public SolicitacaoAmbiente(String nome, FabricaNuvem provedor, int quantidadeMaquinas, int gbArmazenamento) {
        this.nome = nome;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNome() {
        return nome;
    }

    public FabricaNuvem getProvedor() {
        return provedor;
    }

    public int getQuantidadeMaquinas() {
        return quantidadeMaquinas;
    }

    public int getGbArmazenamento() {
        return gbArmazenamento;
    }
}
