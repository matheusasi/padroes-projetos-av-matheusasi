import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {

    private static final String[] CAMINHOS = {
        "config.properties",
        "questao1/config.properties",
        "../config.properties"
    };

    private static Configuracao instancia;

    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;

    private Configuracao() {
        Properties propriedades = carregar();
        this.regiaoPadrao = propriedades.getProperty("regiao.padrao").trim();
        this.orcamentoMensalMaximo = Double.parseDouble(propriedades.getProperty("orcamento.mensal.maximo").trim());
    }

    public static synchronized Configuracao getInstance() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    private static Properties carregar() {
        for (String caminho : CAMINHOS) {
            File arquivo = new File(caminho);
            if (arquivo.isFile()) {
                Properties propriedades = new Properties();
                try (FileInputStream entrada = new FileInputStream(arquivo)) {
                    propriedades.load(entrada);
                } catch (IOException e) {
                    throw new IllegalStateException("Nao foi possivel ler " + caminho, e);
                }
                return propriedades;
            }
        }
        throw new IllegalStateException("Arquivo config.properties nao encontrado");
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMensalMaximo() {
        return orcamentoMensalMaximo;
    }
}
