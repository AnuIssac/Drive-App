package org.crce.interns.dao.impl;


import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.crce.interns.dao.PlacementStatsDao;
import org.crce.interns.model.*;



@Repository("placementStatsDao")
public class PlacementStatsDaoImpl implements PlacementStatsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//
	
	Session session ;
	
	public enum Branch { Computer,Electronics,IT,Production } ; 
	
	
	@SuppressWarnings("unchecked")
	public List<PlacementStats> listPlacementStats() {
		
		this.session = sessionFactory.openSession();
		
		List<PlacementStats> list = session.createCriteria(PlacementStats.class).list();
		
		System.out.println("inside dao size of list = " + list.size());
		
		return list;
	}

	public void addPlacementStats(PlacementStats placementstats) {
		
		
		sessionFactory.getCurrentSession().saveOrUpdate(placementstats);
		
}
	
	public List<QuickStats> listQuickStats(String s) {
		//List<QuickStats> list = sessionFactory.getCurrentSession().createCriteria(PlacementStats.class).list();
		
		
		String hql = "FROM placement_statistics_schema.quick_stats WHERE branch='s' " +
	             "ORDER BY company_id";
		
		
		SQLQuery query = session.createSQLQuery(hql);
		query.addEntity(QuickStats.class);
		@SuppressWarnings("unchecked")
		List<QuickStats> results = query.list();
		session.close();
		return results;
		
	}
 
}
