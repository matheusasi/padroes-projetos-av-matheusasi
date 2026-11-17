public class PainelLeiloeiro implements Interessado {

    public String getNome() {
        return "Painel do leiloeiro";
    }

    public void atualizar(Lote lote, Lance lance) {
        System.out.println(String.format("  [Painel] Lote %s: maior lance R$ %.2f, total de lances %d",
                lote.getNome(), lote.getMaiorLance().getValor(), lote.getTotalLances()));
    }
}
