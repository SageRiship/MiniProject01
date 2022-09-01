package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Plan;
import com.ashokit.entity.PlanCategory;
import com.ashokit.repo.PlanCategoryRepo;
import com.ashokit.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	private PlanRepo planrepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer,String> categoryMap = new HashMap<>();
		categories.forEach(cat->{
			categoryMap.put(cat.getCategoryId(), cat.getCategoryName());
		});
		// TODO Auto-generated method stub
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved = planrepo.save(plan);
		return saved.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planrepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planrepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		planrepo.save(plan); //if id present in body it is update method, if not it is save
		return plan.getPlanId() != null ;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			planrepo.deleteById(planId); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planrepo.findById(planId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(status);
			planrepo.save(plan);
			return true;
		}
		return false;
	}

}
