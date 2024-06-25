package br.com.oracle.carprices;

import br.com.oracle.carprices.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarPricesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarPricesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
