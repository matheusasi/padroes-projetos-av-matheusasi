public class MaquinaVirtualAws implements MaquinaVirtual {

    public static final double CUSTO_POR_HORA = 0.10;

    private final String id;

    public MaquinaVirtualAws(int numero) {
        this.id = "i-" + numero;
    }

    public String getId() {
        return id;
    }
}
