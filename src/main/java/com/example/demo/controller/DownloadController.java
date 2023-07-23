package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.dto.IssuesDto;
import com.example.demo.rest.respone.BaseApiResponse;
import com.example.demo.services.impl.IssuesServiceImpl;
import com.example.demo.ustils.ExcelFileExporter;



import java.io.ByteArrayInputStream;
import org.apache.poi.util.IOUtils;
import org.modelmapper.ModelMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DownloadController {

	@Autowired
	private IssuesServiceImpl issuesServiceImpl;
	
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String time = dtf.format(now);

    @RequestMapping("/")
    public String index() {
        return "index";
    }
   

    @GetMapping("/download/excel/{iss_status}")
    public void downloadExcel(HttpServletResponse response, @PathVariable String iss_status) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Issues_" + time + ".xlsx");
        
        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(createTestDatas(iss_status));
        IOUtils.copy(stream, response.getOutputStream());
    }
    
    private List<IssuesDto> createTestDatas(String iss_status) {
    	
    	if("0".equals(iss_status)) {
    		List<IssuesDto> issuesDtos = issuesServiceImpl.findAll();
    		 return issuesDtos;
    	}else {
    		List<IssuesDto> issuesDtos = issuesServiceImpl.select2(iss_status);
    		 return issuesDtos;
    	}
       
    }
    
    
    
  
}