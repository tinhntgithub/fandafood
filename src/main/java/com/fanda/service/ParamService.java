package com.fanda.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	ServletContext application;

	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;
	}

	public int getInt(String name, int defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Integer.parseInt(value);
	}

	public double getDouble(String name, double defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Double.parseDouble(value);
	}

	public boolean getBoolean(String name, boolean defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Boolean.parseBoolean(value);
	}

	public Date getDate(String name, String pattern) {
		String value = getString(name, "");
		try {
			return new SimpleDateFormat(pattern).parse(value);
		} catch (Exception e) {
			throw new RuntimeException();
			// TODO: handle exception
		}
	}

	public File save(MultipartFile file, String path) {
		if (!file.isEmpty()) {
			File file2 = new File(request.getServletContext().getRealPath(path));
			if (!file2.exists()) {
				file2.mkdir();
			}
			try {
				File saveFile = new File(file2, file.getOriginalFilename());

				file.transferTo(saveFile);

				return saveFile;
			} catch (Exception e) {
				throw new RuntimeException();
				// TODO: handle exception
			}
		}
		return null;
	}
}
