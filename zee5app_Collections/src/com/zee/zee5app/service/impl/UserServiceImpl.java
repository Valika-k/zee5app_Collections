package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;

import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {
	
	
	private static UserService service;
	
	public static UserService getInstance() {
		
		if(service==null) {
			service = new UserServiceImpl();
		}
		
		return service;
	}
	
	//UserRepository userRepository ;

	UserRepository userRepository  =  UserRepositoryImpl.getInstance();
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.updateUser( id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}

	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		return userRepository.getAllUserDetails();
	}

}
