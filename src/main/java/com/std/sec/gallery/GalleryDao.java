package com.std.sec.gallery;

import java.util.HashMap;
import java.util.List;

public interface GalleryDao {
	public int insertPicture(GalleryDto dto) throws Exception;
	public GalleryDto selectimg(GalleryDto dto) throws Exception;
	public List<GalleryDto> selectimglist(HashMap<String, String> map) throws Exception;
}
