package com.twitter.utility;

import com.twitter.service.TwitterService;
import com.twitter.service.TwitterServiceInterface;

public class ServiceFactory {

	public static TwitterServiceInterface createObject() {
		
		return new TwitterService();
	}

}
