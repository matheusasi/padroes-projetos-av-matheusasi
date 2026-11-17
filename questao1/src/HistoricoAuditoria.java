import java.util.ArrayList;
import java.util.List;

public class HistoricoAuditoria {

    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();

    private final List<RegistroAuditoria> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static HistoricoAuditoria getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(new RegistroAuditoria(ambiente, provedor, resultado));
    }

    public synchronized List<RegistroAuditoria> getRegistros() {
        return new ArrayList<>(registros);
    }
}
