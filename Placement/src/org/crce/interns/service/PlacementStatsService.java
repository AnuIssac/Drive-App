package org.crce.interns.service;

import java.util.List;

import org.crce.interns.model.*;



public interface PlacementStatsService {
	
	
	public List<PlacementStats> listPlacementStats();
	public void addPlacementStats(PlacementStats placementstats);
	public List<QuickStats> listQuickStats(String branch);
	
	}
