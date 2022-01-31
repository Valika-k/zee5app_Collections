package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;

public interface UserRepository {
	
	public String addUser(Register register);
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers();
//	public Optional<List<Register>> getAllUsersList()
	//		throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public List<Register> getAllUserDetails();
	public String deleteUserById(String id) throws IdNotFoundException;
	//String updateUser(String id, TreeSet<Register> set) throws IdNotFoundException;

}
