public class MaquinaVirtualAzure implements MaquinaVirtual {

    public static final double CUSTO_POR_HORA = 0.12;

    private final String id;

    public MaquinaVirtualAzure(int numero) {
        this.id = "vm-" + numero;
    }

    public String getId() {
        return id;
    }
}
