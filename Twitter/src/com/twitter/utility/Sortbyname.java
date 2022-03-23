package com.twitter.utility;

import java.util.Comparator;

import com.twitter.entity.TwitterUser;

public class Sortbyname implements Comparator<TwitterUser>{

	
	public int compare(TwitterUser u1, TwitterUser u2) {
		return u1.getName().compareTo(u2.getName());
	}

}
