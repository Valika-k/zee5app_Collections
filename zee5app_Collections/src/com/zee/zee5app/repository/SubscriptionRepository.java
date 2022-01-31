package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.Exception.IdNotFoundException;
public interface SubscriptionRepository {
	public String addSubscription(Subscription movie);
	public String updateSubscription(String id, Subscription movie) throws IdNotFoundException;
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public Subscription[] getAllSubscriptions();
	public List<Subscription> getAllSubscriptionDetails();
	public String deleteSubscriptionById(String id) throws IdNotFoundException;

}
