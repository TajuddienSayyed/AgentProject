package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearch{

	public static void main(String[] args) {
		AgentDao dao = new AgentDao();
		int agentid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent id Number  ");
		agentid = sc.nextInt();
		try {
			Agent rest = dao.searchAgent(agentid);
			if (rest!=null) {
				System.out.println(rest);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}