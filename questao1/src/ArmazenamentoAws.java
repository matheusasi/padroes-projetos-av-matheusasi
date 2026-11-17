public class ArmazenamentoAws implements Armazenamento {

    public static final double CUSTO_POR_GB = 0.023;

    private final String id;

    public ArmazenamentoAws(int numero) {
        this.id = "s3://" + numero;
    }

    public String getId() {
        return id;
    }
}
