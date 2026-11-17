import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    public String getNome() {
        return "Auditor";
    }

    public void atualizar(Lote lote, Lance lance) {
        String registro = String.format("%s | lote %s | %s | R$ %.2f",
                LocalDateTime.now().format(FORMATO), lote.getNome(), lance.getAutor().getNome(), lance.getValor());
        registros.add(registro);
    }

    public void imprimirRegistros() {
        System.out.println("===== Registros do auditor =====");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
