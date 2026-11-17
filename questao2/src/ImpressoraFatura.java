public class ImpressoraFatura {

    public void imprimir(Fatura fatura) {
        System.out.println("===== Fatura do comprador =====");
        System.out.println(fatura.getDescricao());
        System.out.println(String.format("Total a pagar: R$ %.2f", fatura.getTotal()));
    }
}
