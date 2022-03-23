package com.twitter.controller;

import com.twitter.entity.TwitterUser;

public interface TwitterControllerInterface {

	int createProfileController();

	int viewAllProfileController();

	int viewProfileController();

	int deleteProfileController();

	int editProfileController();

	int searchProfileController();

	int createTimelineController();

	TwitterUser signInController();

	

}
