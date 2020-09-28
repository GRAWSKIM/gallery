package com.std.sec;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.std.sec.gallery.FileUploadSerivce;
import com.std.sec.gallery.GalleryDto;
import com.std.sec.gallery.GalleryService;


@Controller
public class GalleryController {

	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@Autowired
	FileUploadSerivce fileUploadService;
	
	@Autowired
	GalleryService galleryService;
	
	@RequestMapping(value = "/gallery/gallery.do", method = RequestMethod.GET)
	public String entrance_gallery(Model model) throws Exception {
		logger.info("entrance_my_gallery.");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		List<GalleryDto> list = galleryService.selectimglist(auth.getName());
		model.addAttribute("List", list);
		model.addAttribute("Path", getRealPath());
		
		return "/gallery/gallery";
	}
	
	@RequestMapping(value = "/gallery/fileupload.do",method = RequestMethod.POST)
	public String upload(
			Model model,			
			@RequestParam("uploadfile") MultipartFile file) throws Exception {		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		GalleryDto dto = fileUploadService.restore(auth.getName(),file);
		if(dto == null) {
			model.addAttribute("msg", "uplaod failed");
		}
		
		if( galleryService.insertPicture(dto) == 1) {
			model.addAttribute("msg", "uplaod success");
		}else {
			model.addAttribute("msg", "insert uplaod info failed");
		}
		
		return "redirect:gallery.do";
	}
	
	@RequestMapping(value = "/gallery/popup.do",method = RequestMethod.GET)
	public String popup(Model model,
			@RequestParam("username") String username,
			@RequestParam("filename") String filename) throws Exception {
		logger.info("popup controller");
		GalleryDto dto = new GalleryDto();
		dto.setUsername(username);
		dto.setFilename(filename);
		;
		model.addAttribute("dto", galleryService.selectimg(dto));
		model.addAttribute("Path", getRealPath());
		return "/gallery/popup";
	}
	
	
	public String getRealPath() {
		String realpath = this.getClass().getResource("").getPath();			
		int offset = realpath.indexOf(".metadata");
		realpath = realpath.substring(0, offset);
		
		realpath= realpath.replace("/", "\\");
		
		if(realpath.substring(0, 1).equals("\\")) {
			realpath = realpath.substring(1, realpath.length());
		}
		if(realpath.substring(realpath.length()-1, realpath.length()).equals("\\")) {
			realpath = realpath.substring(0, realpath.length()-1);
		}
		
		realpath+="\\gallery\\src\\main\\resources\\picture\\";
		
		return realpath;
	}
}
