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

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepository;
public class SubscriptionRepositoryImpl implements SubscriptionRepository{
	private ArrayList<Subscription> set = new ArrayList<>();

	private static SubscriptionRepository repository;
	
	public static SubscriptionRepository getInstance() {
		if(repository==null) {
			repository = new SubscriptionRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(subscription);
		System.out.println(this.set.size());
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override 
	public String updateSubscription(String id, Subscription subscription) throws IdNotFoundException{
//		// TODO Auto-generated method stub
		Optional<Subscription> optional=this.getSubscriptionById(id);
		if(optional.isPresent()) {
			boolean result=set.remove(optional.get());
			set.add(subscription);
			if(result) {
				return "success";
			}
			else 
				return "fail";
		}
		
		return "fail";
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub

		Subscription subscription2 = null;
		for (Subscription subscription : set) {
			if(subscription.getId().equals(id)) {
				subscription2= subscription;
			}
		}
		return Optional.ofNullable(Optional
				.of(subscription2)
				.orElseThrow(()-> new IdNotFoundException("id not found")));
		
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		Subscription subscription[] = new Subscription[set.size()];
		
		return set.toArray(subscription);
	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		// 
		Optional<Subscription> optional = this.getSubscriptionById(id);
		
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
	public List<Subscription> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
