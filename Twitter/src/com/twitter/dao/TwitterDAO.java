package com.twitter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twitter.entity.TimelineDetails;
import com.twitter.entity.TwitterUser;
import com.twitter.exception.UserDefinedException;

public class TwitterDAO implements TwitterDAOInterface {
	Connection con=null;
	public TwitterDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prudhvi");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public int createProfileDAO(TwitterUser tu) {
		int i=0;
		try {
			if(tu.getName().contentEquals("government")) {
				throw new UserDefinedException();
			}
			
			PreparedStatement ps=con.prepareStatement("insert into twitteruser values(?,?,?,?)");
			ps.setString(1, tu.getName());
			ps.setString(2, tu.getPassword());
			ps.setString(3, tu.getEmail());
			ps.setString(4, tu.getAddress());
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
				e.printStackTrace();
		}
		catch(UserDefinedException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public List<TwitterUser> viewAllProfileDAO() {
		List<TwitterUser> ll=new ArrayList<TwitterUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from twitteruser");
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				TwitterUser ts=new TwitterUser();
				ts.setName(n);
				ts.setPassword(p);
				ts.setEmail(e);
				ts.setAddress(a);
				ll.add(ts);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}
	public TwitterUser viewProfileDAO(TwitterUser tu) {
		TwitterUser t2=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from twitteruser where email=?");
			ps.setString(1, tu.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				t2=new TwitterUser();
				t2.setName(n);
				t2.setPassword(p);
				t2.setEmail(e);
				t2.setAddress(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return t2;
	}
	
	public int deleteProfileDAO(TwitterUser tu) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from twitteruser where email=?");
			ps.setString(1, tu.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	public int editProfileDAO(TwitterUser tu) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("update TwitterUser set name=?,password=?,address=? where email=?");
			ps.setString(1, tu.getName());
			ps.setString(2, tu.getPassword());
			ps.setString(4, tu.getEmail());
			ps.setString(3, tu.getAddress());
			i=ps.executeUpdate();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	
	
	}
	
	public List<TwitterUser> searchprofileDAO(TwitterUser tu) {
		TwitterUser t2=null;
		List<TwitterUser> ll=new ArrayList<TwitterUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from twitteruser where name=?");
			ps.setString(1, tu.getName());
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				t2=new TwitterUser();
				t2.setName(n);
				t2.setPassword(p);
				t2.setEmail(e);
				t2.setAddress(a);
				ll.add(t2);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ll;
	}
	
	public int createTimelineDAO(TimelineDetails tld) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into TimelineDetails values(?,?,?,?,?)");
			ps.setString(1, tld.getMessageid());
			ps.setString(2, tld.getSender());
			ps.setString(3, tld.getReceiver());
			ps.setString(4, tld.getMessage());
			ps.setString(5, tld.getDate1());
			i=ps.executeUpdate();
			System.out.println(i);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}
	
	public TwitterUser signInDAO(TwitterUser tu) {
		TwitterUser t=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from TwitterUser where email=? and password=?");
			ps.setString(1, tu.getEmail());
			ps.setString(2, tu.getPassword());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n= res.getString(1);
				String p= res.getString(2);
				String e= res.getString(3);
				String a= res.getString(4);
				t=new TwitterUser();
				t.setName(n);
				t.setPassword(p);
				t.setEmail(e);
				t.setAddress(a);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return t;
	}
	
}


