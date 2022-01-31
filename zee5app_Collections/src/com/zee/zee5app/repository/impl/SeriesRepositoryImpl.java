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

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
public class SeriesRepositoryImpl implements SeriesRepository{
	private TreeSet<Series> set = new TreeSet<>();

	private static SeriesRepository repository;
	
	public static SeriesRepository getInstance() {
		if(repository==null) {
			repository = new SeriesRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(series);
		System.out.println(this.set.size());
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override 
	public String updateSeries(String id, Series series) throws IdNotFoundException{
//		// TODO Auto-generated method stub
		Optional<Series> optional=this.getSeriesById(id);
		if(optional.isPresent()) {
			boolean result=set.remove(optional.get());
			set.add(series);
			if(result) {
				return "success";
			}
			else 
				return "fail";
		}
		
		return "fail";
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub

		Series series2 = null;
		for (Series series : set) {
			if(series.getId().equals(id)) {
				series2= series;
			}
		}
		return Optional.ofNullable(Optional
				.of(series2)
				.orElseThrow(()-> new IdNotFoundException("id not found")));
		
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		Series series[] = new Series[set.size()];
		
		return set.toArray(series);
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		// 
		Optional<Series> optional = this.getSeriesById(id);
		
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
	public List<Series> getAllSeriesDetails() {
		
		return new ArrayList<>(set.descendingSet());
}
	
}
