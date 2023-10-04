package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Movie;
import com.example.model.Song;

@Controller
public class MainController {

  // @GetMapping("/")
  // @ResponseBody // * serve per restituire SOLO codice HTML
  // public String PrintName(){

  //   final String titleHomePage = "Benvenuto! <br> Aggiungi \"/step1\" all'url ";

  //   return "<html><body><h1>" + titleHomePage + "</h1></body></html>";
  // }
	
  @GetMapping("/")
  public String PrintName(Model model){

    final String name = "Michele";

    model.addAttribute("name", name);

    return "home";
  }

  @GetMapping("/step1")
  public String step1(Model model){
    
    final String name = "Michele";

    model.addAttribute("name", name);

    return "step-1";
  }

  private List<Movie> getBestMovies(){
    
    List<Movie> movies = new ArrayList<>();

    movies.add(new Movie(1,"Iron Man"));
    movies.add(new Movie(2,"Thor"));
    movies.add(new Movie(3,"Avengers Endgame"));
    movies.add(new Movie(4,"Black Widow"));
    movies.add(new Movie(5,"Spider-Man: Homecoming"));

    return movies;
  }

  private List<Song> getBestSongs(){
    
    List<Song> songs = new ArrayList<>();

    songs.add(new Song(1,"Extasi - Fred De Palma"));
    songs.add(new Song(2,"Anelli e collane - Artie 5ive ft. ANNA"));
    songs.add(new Song(3,"Piove - Lazza, Sfera Ebbasta"));
    songs.add(new Song(4,"Gucci Ski Mask - Lazza, Guè"));
    songs.add(new Song(5,"Michè - Tony Tammaro"));

    return songs;
  }

  @GetMapping("/movies") // rotta http://localhost:8080/movies
  public String movies(Model model){
    
    final String moviesString = getBestMovies() // ottiene la lista dei migliori film utilizzando il metodo getBestMovies()
      .stream() // converte la lista in uno stream
      .map(m -> m.getTitle()) // estrae i titoli dei film dalla lista
      .collect(Collectors.joining(", "));  // combina i titoli separati da virgola in una singola stringa
      model.addAttribute("moviesString", moviesString); // viene aggiunta la stringa dei titoli in modo che essa venga visualizzata nella pagina html "movies" 
      
      List<Movie> moviesList = getBestMovies();
      model.addAttribute("moviesList", moviesList); // aggiunge la lista di canzoni come attributo "movieList"

      return "movies"; // nome della view(/pagina HTML) da visualizzare
  }

  @GetMapping("/songs") // rotta http://localhost:8080/songs
  public String songs(Model model){

    final String songsString = getBestSongs() // ottiene la lista delle migliori canzoni utilizzando il metodo getBestSongs()
      .stream() // converte la lista in uno stream
      .map(m -> m.getTitle()) // estrae i titoli delle canzoni dalla lista
      .collect(Collectors.joining(", ")); // combina i titoli separati da virgola in una singola stringa
      model.addAttribute("songsString", songsString); // viene aggiunta la stringa dei titoli in modo che essa venga visualizzata nella pagina html "songs" 
      
      List<Song> songsList = getBestSongs();
      model.addAttribute("songsList", songsList); // aggiunge la lista di canzoni come attributo "songsList"

      return "songs"; // nome della view(/pagina HTML) da visualizzare
  }

  @GetMapping("/movies/{id}")
  public String getMovieDetails(@PathVariable int id, Model model){

    Movie movieId = getBestMovies().get(id);
    String movieTitle = movieId.getTitle();

    model.addAttribute("movieTitle", movieTitle);

    return "movie-details";
  }

  @GetMapping("/songs/{id}")
  public String getSongDetails(@PathVariable int id, Model model){

    Song songId = getBestSongs().get(id);
    String songTitle = songId.getTitle();

    model.addAttribute("songTitle", songTitle);

    return "song-details";
  }

  @GetMapping("/index")
  public String PrintIndexVariables(Model model){

    final String titleIndex = "Welcome! \n This is the Index Page";

    model.addAttribute("titleIndex", titleIndex);

    return "index";
  }

}
