import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        ZipCodeQuery zipCodeQuery = new ZipCodeQuery();

        System.out.println("Digite um número de CEP para consulta: ");
        var zipCodeAddress = reading.nextLine();

        try {
            Address newAddress = zipCodeQuery.searchAddress(zipCodeAddress);
            System.out.println(newAddress);
            FileGenerator gerator = new FileGenerator();
            gerator.saveJson(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }
    }
}
