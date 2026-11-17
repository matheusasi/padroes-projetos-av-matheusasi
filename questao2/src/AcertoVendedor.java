public class AcertoVendedor {

    public void imprimir(Lote lote) {
        double valorVenda = lote.getValorVenda();
        double comissao = lote.calcularComissao();
        System.out.println("===== Acerto do vendedor =====");
        System.out.println("Lote: " + lote.getNome());
        System.out.println(String.format("Valor de venda: R$ %.2f", valorVenda));
        System.out.println(String.format("Comissao cobrada (regra %s): R$ %.2f", lote.getRegraComissao().getNome(), comissao));
        System.out.println(String.format("Valor liquido a repassar: R$ %.2f", valorVenda - comissao));
    }
}
