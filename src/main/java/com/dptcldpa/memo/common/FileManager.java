package com.dptcldpa.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {

	public static final String FILE_UPLOAD_PATH = "E:\\HM\\springProject\\upload\\memo";
	
	public static String saveFile(int userId, MultipartFile file) {
		
		if(file == null) {
			return null;
		}
		
		// 파일 이름 유지
		// 같은 이름의 파일이 전달 될 경우를 대비해서 디렉토리를 만들어서 파일 저장
		// 디렉토리 이름에 사요자 정보 포함
		// 시간을 디렉토리 이름에 포함
		// UNIX TIME : 1970년 1월 1일 부터 흐른시간을 millisecond(1 / 1000초)로 표현한 값
		// ex) 2_54456453
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 디렉토리 만들기
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath);
		
		if(!directory.mkdir()) {
			// 디렉토리 생성 실패
			return null;
		}
		
		// 파일 저장
		String filePath = directoryPath + "/" + file.getOriginalFilename();
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath);
			
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			// 파일 저장 실패
			return null;
			
		}
		
		// E:\\HM\\springProject\\upload\\memo/2_54456453/test.png
		
		// /images/2_54456453/test.png
		return "/images" + directoryName + "/" + file.getOriginalFilename();
		
	}
	
}