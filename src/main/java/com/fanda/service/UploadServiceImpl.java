package com.fanda.service;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	ServletContext app;
	
	private Path getPath(String folder, String name) {
		File file = Paths.get(app.getRealPath("/img/"), folder).toFile();
		if (!file.exists()) {
			file.mkdirs();
		}

		return Paths.get(file.getAbsolutePath(), name);
	}


	@Override
	public File save(MultipartFile file, String folder) {
		File dir = new File(app.getRealPath("/img/" + folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savedFile = new File(dir, name);
			file.transferTo(savedFile);
		//	System.out.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(String folder, String files) {
		Path path = this.getPath(folder, files);
		path.toFile().delete();
		
	}
	
	@Override
	public List<String> saveMul(String folder, MultipartFile[] files) {
		List<String> filenames = new ArrayList<String>();
		File dir = new File(app.getRealPath("/img/"+folder));

		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		for (MultipartFile file : files) {
			String s = System.currentTimeMillis() + file.getOriginalFilename();
			String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		
			Path path = this.getPath(folder, name);
			try {
				File saveFile = new File(dir , name);				
				file.transferTo(saveFile);
			//	System.out.println(saveFile.getAbsolutePath());
				filenames.add(name);
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		return filenames;
	}




}
