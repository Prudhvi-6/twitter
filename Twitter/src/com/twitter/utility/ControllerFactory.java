package com.twitter.utility;

import com.twitter.controller.TwitterController;
import com.twitter.controller.TwitterControllerInterface;

public class ControllerFactory {

	public static TwitterControllerInterface createObject() {
		
		return new TwitterController();
	}

}
