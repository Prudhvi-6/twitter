package com.twitter.controller;
import java.util.List;
import java.util.Collections;

import java.util.Scanner;
import java.util.logging.Logger;

import com.twitter.entity.TimelineDetails;
import com.twitter.entity.TwitterUser;
import com.twitter.service.TwitterServiceInterface;
import com.twitter.utility.ServiceFactory;
import com.twitter.utility.Sortbyname;

public class TwitterController implements TwitterControllerInterface {
	Logger log=Logger.getLogger("TwitterController");
	TwitterServiceInterface ts=null;
	
	public TwitterController(){
		ts=ServiceFactory.createObject();
	}

	
	public int createProfileController() {
		Scanner sc=new Scanner(System.in);
		log.info("enter your name");
		String name=sc.next();
		log.info("enter your password");
		String password=sc.next();
		log.info("enter your email");
		String email=sc.next();
		log.info("enter your address");
		String address=sc.next();
		TwitterUser tu=new TwitterUser();
		tu.setName(name);
		tu.setPassword(password);
		tu.setEmail(email);
		tu.setAddress(address);
		
		int i=ts.createProfileService(tu);
		if(i>0) {
			log.info("profile created");
		}
		else {
			log.info("could not create profile");
		}
		return i;
		
	}

	
	public int viewAllProfileController() {
		int i=0;
		List<TwitterUser> ll=ts.viewAllProfileService();
		System.out.println(ll.size()+"record found in database");
		
		
		ll.forEach(s->{
			System.out.println("********************");
			
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		System.out.println("*******After Sorting********");
		Collections.sort(ll,new Sortbyname());
		ll.forEach(s->{
			System.out.println("********************");
			
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		
		
		return i;
	}
		
	public int viewProfileController() {
		Scanner sc=new Scanner(System.in);
		int i=0;
		log.info("enter email to view profile");
		String email=sc.next();
		TwitterUser tu=new TwitterUser();
		tu.setEmail(email);
		TwitterUser t1=ts.viewProfileService(tu);
		if(t1!=null) {
			System.out.println("Name is "+t1.getName());
			System.out.println("Password is "+t1.getPassword());
			System.out.println("Email is "+t1.getEmail());
			System.out.println("Address is "+t1.getAddress());
		}
		else {
			log.info("profile not found");
		}
		return i;
	}
	public int deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		int i=0;
		
		log.info("enter email to delete profile");
		String email=sc.next();
		TwitterUser tu=new TwitterUser();
		tu.setEmail(email);
		int s1=ts.deleteProfileService(tu);
		if(s1>0) {
			log.info("Profile deleted");
		}
		else {
			log.info("could not delete profile");
		}
		return i;
		
	}


	
	public int editProfileController() {
		log.info("your old data");
		viewProfileController();
		Scanner sc=new Scanner(System.in);
		log.info("enter new name");
		String name=sc.next();
		log.info("enter new password");
		String password=sc.next();
		log.info("enter old email");
		String email=sc.next();
		log.info("enter new address");
		String address=sc.next();
		TwitterUser tu=new TwitterUser();
		tu.setName(name);
		tu.setPassword(password);
		tu.setEmail(email);
		tu.setAddress(address);
		
		int i=ts.editProfileService(tu);
		if(i>0) {
			System.out.println("your profile is edited "+name);
		}
		else {
			System.out.println("your profile is not edited");
		}
		return i;
		
		
	}


	
	public int searchProfileController() {
		Scanner sc=new Scanner(System.in);
		int i=0;
		log.info("enter name to search profile");
		String name=sc.next();
		TwitterUser tu=new TwitterUser();
				tu.setName(name);
		List<TwitterUser>ll=ts.searchProfileService(tu);
		ll.forEach(s->{
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
		});
		return i;
		}


	
	public int createTimelineController() {
		Scanner sc=new Scanner(System.in); 
		log.info("Enter Message ID: ");
		String messageid = sc.next();
		log.info("Enter Sender ID: ");
		String sender = sc.next();
	    log.info("Enter Receiver ID: ");
		String receiver = sc.next();
		log.info("Enter Message: ");
		String message = sc.next();
		log.info("Enter Date1: ");
		String date1 = sc.next();
		TimelineDetails tld=new TimelineDetails();
		tld.setMessageid(messageid);
		tld.setSender(sender);
		tld.setReceiver(receiver);
		tld.setMessage(message);
		tld.setDate1(date1);
		int i=ts.createtimelineService(tld);
		if(i>0) {
			System.out.println("Your timeline is Updated");
			}
		else {
			System.out.println("Unable to create timeline");
		}
		return i;
	}


	
	public TwitterUser signInController() {
		Scanner sc=new Scanner(System.in);
		log.info("Enter email: ");
		String email=sc.next();
		log.info("Enter Password: ");
		String password=sc.next();
		TwitterUser tu=new TwitterUser();
		tu.setEmail(email);
		tu.setPassword(password);
		TwitterUser i=ts.signInService(tu);
		if(i!=null) {
			System.out.println("*****************");
			System.out.println("Welcome to Twitter "+i.getName());
			System.out.println("*****************");
		}
		else {
			System.out.println("Unable to SignIn....");
		}
		
		return i;
	}
}
	
		
		
		
	
				


