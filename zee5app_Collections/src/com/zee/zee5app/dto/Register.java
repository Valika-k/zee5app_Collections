package com.zee.zee5app.dto;

import java.util.Objects;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@AllArgsConstructor
//@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
public class Register implements Comparable<Register> {
	 
	public Register(String id, String firstname, String lastname, String email, String password, String aadharCard) throws InvalidIdLengthException, InvalidNameException {
		super();
		this.setId( id);
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.email = email;
		this.password = password;
		this.aadharCard = aadharCard;
	}


	@Setter(value =AccessLevel.NONE)
	private String id;
	//we have to write a code to validate the length of 6 characters and then assign.
	public void setFirstName(String firstName) throws InvalidNameException  {
		if(firstName==null || firstName=="" || firstName.length()<2) {
			throw new InvalidNameException("first name is not valid");
		}
		this.firstname=firstName;
	}
	
	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName=="" || lastName.length()<2) {
			throw new InvalidNameException("last name is not valid");
		}
		this.lastname=lastName;
	}
	
	
	public void setId(String id) throws InvalidIdLengthException {
		//throws- provides list if exceptions that may be raised and holds list of checked exceptions.
		if(id.length()<6) {
			//it should raise the InvalidIdException
			//Exception object is created by JVM.
			//user defined exception must be raised by us
			
			throw new InvalidIdLengthException("id length is less than or equal to 6");
			//throw: it will throw the exception
			
		}
		this.id = id;
	}
	
	
	@Setter(value =AccessLevel.NONE)
	private String firstname;
	@Setter(value =AccessLevel.NONE)
	private String lastname;
	private String email;
	private String password;
	private String aadharCard;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(aadharCard, other.aadharCard) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(id, other.id)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(aadharCard, email, firstname, id, lastname, password);
//	}
	
	public int compareTo(Register o) {
		return this.id.compareTo(o.getId());
	}

	//setter- to set the value for a particular field
	//getter- to get/return the value
}
