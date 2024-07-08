package br.com.oracle.screenmatch.Principal;

import br.com.oracle.screenmatch.modelos.Filme;
import br.com.oracle.screenmatch.modelos.Serie;
import br.com.oracle.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme favorito = new Filme("Sonic 2", 2022);
        favorito.avalia(6);
        Filme outroFilme = new Filme("Deadpool 2", 2023);
        outroFilme.avalia(8);
        var filmeDeAcao = new Filme("Velozes e Furiosos 9", 2021);
        filmeDeAcao.avalia(4);

        Serie lost = new Serie("Lost", 2000);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filmeDeAcao);
        lista.add(favorito);
        lista.add(outroFilme);

        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        System.out.println("Lista de Titulos Ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("The Rock");
        buscaPorArtista.add("Meryl Streep");
        buscaPorArtista.add("Scarlett Johansson");
        buscaPorArtista.add("Anthony Hopkins");
        System.out.println("Lista antes da ordenação: " + buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println("Lista posterior a ordenação: " + buscaPorArtista );
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano: " + lista);

    }
}
