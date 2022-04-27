package com.java.agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.agent.Gender;
import com.java.agent.ConnectionHelper;





public class AgentDao {
	Connection con;
	PreparedStatement pst;
	public List<Agent> showAgent() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Agent";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> restList = new ArrayList<Agent>();
		Agent rest= null;
		while(rs.next()) {
			rest = new Agent();
			rest.setName(rs.getString("Name"));
			rest.setCity(rs.getString("City"));
			rest.setGender(Gender.valueOf(rs.getString("gender")));
			rest.setMaritalstatus(rs.getInt("MaritalStatus"));
			rest.setPremium(rs.getDouble("Premium"));
			//employ.setBasic(rs.getDouble("basic"));
			restList.add(rest);
		}
		return restList;
	}
	public String addAgent(Agent rest) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into Agent(Name,City,Gender,MaritalStatus,Premium)"
				+ " values(?,?,?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setString(1, rest.getName());
		pst.setString(2, rest.getCity());
		pst.setString(3,rest.getGender().toString());
		pst.setInt(4, rest.getMaritalstatus());
		pst.setDouble(5,rest.getPremium());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	public String updateAgent(Agent rest) throws ClassNotFoundException, SQLException {
		Agent restFound = searchAgent(rest.getAgentid());
		if (restFound!=null) {
			String cmd = "Update Agent set Name=?, City=?,GENDER=?,Maritalstatus=?,"+ "Premium=? Where AgentId=? ";
			pst = con.prepareStatement(cmd);
			pst.setString(1, rest.getName());
			pst.setString(2, rest.getCity());
			pst.setString(3,rest.getGender().toString());
			pst.setInt(4, rest.getMaritalstatus());
			pst.setDouble(5,rest.getPremium());
			pst.setInt(6, rest.getAgentid());
			pst.executeUpdate();
			return "Record Updated...";
		}
		return "Record Not Found...";
	}
public Agent searchAgent(int Agentid) throws ClassNotFoundException, SQLException {
	con = ConnectionHelper.getConnection();
	String cmd = "select * from Agent  where AgentId=?";
	pst = con.prepareStatement(cmd);
	pst.setInt(1,Agentid);
	ResultSet rs = pst.executeQuery();
	Agent  rest = null;
	if (rs.next()) {
		rest = new Agent();
		rest.setAgentid(rs.getInt("AgentId"));
		rest.setName(rs.getString("Name"));
		rest.setCity(rs.getString("City"));
		rest.setGender(Gender.valueOf(rs.getString("Gender")));
		rest.setMaritalstatus(rs.getInt("MaritalStatus"));
		rest.setPremium(rs.getDouble("Premium"));
		//employ.setBasic(rs.getDouble("basic"));			
	}
	return rest;
}
public String deleteAgent(int Agentid) throws ClassNotFoundException, SQLException {
	Agent rest = searchAgent(Agentid);
	if (rest!=null) {
		con = ConnectionHelper.getConnection();
		String cmd = "Delete From Agent where AgentId=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, Agentid);
		pst.executeUpdate();
		return "Record Deleted...";
	}
	return "Record Not Found...";
}

}
