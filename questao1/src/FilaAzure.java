public class FilaAzure implements FilaMensagens {

    public static final double CUSTO_MENSAL = 0.50;

    private final String id;

    public FilaAzure(int numero) {
        this.id = "sb-" + numero;
    }

    public String getId() {
        return id;
    }
}
