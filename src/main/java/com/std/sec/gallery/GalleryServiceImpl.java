package com.std.sec.gallery;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl implements GalleryService{

	@Autowired
	private GalleryDao dao;
	
	@Override
	public int insertPicture(GalleryDto dto) throws Exception {		
		return dao.insertPicture(dto);
	}

	@Override
	public GalleryDto selectimg(GalleryDto dto) throws Exception {
		return dao.selectimg(dto);
	}

	@Override
	public List<GalleryDto> selectimglist(String username) throws Exception {
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("username", username);
		return dao.selectimglist(map);
	}

}
