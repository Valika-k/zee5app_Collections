package com.zee.zee5app.service.impl;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SeriesService;

public class SeriesServiceImpl implements SeriesService{
	
	
	private static SeriesService service;
	
	public static SeriesService getInstance() {
		
		if(service==null) {
			service = new SeriesServiceImpl();
		}
		
		return service;
	}
	
	//SeriesRepository SeriesRepository ;

	SeriesRepository SeriesRepository  =  SeriesRepositoryImpl.getInstance();
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return SeriesRepository.addSeries(series);
	}

	@Override
	public String updateSeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return SeriesRepository.updateSeries( id, series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return SeriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return SeriesRepository.deleteSeriesById(id);
	}

	@Override
	public List<Series> getAllSeriesDetails() {
		// TODO Auto-generated method stub
		return SeriesRepository.getAllSeriesDetails();
	}
	
}
