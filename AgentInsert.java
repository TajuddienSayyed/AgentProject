package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentInsert {

	public static void main(String[] args) {
		Agent rest1 = new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name   ");
		rest1.setName(sc.next());
		System.out.println("Enter city  ");
		rest1.setCity(sc.next());
		System.out.println("Enter Gender  ");
		String gen=sc.next();
		
		if(gen.equals("MALE"))
		{
			rest1.setGender(Gender.MALE);
		}
		if(gen.equals("FEMALE"))
		{
			rest1.setGender(Gender.FEMALE);
		}
		System.out.println("Enter Marital Status  ");
		rest1.setMaritalstatus(sc.nextInt());
		System.out.println("Enter Premium ");
		rest1.setPremium(sc.nextDouble());
		AgentDao dao = new AgentDao();
		try {
			System.out.println(dao.addAgent(rest1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}