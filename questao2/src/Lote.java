import java.util.ArrayList;
import java.util.List;

public class Lote {

    private static final int AUMENTO_MINIMO_PERCENTUAL = 5;

    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private RegraComissao regraComissao;
    private final List<Interessado> interessados = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();
    private boolean aberto = true;
    private boolean vendido = false;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.regraComissao = regraComissao;
    }

    public void acompanhar(Interessado interessado) {
        if (!interessados.contains(interessado)) {
            interessados.add(interessado);
        }
    }

    public void deixarDeAcompanhar(Interessado interessado) {
        interessados.remove(interessado);
    }

    public boolean darLance(Interessado autor, double valor) {
        if (!aberto) {
            System.out.println(String.format("Lance recusado de %s no lote %s: o lote esta encerrado", autor.getNome(), nome));
            return false;
        }
        long atualCentavos = Math.round(getLanceAtual() * 100);
        long minimoCentavos = (atualCentavos * (100 + AUMENTO_MINIMO_PERCENTUAL) + 99) / 100;
        if (Math.round(valor * 100) < minimoCentavos) {
            System.out.println(String.format("Lance recusado de %s no lote %s: R$ %.2f esta abaixo do minimo de R$ %.2f (%d%% acima do lance atual de R$ %.2f)",
                    autor.getNome(), nome, valor, minimoCentavos / 100.0, AUMENTO_MINIMO_PERCENTUAL, getLanceAtual()));
            return false;
        }
        Lance lance = new Lance(autor, valor);
        lances.add(lance);
        System.out.println(String.format("Lance aceito de %s no lote %s: R$ %.2f", autor.getNome(), nome, valor));
        notificar(lance);
        return true;
    }

    private void notificar(Lance lance) {
        for (Interessado interessado : new ArrayList<>(interessados)) {
            if (interessado != lance.getAutor()) {
                interessado.atualizar(this, lance);
            }
        }
    }

    public boolean encerrar() {
        if (!aberto) {
            throw new IllegalStateException("O lote " + nome + " ja foi encerrado");
        }
        aberto = false;
        vendido = !lances.isEmpty() && getLanceAtual() >= precoReserva;
        return vendido;
    }

    public void trocarRegraComissao(RegraComissao novaRegra) {
        if (!aberto) {
            throw new IllegalStateException("A regra de comissao so pode ser trocada antes do encerramento");
        }
        this.regraComissao = novaRegra;
    }

    public double calcularComissao() {
        return regraComissao.calcular(getValorVenda());
    }

    public double getValorVenda() {
        if (!vendido) {
            throw new IllegalStateException("O lote " + nome + " nao foi vendido");
        }
        return getLanceAtual();
    }

    public double getLanceAtual() {
        Lance maiorLance = getMaiorLance();
        if (maiorLance == null) {
            return precoInicial;
        }
        return maiorLance.getValor();
    }

    public Lance getMaiorLance() {
        if (lances.isEmpty()) {
            return null;
        }
        return lances.get(lances.size() - 1);
    }

    public int getTotalLances() {
        return lances.size();
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public RegraComissao getRegraComissao() {
        return regraComissao;
    }

    public boolean isVendido() {
        return vendido;
    }
}
