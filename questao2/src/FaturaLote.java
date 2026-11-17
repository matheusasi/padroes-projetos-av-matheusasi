public class FaturaLote implements Fatura {

    private final Lote lote;

    public FaturaLote(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalArgumentException("So lotes vendidos geram fatura");
        }
        this.lote = lote;
    }

    public String getDescricao() {
        return "Lote: " + lote.getNome() + " (" + lote.getCategoria() + ")\n"
                + "Comprador: " + lote.getMaiorLance().getAutor().getNome() + "\n"
                + String.format("Valor de venda: R$ %.2f", getValorVenda());
    }

    public double getValorVenda() {
        return lote.getValorVenda();
    }

    public double getTotal() {
        return getValorVenda();
    }
}
