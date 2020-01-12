package com.cinema.mvc;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {



	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		URL u = new URL("http://www.example.com/");
		String var=u.toString();
		System.out.println("result:" +var);
	}

}
