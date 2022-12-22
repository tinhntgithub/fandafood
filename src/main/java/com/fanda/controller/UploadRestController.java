package com.fanda.controller;


import java.io.File;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fanda.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;









@CrossOrigin("*")
@RestController
public class UploadRestController {

	@Autowired
	UploadService uploadService;
	
	@PostMapping("/rest/img/{folder}")
	public JsonNode upload(@PathParam("file") MultipartFile file,@PathVariable("folder")String folder) {
		File saveFile = uploadService.save(file,folder);
	
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", saveFile.getName());
		node.put("size", saveFile.length());
		
		System.out.println(saveFile);
		return node;
	}
	
	@DeleteMapping("/rest/img/product/{file}")
	public void delete(@PathVariable("file") String files ) {
		
		uploadService.delete("product", files);
	}
	
	
	
	@PostMapping("/mul/img/{folder}")
	public List<String> upload(@PathVariable("folder")String folder,@PathParam("file") MultipartFile [] files){
			for (MultipartFile multipartFile : files) {
				//System.out.println(multipartFile.getOriginalFilename());
			}
		return uploadService.saveMul(folder, files);
	}
}
