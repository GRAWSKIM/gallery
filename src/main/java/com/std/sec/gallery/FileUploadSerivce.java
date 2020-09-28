package com.std.sec.gallery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadSerivce {

		private static final String SAVE_PATH = "/resources/picture";
		
		public GalleryDto restore(String username, MultipartFile multipartFile) {
			
			GalleryDto dto = new GalleryDto();
			
			String realpath = this.getClass().getResource("").getPath();			
			int offset = realpath.indexOf(".metadata");
			realpath = realpath.substring(0, offset);
			
			if(realpath.substring(0, 1).equals("\\")) {
				realpath = realpath.substring(1, realpath.length());
			}
			
			realpath+="\\gallery\\src\\main\\resources\\picture\\";
			
			try {
				// 파일 정보
				String originFilename = multipartFile.getOriginalFilename();
				String extName
					= originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
				Long size = multipartFile.getSize();
				
				// 서버에서 저장 할 파일 이름
				String saveFileName = genSaveFileName(extName);

				Date now= new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");						
				sdf.format(now);
				
				dto.setFilename(saveFileName);
				dto.setFileSize(size);
				dto.setUploadDate(sdf.format(now));
				dto.setUsername(username);
				
				writeFile(multipartFile,realpath, saveFileName);
				
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
			return dto;
		}
		
		
		// 현재 시간을 기준으로 파일 이름 생성
		private String genSaveFileName(String extName) {
			String fileName = "";
			
			Calendar calendar = Calendar.getInstance();
			fileName += calendar.get(Calendar.YEAR);
			fileName += calendar.get(Calendar.MONTH);
			fileName += calendar.get(Calendar.DATE);
			fileName += calendar.get(Calendar.HOUR);
			fileName += calendar.get(Calendar.MINUTE);
			fileName += calendar.get(Calendar.SECOND);
			fileName += calendar.get(Calendar.MILLISECOND);
			fileName += extName;
			
			return fileName;
		}
		
		
		// 파일을 실제로 write 하는 메서드
		private boolean writeFile(MultipartFile multipartFile,String realpath, String saveFileName) throws IOException{
			boolean result = false;

			byte[] data = multipartFile.getBytes();
			FileOutputStream fos = new FileOutputStream(realpath + saveFileName);
			fos.write(data);
			fos.close();
			
			return result;
		}
}
