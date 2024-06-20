package br.com.oracle.screenmatch.main;

import br.com.oracle.screenmatch.model.Episode;
import br.com.oracle.screenmatch.model.EpisodeData;
import br.com.oracle.screenmatch.model.SeasonData;
import br.com.oracle.screenmatch.model.SeriesData;
import br.com.oracle.screenmatch.service.ApiConsumption;
import br.com.oracle.screenmatch.service.ConvertingData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner reading = new Scanner(System.in);
    private ApiConsumption consumption = new ApiConsumption();
    private ConvertingData converter = new ConvertingData();


    private final String ADDRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=84c3cfce";

    public void displayMenu() {
        System.out.println("Enter the name of the series to search: ");
        var seriesName = reading.nextLine();
        var json = consumption.getData(ADDRESS + seriesName.replace(" ", "+") + API_KEY);
        SeriesData data = converter.getData(json, SeriesData.class);
        System.out.println(data);

        List<SeasonData> seasons = new ArrayList<>();

        for (int i = 1; i <= data.totalSeasons(); i++) {
            json = consumption.getData(ADDRESS + seriesName.replace(" ", "+") + "&season=" + i + API_KEY);
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            seasons.add(seasonData);
        }
        seasons.forEach(System.out::println);

        seasons.forEach(s -> s.episodeNameList().forEach(e -> System.out.println(e.title())));

        List<EpisodeData> episodeData = seasons.stream()
                .flatMap(s -> s.episodeNameList().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 10 episodes:");
        episodeData.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("First check - filter (N/A): " + e))
                .sorted(Comparator.comparing(EpisodeData::rating).reversed())
                .peek(e -> System.out.println("Second check - Ordering: " + e))
                .limit(10)
                .peek(e -> System.out.println("Third check - Limit: " + e))
                .map(e -> e.title().toUpperCase())
                .peek(e -> System.out.println("Fourth check - Mapping: " + e))
                .forEach(System.out::println);

        System.out.println("\nList of episodes by season with rating:");
        List<Episode> episodes = seasons.stream()
                .flatMap(s -> s.episodeNameList().stream()
                        .map(ed -> new Episode(s.number(), ed))
                ).collect(Collectors.toList());
        episodes.forEach(System.out::println);

        System.out.println("Enter a snippet of the name of the episode you are looking for:");
        var excerptFromTitle = reading.nextLine();
        Optional<Episode> excerptFromEpisodeSearched = episodes.stream() //Criação de um objeto contêiner que pode ou não converter um valor não nulo.
                .filter(e -> e.getTitle().toUpperCase().contains(excerptFromTitle.toUpperCase()))
                .findFirst();
        if (excerptFromEpisodeSearched.isPresent()) {
            System.out.println("Episode found!");
            System.out.println("Season: " + excerptFromEpisodeSearched.get().getSeason());
        } else {
            System.out.println("Episode not found.");
        };

        System.out.println("\nWhat year do you want to watch the episodes from?");
        var year = reading.nextInt();
        reading.nextLine();
        LocalDate searchDate = LocalDate.of(year, 1,1);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodes.stream()
                .filter(e -> e.getReleaseDate() != null && e.getReleaseDate().isAfter(searchDate))
                .forEach(e -> System.out.println(
                        "Season: " + e.getSeason() +
                                " Episode: " + e.getTitle() +
                                " Release Date: " + e.getReleaseDate().format(dateFormatter)
                ));

        System.out.println("\nFind out the evaluation scores by season of your chosen series:");
        Map<Integer, Double> ratingsBySeason = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason, Collectors.averagingDouble(Episode::getRating)));
        System.out.println(ratingsBySeason);

        System.out.println("\nKey statistics of your chosen series for evaluation:");
        DoubleSummaryStatistics est = episodes.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getRating));
        System.out.println(est);
        System.out.println("\nJust a visual simplification of the data:");
        System.out.println("Average: " + est.getAverage());
        System.out.println("The best episode: " + est.getMax());
        System.out.println("The worst episode: " + est.getMin());
        System.out.println("Number of episodes evaluated: " + est.getCount());
    }
}