package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentDelete {

	public static void main(String[] args) {
		int Agentid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent id   ");
		Agentid=sc.nextInt();
		AgentDao dao= new AgentDao();
		try {
			System.out.println(dao.deleteAgent(Agentid));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}