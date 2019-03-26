package com.com.com.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.com.com.util.FileUploadUtil;

@Controller
public class FlieController {

	
	@RequestMapping("fileup")
	public String fileUp(@RequestParam MultipartFile file) throws Exception {
		if (file.getSize() > 0 && file.getOriginalFilename().trim().length() > 0) {
			String path = "C:\\Spring\\upload";
			String f_name = file.getOriginalFilename();
			String c_name = FileUploadUtil.checkSameFileName(file.getOriginalFilename(), path);
			if(!f_name.equals(c_name)) {
				f_name = c_name;
			}
			file.transferTo(new File(path, f_name));   //DB에 첨부파일 table 있음  seq(올린시간을 쓸수도 있음 게시물이 가지는 정보) orignalname savename path date
		} else {
			System.out.println("파일 업로드 오류!!");
		}
		return "home";
	}
	
	@RequestMapping("filedown")
	public String fielDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dir = request.getParameter("dir");
		String filename =request.getParameter("fileName");
		String fullPath = dir+System.getProperty("file.separator")+filename;
		File f = new File(fullPath);
		byte[] b = new byte[2048];
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8").replaceAll("\\+", "%20"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		if(f.isFile()) {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			int count = -1;
			try {
				while((count = bis.read(b)) != -1) {
					bos.write(b,0,count);
					bos.flush();
				}			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(bos != null)
					bos.close();
				if(bis != null)
					bis.close();
			}
		}
		return "home";
	}
}
