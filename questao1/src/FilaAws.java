public class FilaAws implements FilaMensagens {

    public static final double CUSTO_MENSAL = 0.40;

    private final String id;

    public FilaAws(int numero) {
        this.id = "sqs-" + numero;
    }

    public String getId() {
        return id;
    }
}
