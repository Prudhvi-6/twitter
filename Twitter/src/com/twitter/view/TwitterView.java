package com.twitter.view;
import java.util.Scanner;

import com.twitter.controller.TwitterControllerInterface;
import com.twitter.entity.TwitterUser;
import com.twitter.utility.ControllerFactory;

public class TwitterView {

	public static void main(String[] args) {
		String s="y";
		Scanner sc=new Scanner(System.in);
		
		while(s.equals("y")) {
			System.out.println("************************");
			System.out.println("Welcome to Twitter");
			System.out.println("************************");
			System.out.println("Press 1 to SignUp");
			System.out.println("Press 2 to SignIn");
			System.out.println("************************");
			System.out.println("enter your choice");
			
			int ch=sc.nextInt();
			TwitterControllerInterface tw=ControllerFactory.createObject();
			TwitterUser si;
			switch(ch) {
			case 1:tw.createProfileController();
			break;
			case 2:si=tw.signInController();
			if(si!=null) {
				while(s.contentEquals("y")) {
					
					System.out.println("press 1 to view all profile");
					System.out.println("press 2 to view profile");
					System.out.println("press 3 to delete profile");
					System.out.println("press 4 to edit profile");
					System.out.println("press 5 to search profile");
					System.out.println("press 6 to create timeline");
					System.out.println("Select an Operation");
					int c=sc.nextInt();
					switch(c) {
					
					case 1: tw.viewAllProfileController();
					break;
					case 2: tw.viewProfileController();
					break;
					case 3: tw.deleteProfileController();
					break;
					case 4: tw.editProfileController();
					break;
					case 5: tw.searchProfileController();
					break;
					case 6: tw.createTimelineController();
					break;
					
					 default:System.out.println("wrong choice");
					}

					System.out.println("press y if you wanna see the operations again");
					s=sc.next();
					
					
				}
			}
			else {
				System.out.println("You are not on Twitter,please create your profile");
			}
			break;
			default:
				System.out.println("choose between 1 and 2");
		
			
			
			}
			System.out.println("press y to show the Twitter Main Menu");
			s=sc.next();
			
			}
		}
	}
				
			
			
			
			
			
			
			
			
		
			
			
	
			
		

	


