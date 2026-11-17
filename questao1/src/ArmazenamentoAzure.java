public class ArmazenamentoAzure implements Armazenamento {

    public static final double CUSTO_POR_GB = 0.02;

    private final String id;

    public ArmazenamentoAzure(int numero) {
        this.id = "blob://" + numero;
    }

    public String getId() {
        return id;
    }
}
