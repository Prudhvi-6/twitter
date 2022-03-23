package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.controller.TwitterController;
import com.twitter.controller.TwitterControllerInterface;
import com.twitter.entity.TwitterUser;
import com.twitter.service.TwitterServiceInterface;

public class ControllerTest {
	TwitterControllerInterface tc=null;
	

	@Before
	public void setUp() throws Exception {
		tc=new TwitterController();
		
	}

	@After
	public void tearDown() throws Exception {
		tc=null;
	}

	
	@Test
	public void testCreateProfileController() {
		int i=tc.createProfileController();
		assert i>0:"test fail to create profile";
	}

	@Test
	public void testViewAllProfileController() {
		int i=tc.viewAllProfileController();
		assert i>0:"test case failed ";
		
	}

	@Test
	public void testViewProfileController() {
		int i=tc.viewProfileController();
		assert i>0:"test case failed";
		
	}

	@Test
	public void testDeleteProfileController() {
		int i=tc.deleteProfileController();
		assert i>0:"test case failed";
		
	}

	@Test
	public void testEditProfileController() {
		int i=tc.editProfileController();
		assert i>0:"test case failed";
	}

	@Test
	public void testSearchProfileController() {
		int i=tc.searchProfileController();
		assert i>0:"test case failed";
	}

	@Test
	public void testCreateTimelineController() {
		int i=tc.createTimelineController();
		assert i>0:"test case failed";
	}

	
	}


