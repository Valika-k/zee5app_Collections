package com.zee.zee5app;

import java.util.Iterator;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.impl.UserServiceImpl;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Main {

	public static void main(String[] args) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		UserService service = UserServiceImpl.getInstance();
		MovieService service1=MovieServiceImpl.getInstance();
		Register register = new Register();

		try {
			register.setFirstName("abhi");
			register.setLastName("chivate");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		register.setEmail("abhi@gmail.com");
		register.setPassword("abhi1234");
		try {
			register.setId("ab00001");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(register);
		
		System.out.println(register.toString());
	
		System.out.println(register.getEmail());

		
		for(int i=1;i<=20;i++) {
		
			Register register2 = new Register();
			try {
				register2.setId("ab0000"+i);
				register2.setFirstName("abhi"+i);
				register2.setLastName("chivate"+i);
				register2.setEmail("email"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			catch (Throwable e) {
				// TODO: handle exception
			}	
			
			register2.setPassword("abhi");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
		String result1=service.updateUser("ab00002", register);
		System.out.println(result1);
		
		String b=service.deleteUserById("ab00005");
		System.out.println();
		
		Optional<Register> optional;
		try {
			optional = service.getUserById("ab00001");
			if(optional.isPresent()) {
				
				System.out.println("getUserById"+optional.get());
			}
			else {
				System.out.println("id not found/available");
			}
			
		
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.getAllUserDetails().forEach(e->System.out.println(e));
		
		Movie movie = new Movie();
		movie.setId("m001");
		movie.setName("Robot");
		movie.setReleasedate("10/01/2020");
		movie.setLanguage("telugu");
		movie.setLength("150");
		movie.setCast("Xyz");
		
		
		String res = service1.addMovie(movie);
		
		String res1 = service1.deleteMovieById("m001");
		System.out.println(res);
		System.out.println(res1);

		

		
	}

}