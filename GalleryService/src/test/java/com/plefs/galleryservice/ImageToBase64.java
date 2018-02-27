package com.plefs.galleryservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;

public class ImageToBase64 {

	public static void main(String[] args) {
		File f = new File("C:/Users/steffin.joseph/Desktop/Chunchi_Falls.jpeg");
		String encodstring = encodeFileToBase64Binary(f);
		System.out.println(encodstring);
		writeToImage(encodstring);
	}

	private static String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
		} catch (FileNotFoundException e) {
			try {
				fileInputStreamReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			try {
				fileInputStreamReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return encodedfile;
	}

	private static void writeToImage(String crntImage) {
		byte[] data = Base64.decodeBase64(crntImage);
		try (OutputStream stream = new FileOutputStream("C:/Users/steffin.joseph/Desktop/Mail/decoded.bmp")) {
			stream.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
