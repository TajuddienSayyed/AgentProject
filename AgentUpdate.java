package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentUpdate {

	public static void main(String[] args) {
		Agent rest = new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agentid   ");
		rest.setAgentid(sc.nextInt());
		System.out.println("Enter Agent Name   ");
		rest.setName(sc.next());
		System.out.println("Enter Agent city  ");
		rest.setCity(sc.next());
		System.out.println("Enter Gender  ");
        String gen=sc.next();
		
		if(gen.equals("MALE"))
		{
			rest.setGender(Gender.MALE);
		}
		if(gen.equals("FEMALE"))
		{
			rest.setGender(Gender.FEMALE);
		}
		System.out.println("Enter Marital Status  ");
		rest.setMaritalstatus(sc.nextInt());
		System.out.println("Enter Premium ");
		rest.setPremium(sc.nextDouble());
		AgentDao dao = new AgentDao();
		try {
			System.out.println(dao.updateAgent(rest));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}