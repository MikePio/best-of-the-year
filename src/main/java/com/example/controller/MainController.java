package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Movie;
import com.example.model.Song;

@Controller
public class MainController {
	
  @GetMapping("/")
  @ResponseBody
  public String PrintName(){

    final String titleHomePage = "Benvenuto! <br> Aggiungi \"/step1\" all'url ";

    return "<html><body><h1>" + titleHomePage + "</h1></body></html>";
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
    songs.add(new Song(2,"Anelli e collane- Artie 5ive ft. ANNA"));
    songs.add(new Song(3,"Piove - Lazza, Sfera Ebbasta"));
    songs.add(new Song(4,"Gucci Ski Mask - Lazza, Guè"));
    songs.add(new Song(5,"Michè - Tony Tammaro"));

    return songs;
  }

  // @GetMapping("/movies")
  // @GetMapping("/songs")
}
