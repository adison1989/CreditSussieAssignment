package com.assignment.creditSussie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogDetailsService {

	@Autowired
	public LogRepository logRepository;

	public LogDetailsService() {

	}

	public List<LogDetails> fetchLogDetails() {

		return logRepository.findAll();

	}

	public void saveLogDetails(LogDetails logDetails) {

		 logRepository.save(logDetails);
	}

	public int numberOfLines(String filePath) {
		
			File file = new File(filePath);
			FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			byte[] byteArray = new byte[(int) file.length()];
			fis.read(byteArray);
			String data = new String(byteArray);
			String[] stringArray = data.split("\r\n");
			System.out.println("Number of lines in the file are ::" + stringArray.length);
			if(fis!=null) {
				fis.close();
			}
			return stringArray.length;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
