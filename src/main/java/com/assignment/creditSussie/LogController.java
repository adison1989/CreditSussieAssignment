package com.assignment.creditSussie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class LogController {

	@Autowired
	public LogDetailsService logDetailsService;

	@GetMapping("/logs")
	public List<LogDetails> getLogDetails() {
		
		return logDetailsService.fetchLogDetails();
	}

	@PostMapping("/logDetails/post")
	public void postLogDetails() {
		System.out.println("inside");
		String logFilePath = "logFile.txt";
		int num = logDetailsService.numberOfLines(logFilePath);
		try (Reader reader = new FileReader(logFilePath)) {
			Gson gson = new Gson();

			LogDetails[] logDetail = gson.fromJson(reader, LogDetails[].class);
			System.out.println(Arrays.toString(logDetail));

			for (LogDetails log : logDetail) {
				System.out.println(log);
				logDetailsService.saveLogDetails(log);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//public void deleteLog()

}
