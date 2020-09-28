package com.std.sec.gallery;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDaoImpl implements GalleryDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertPicture(GalleryDto dto) throws Exception {
		return sqlSession.insert("user.insertPictureInfo",dto);
	}

	@Override
	public GalleryDto selectimg(GalleryDto dto) throws Exception {
		return sqlSession.selectOne("user.selectimg",dto);
	}

	@Override
	public List<GalleryDto> selectimglist(HashMap<String, String> map ) throws Exception {
		return sqlSession.selectList("user.selectimglist",map);
	}

}
