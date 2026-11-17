public class FabricaAws implements FabricaNuvem {

    public String getNomeProvedor() {
        return "AWS";
    }

    public double getCustoHoraMaquina() {
        return MaquinaVirtualAws.CUSTO_POR_HORA;
    }

    public double getCustoGbArmazenamento() {
        return ArmazenamentoAws.CUSTO_POR_GB;
    }

    public double getCustoMensalFila() {
        return FilaAws.CUSTO_MENSAL;
    }

    public MaquinaVirtual criarMaquinaVirtual(int numero) {
        return new MaquinaVirtualAws(numero);
    }

    public Armazenamento criarArmazenamento(int numero) {
        return new ArmazenamentoAws(numero);
    }

    public FilaMensagens criarFila(int numero) {
        return new FilaAws(numero);
    }
}
