package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;

import com.zee.zee5app.Exception.IdNotFoundException;
public interface MovieService {
	public String addMovie(Movie movie);
	public String updateMovie(String id, Movie movie) throws IdNotFoundException;
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
	public Movie[] getAllMovies();
	public String deleteMovieById(String id) throws IdNotFoundException;
	public List<Movie> getAllMovieDetails();
}
