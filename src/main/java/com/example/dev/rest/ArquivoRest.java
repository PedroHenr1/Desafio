package com.example.dev.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.dev.domain.Type;

import com.example.dev.domain.UploadInfo;

@RestController
@RequestMapping("/app")
public class ArquivoRest
{

	@PostMapping("/arquivo")
	public ResponseEntity<UploadInfo> arquivo_upload(@RequestParam String tipo, @RequestParam MultipartFile arquivo) throws ParseException
	{
		//String file_type = FilenameUtils.getExtension(arquivo.getOriginalFilename());
		//String verify = Type.file_verify(file_type);
		Date data = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String check = dateFormat.format(data);
	    String test = Type.file_verify(tipo);
	    
		UploadInfo info = new UploadInfo(arquivo.getOriginalFilename(), check, test);
		
		return ResponseEntity.ok(info);
		
	}
}
