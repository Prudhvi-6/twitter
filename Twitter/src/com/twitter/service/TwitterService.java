package com.twitter.service;

import com.twitter.utility.DAOFactory;

import java.util.List;

import com.twitter.dao.TwitterDAOInterface;
import com.twitter.entity.TimelineDetails;
import com.twitter.entity.TwitterUser;

public class TwitterService implements TwitterServiceInterface {
	TwitterDAOInterface td=null;
	
	public TwitterService() {
		td=DAOFactory.createObject();
		
	}


	public int createProfileService(TwitterUser tu) {
		
		
		return td.createProfileDAO(tu);
	}

	
	public List<TwitterUser> viewAllProfileService() {
	
		return td.viewAllProfileDAO();
	}


	public TwitterUser viewProfileService(TwitterUser tu) {
		TwitterUser s=td.viewProfileDAO(tu);
		
		return s;
	}


	
	public int deleteProfileService(TwitterUser tu) {
		int i=td.deleteProfileDAO(tu);
		
		return i;
	}


	
	public int editProfileService(TwitterUser tu) {
		int i=td.editProfileDAO(tu);
		
		return i;
	}


	
	public List<TwitterUser> searchProfileService(TwitterUser tu) {
		
		return td.searchprofileDAO(tu);
	}


	
	public int createtimelineService(TimelineDetails tld) {
		int i=td.createTimelineDAO(tld);
		
		return i;
	}


	
	public TwitterUser signInService(TwitterUser tu) {
		TwitterUser i=td.signInDAO(tu);
		
		return i;
	}

}
