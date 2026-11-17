public class FabricaAzure implements FabricaNuvem {

    public String getNomeProvedor() {
        return "Azure";
    }

    public double getCustoHoraMaquina() {
        return MaquinaVirtualAzure.CUSTO_POR_HORA;
    }

    public double getCustoGbArmazenamento() {
        return ArmazenamentoAzure.CUSTO_POR_GB;
    }

    public double getCustoMensalFila() {
        return FilaAzure.CUSTO_MENSAL;
    }

    public MaquinaVirtual criarMaquinaVirtual(int numero) {
        return new MaquinaVirtualAzure(numero);
    }

    public Armazenamento criarArmazenamento(int numero) {
        return new ArmazenamentoAzure(numero);
    }

    public FilaMensagens criarFila(int numero) {
        return new FilaAzure(numero);
    }
}
