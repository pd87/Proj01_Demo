package com.pd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.pd.beans.DTO;

public class Players_dao implements Player_inter{

	@Override
	public int insert(DTO dto) throws Exception{
		int count=0;
		String query="insert into emp values(?,?,?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjava","root","root");
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,dto.getEid());
		pst.setString(2,dto.getEname());
		pst.setInt(3,dto.getEsal());
		 count=pst.executeUpdate();
		
		return count;
	}

}
