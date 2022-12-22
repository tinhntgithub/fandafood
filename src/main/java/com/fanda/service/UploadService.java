package com.fanda.service;


import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface UploadService {

	File save(MultipartFile file, String folder);

	void delete(String folder, String files);
	
	 List<String> saveMul(String folder, MultipartFile[] files);


}
