package com.example.springmvc.sevices;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.springmvc.models.User;

@Service
public class UserService {

	HashMap<Integer,User> data=new HashMap<>();
	AtomicInteger atomicInteger=new AtomicInteger();
	
	public void create(User user) {
		user.setId(atomicInteger.incrementAndGet());
		System.out.println(user);
		this.data.put(user.getId(), user);
		System.out.println(data);
	}
		
	public Collection<User> getAll(){
		return this.data.values();
	}
	
	public User getById(Integer id) {
		return this.data.get(id);
	}
	
	public void update(Integer id, User user) {
		user.setId(id);
		this.data.put(user.getId(), user);
	}
	public void delete(Integer id) {
		this.data.remove(id);
	}
	

	}


