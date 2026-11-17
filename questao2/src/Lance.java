public class Lance {

    private final Interessado autor;
    private final double valor;

    public Lance(Interessado autor, double valor) {
        this.autor = autor;
        this.valor = valor;
    }

    public Interessado getAutor() {
        return autor;
    }

    public double getValor() {
        return valor;
    }
}
