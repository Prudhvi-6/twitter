package com.twitter.dao;

import java.util.List;

import com.twitter.entity.TimelineDetails;
import com.twitter.entity.TwitterUser;

public interface TwitterDAOInterface {

	int createProfileDAO(TwitterUser tu);

	List<TwitterUser> viewAllProfileDAO();

	TwitterUser viewProfileDAO(TwitterUser tu);

	int deleteProfileDAO(TwitterUser tu);

	int editProfileDAO(TwitterUser tu);

	List<TwitterUser> searchprofileDAO(TwitterUser tu);

	int createTimelineDAO(TimelineDetails tld);

	TwitterUser signInDAO(TwitterUser tu);

	

}
