package br.com.oracle.ScreenSoundProject;

import br.com.oracle.ScreenSoundProject.principal.Principal;
import br.com.oracle.ScreenSoundProject.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundProjectApplication implements CommandLineRunner {
    @Autowired
    private ArtistaRepository repositorio;

    public static void main(String[] args) {
        SpringApplication.run(ScreenSoundProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repositorio);
        principal.exibeMenu();
    }
}