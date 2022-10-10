package com.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// public final String UPLOAD_DIR =
	// "D:\\SpringProject\\bootrestbook\\src\\main\\resources\\static\\image";
	// public final String UPLOAD_DIR = new
	// ClassPathResource("static/image/").getFile().getAbsolutePath();

	public final String UPLOAD_DIR = Paths.get("src/main/resources/static/image").toAbsolutePath().toString();

	public FileUploadHelper() throws IOException {

	}

	public boolean uploadFile(MultipartFile multipartfile) {
		boolean f = false;
		try {
			/*
			 * InputStream io = multipartfile.getInputStream(); byte data[] = new
			 * byte[io.available()]; io.read(data); // write FileOutputStream fos = new
			 * FileOutputStream( UPLOAD_DIR + File.separator +
			 * multipartfile.getOriginalFilename()); fos.write(data); fos.flush();
			 * fos.close();
			 */
			Files.copy(multipartfile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartfile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
