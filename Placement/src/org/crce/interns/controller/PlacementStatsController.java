package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import org.crce.interns.bean.PlacementStatsBean;
import org.crce.interns.bean.QuickStatsBean;
import org.crce.interns.dao.impl.PlacementStatsDaoImpl.Branch;
import org.crce.interns.model.PlacementStats;
import org.crce.interns.model.QuickStats;
import org.crce.interns.service.PlacementStatsService;

@Controller("placementStatsController")
public class PlacementStatsController {

	@Autowired
	private PlacementStatsService placementstatsService;
	
	
	@RequestMapping(value="/stats.html", method = RequestMethod.GET)
	public ModelAndView listPlacementStats() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("placementstats",prepareListofBean(placementstatsService.listPlacementStats()));
		
		return new ModelAndView("psList", model);
	}
	
	@RequestMapping(value = "/genstats.html", method = RequestMethod.POST)  
	 public ModelAndView generateStatus(@ModelAttribute PlacementStats placementstats ) { 
		//PlacementStats placementstats = null;
		
		placementstatsService.addPlacementStats(placementstats);
		
	
		
	  return new ModelAndView("genSuccess");  
	 }  
	
	
	
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("index");
		return new ModelAndView("index");
	}
	
	private List<PlacementStatsBean> prepareListofBean(List<PlacementStats> addplacementstats){
		List<PlacementStatsBean> beans = null;
		if(addplacementstats != null && !addplacementstats.isEmpty()){
			beans = new ArrayList<PlacementStatsBean>();
			PlacementStatsBean bean = null;
			for(PlacementStats a : addplacementstats){
				
				bean = new PlacementStatsBean();
				bean.setPlacment_stats_id(a.getPlacment_stats_id());
				bean.setCompany_id(a.getCompany_id());
				bean.setYear(a.getYear());
				bean.setBranch(a.getBranch());
				bean.setNo_applied(a.getNo_applied());
				bean.setTotal_no_of_students(a.getTotal_no_of_students());
				bean.setNo_selected(a.getNo_selected());
				bean.setNo_rejected(a.getNo_rejected());
				bean.setNo_joined(a.getNo_joined());
				bean.setPercentage_placed(a.getPercentage_placed());
				bean.setCreated_by(a.getCreated_by());
				bean.setCreated_date(a.getCreated_date());
				bean.setModified_by(a.getModified_by());
				bean.setModified_date(a.getModified_date());
				
						beans.add(bean);
			}

		}
		return beans;
	}
	
	private PlacementStats prepareModel(PlacementStatsBean addplacementstatsBean){
		PlacementStats addplacementstats = new PlacementStats();
		addplacementstats.setPlacment_stats_id(addplacementstatsBean.getPlacment_stats_id());
		
		addplacementstats.setCompany_id(addplacementstatsBean.getCompany_id());
		
		addplacementstats.setYear(addplacementstatsBean.getYear());
		
		addplacementstats.setBranch(addplacementstatsBean.getBranch());
		
		addplacementstats.setNo_applied(addplacementstatsBean.getNo_applied());
		
		addplacementstats.setTotal_no_of_students(addplacementstatsBean.getTotal_no_of_students());
		
		addplacementstats.setNo_selected(addplacementstatsBean.getNo_selected());
		
		addplacementstats.setNo_rejected(addplacementstatsBean.getNo_rejected());
		
		addplacementstats.setNo_joined(addplacementstatsBean.getNo_joined());
		
		addplacementstats.setPercentage_placed(addplacementstatsBean.getPercentage_placed());
		
		addplacementstats.setCreated_by(addplacementstatsBean.getCreated_by());
		
		addplacementstats.setCreated_date(addplacementstatsBean.getCreated_date());
		
		addplacementstats.setModified_by(addplacementstatsBean.getModified_by());
		
		addplacementstats.setModified_date(addplacementstatsBean.getModified_date());
		
		
		return addplacementstats;
	}
	
	private List<QuickStatsBean> prepareListofBeanQ(List<QuickStats> addplacementstats){
		List<QuickStatsBean> beans = null;
		if(addplacementstats != null && !addplacementstats.isEmpty()){
			beans = new ArrayList<QuickStatsBean>();
			QuickStatsBean bean = null;
			for(QuickStats a : addplacementstats){
				
				bean = new QuickStatsBean();
				bean.setUsername(a.getUsername());
				bean.setBranch(a.getBranch());
				bean.setCompany_id(a.getCompany_id());
							
				
				beans.add(bean);
			}

		}
		return beans;
	}
	

	
	
}
