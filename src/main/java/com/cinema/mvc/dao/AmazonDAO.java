package com.cinema.mvc.dao;
import java.io.InputStream;
import java.net.URL;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonDAO {

	public URL  savePhoto( InputStream photo ,String title) throws Exception;
	}
