import models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class importerService {
    private static importerService INSTANCE;

    private importerService() {} // Singleton

    public static importerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new importerService();
        }
        return INSTANCE;
    }
    public List<Product> readFromCSV(String filename) {
        List<Product> salida = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            br.readLine(); // Saltar cabecera
            String registro;
            long id = 0L;
            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                salida.add(
                        new Product(
                                ++id,
                                campos[0],
                                Double.parseDouble(campos[1]),
                                Integer.parseInt(campos[2]),
                                campos[3]
                        )
                );
            }
            return salida;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
