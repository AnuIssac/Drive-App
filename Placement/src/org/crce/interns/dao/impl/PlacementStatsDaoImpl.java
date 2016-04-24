package org.crce.interns.dao.impl;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.crce.interns.dao.PlacementStatsDao;
import org.crce.interns.model.*;
import javax.sql.DataSource;


@Repository("placementStatsDao")

public class PlacementStatsDaoImpl implements PlacementStatsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	Session session = sessionFactory.openSession();
	
	public enum Branch { Computer,Electronics,IT,Production } ; 
	
	
	@SuppressWarnings("unchecked")
	public List<PlacementStats> listPlacementStats() {
		List<PlacementStats> list = sessionFactory.getCurrentSession().createCriteria(PlacementStats.class).list();
		
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
			List results = query.list();
			session.close();
		return results;
		
	}
 
}