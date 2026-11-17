public interface FabricaNuvem {
    String getNomeProvedor();
    double getCustoHoraMaquina();
    double getCustoGbArmazenamento();
    double getCustoMensalFila();
    MaquinaVirtual criarMaquinaVirtual(int numero);
    Armazenamento criarArmazenamento(int numero);
    FilaMensagens criarFila(int numero);
}
