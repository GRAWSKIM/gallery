package com.std.sec.gallery;

import java.util.List;

import org.springframework.stereotype.Service;

public interface GalleryService {

	public int insertPicture(GalleryDto dto) throws Exception;
	public GalleryDto selectimg(GalleryDto dto) throws Exception;
	public List<GalleryDto> selectimglist(String username) throws Exception;
}
