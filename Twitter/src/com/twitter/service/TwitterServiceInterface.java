package com.twitter.service;

import java.util.List;

import com.twitter.entity.TimelineDetails;
import com.twitter.entity.TwitterUser;

public interface TwitterServiceInterface {

	int createProfileService(TwitterUser tu);

	List<TwitterUser> viewAllProfileService();

	TwitterUser viewProfileService(TwitterUser tu);

	int deleteProfileService(TwitterUser tu);

	int editProfileService(TwitterUser tu);

	List<TwitterUser> searchProfileService(TwitterUser tu);

	int createtimelineService(TimelineDetails tld);

	TwitterUser signInService(TwitterUser tu);

}
