package com.twitter.utility;

import com.twitter.dao.TwitterDAO;
import com.twitter.dao.TwitterDAOInterface;

public class DAOFactory {

	public static TwitterDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new TwitterDAO();
	}

}
