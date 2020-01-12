package com.cinema.mvc.service;

import java.io.InputStream;
import java.net.URL;

import org.springframework.transaction.annotation.Transactional;

import com.cinema.mvc.dao.AmazonDAO;


@Transactional
public class AmazonServiceImpl implements AmazonService {
	
	private AmazonDAO dao;
	
	@Override
	public URL savePhoto(InputStream photo, String title) throws Exception {
		return dao.savePhoto(photo, title);
	}

	public AmazonDAO getDao() {
		return dao;
	}
	public void setDao(AmazonDAO dao) {
		this.dao = dao;
	}
}
