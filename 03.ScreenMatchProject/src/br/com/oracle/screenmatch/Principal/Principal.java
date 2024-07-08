package br.com.oracle.screenmatch.Principal;

import br.com.oracle.screenmatch.calculo.CalculadoraDeTempo;
import br.com.oracle.screenmatch.calculo.FiltroRecomendacao;
import br.com.oracle.screenmatch.modelos.Episodio;
import br.com.oracle.screenmatch.modelos.Filme;
import br.com.oracle.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Filme favorito = new Filme("Sonic 2", 2022);

        favorito.setDuracaoEmMinutos(125);
        System.out.println("Duração do Filme: " + favorito.getDuracaoEmMinutos());
        favorito.setIncluidoNoPlano(true);

        favorito.exibeFichaTecnica();
        favorito.avalia(6);
        favorito.avalia(8);
        favorito.avalia(4);

        System.out.println("Total de avaliações: " + favorito.getTotalDeAvaliacoes());
        System.out.println("Média de avaliações do filme: " +favorito.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar " + lost.getNome() + ": " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Deadpool 2", 2023);
        outroFilme.setNome("");
        outroFilme.setDuracaoEmMinutos(185);
        System.out.println("Duração do Filme: " + outroFilme.getDuracaoEmMinutos());
        outroFilme.setIncluidoNoPlano(true);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(favorito);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.getSerie(lost);
        episodio.setTotalVisualizacoes(100);
        filtro.filtra(episodio);

        var filmeDeAcao = new Filme("Velozes e Furiosos 9", 2021);
        filmeDeAcao.setDuracaoEmMinutos(143);
        filmeDeAcao.avalia(3.7);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDeAcao);
        listaDeFilmes.add(favorito);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme: " + listaDeFilmes.get(0).toString());

    }
}
