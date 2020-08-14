package com.documentweb.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.documentweb.entities.Document;
import com.documentweb.repos.DocumentRepository;

@Controller
public class DocumentController {
	@Autowired
	DocumentRepository repo;
	
	@RequestMapping("displayUpload")
	public String displayUpload() {
		return "documentupload";
	}
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile,@RequestParam("id") long id) {
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getName());
		try {
			document.setData(multipartFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repo.save(document);
		return "documentupload";
	}
}
