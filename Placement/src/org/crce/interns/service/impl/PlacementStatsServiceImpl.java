package org.crce.interns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.crce.interns.model.*;
import org.crce.interns.service.PlacementStatsService;
import org.crce.interns.dao.PlacementStatsDao;



@Service("placementStatsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PlacementStatsServiceImpl implements PlacementStatsService {
	
	public enum Branch { Computer,Electronics,IT,Production };  
	
	@Autowired
	private PlacementStatsDao placementStatsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPlacementStats(PlacementStats placementstats) {
			int cid=0,count=0;
		
			for( Branch b:Branch.values())
			{
		List<QuickStats> a=placementStatsDao.listQuickStats(b.toString());
			int n=a.size();//total placed in that branch
			cid=a.get(0).getCompany_id();
			
			while(true)
			{
				 count=0;int i=0;
				while(a.get(i).getCompany_id()==cid)
				 {count++;
				 i++;
				 }
			
		
			placementstats.setBranch(b.toString());
		placementstats.setCompany_id(cid);
		placementstats.setNo_selected(count);
		placementStatsDao.addPlacementStats(placementstats);
		   count=0;
		cid=a.get(i).getCompany_id();
		if(i==n-1)
		  break;
			}
		
		}
		
		
	}
	
	public List<PlacementStats> listPlacementStats() {
		
			return placementStatsDao.listPlacementStats();
	}
  
	public List<QuickStats> listQuickStats(String branch){
		return placementStatsDao.listQuickStats(branch);
	}
	
}
