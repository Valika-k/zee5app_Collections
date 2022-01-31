package com.zee.zee5app.dto;


import lombok.Data;

@Data
public class Subscription {


		 
		private String id;
		private String dateOfPurchase;
		private String status;
		private String country;
		private String paymentMode;
		private String autorenewal;
		private String expirydate;
		
//		public Subscription()
//		{
//			System.out.println("hello ");
//		}

}
