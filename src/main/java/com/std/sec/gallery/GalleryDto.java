package com.std.sec.gallery;

public class GalleryDto {

	private String username;
	private Long fileSize;
	private String uploadDate;
	private String filename;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long size) {
		this.fileSize = size;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "GalleryDto [username=" + username + ", fileSize=" + fileSize + ", uploadDate=" + uploadDate
				+ ", filename=" + filename + "]";
	}
	
	
}
