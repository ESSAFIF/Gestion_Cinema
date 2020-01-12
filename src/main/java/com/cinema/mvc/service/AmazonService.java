package com.cinema.mvc.service;

import java.io.InputStream;
import java.net.URL;

public interface AmazonService {

	public URL  savePhoto(InputStream photo, String title) throws Exception;
}
