package com.java.agent;

import java.sql.SQLException;
import java.util.List;

public class AgentShow{

	public static void main(String[] args) {
		AgentDao dao = new AgentDao();
		try {
			List<Agent> RestList = dao.showAgent();
			for (Agent rest : RestList) {
				System.out.println(rest);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}