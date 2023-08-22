package com.bharath.springcloud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CouponRestController {

	@Autowired
	CouponRepo repo;

	@RequestMapping(value = "/coupons", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);

	}

	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}
	
	@RequestMapping(value = "/coupons", method = RequestMethod.GET)
	public List<Coupon> getCoupon(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/coupons/{id}", method = RequestMethod.DELETE)
	public void deleteCoupon(@PathVariable("id") Long id) {
		repo.deleteById(id);		
	}
	@RequestMapping(value = "/coupons/{id}", method = RequestMethod.PUT)
	public Coupon updateCoupon(@RequestBody Coupon c) {
		System.out.println("en put....");
		return repo.save(c);
		
		
	}
}
