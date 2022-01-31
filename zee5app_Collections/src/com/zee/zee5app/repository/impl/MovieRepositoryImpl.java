package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
public class MovieRepositoryImpl implements MovieRepository{
	private Set<Movie> set = new LinkedHashSet<>();

	private static MovieRepository repository;
	
	public static MovieRepository getInstance() {
		if(repository==null) {
			repository = new MovieRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(movie);
		System.out.println(this.set.size());
		if(result) {
			return "success";
		}
		else
			return "fail";
	}

	@Override 
	public String updateMovie(String id, Movie movie) throws IdNotFoundException{
//		// TODO Auto-generated method stub
		Optional<Movie> optional=this.getMovieById(id);
		if(optional.isPresent()) {
			boolean result=set.remove(optional.get());
			set.add(movie);
			if(result) {
				return "success";
			}
			else 
				return "fail";
		}
		
		return "fail";
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub

		Movie movie2 = null;
		for (Movie movie : set) {
			if(movie.getId().equals(id)) {
				movie2= movie;
			}
		}
		return Optional.ofNullable(Optional
				.of(movie2)
				.orElseThrow(()-> new IdNotFoundException("id not found")));
		
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		Movie movie[] = new Movie[set.size()];
		
		return set.toArray(movie);
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		// 
		Optional<Movie> optional = this.getMovieById(id);
		
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else
				return "fail";
		}
		return "fail";
		
	}

	@Override
	public List<Movie> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
