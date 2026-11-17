public class Participante implements Interessado {

    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void atualizar(Lote lote, Lance lance) {
        System.out.println(String.format("  [%s] Novo lance no lote %s: R$ %.2f", nome, lote.getNome(), lance.getValor()));
    }
}
