package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;

import com.zee.zee5app.Exception.IdNotFoundException;
public interface SubscriptionService {
	public String addSubscription(Subscription movie);
	public String updateSubscription(String id, Subscription movie) throws IdNotFoundException;
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public Subscription[] getAllSubscriptions();
	public String deleteSubscriptionById(String id) throws IdNotFoundException;
	public List<Subscription> getAllSubscriptionDetails();
}
