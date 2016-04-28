package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.*;


public interface PlacementStatsDao {

	public List<PlacementStats> listPlacementStats();
	public void addPlacementStats(PlacementStats placementstats)  ;
	public List<QuickStats> listQuickStats(String s);
	
}
