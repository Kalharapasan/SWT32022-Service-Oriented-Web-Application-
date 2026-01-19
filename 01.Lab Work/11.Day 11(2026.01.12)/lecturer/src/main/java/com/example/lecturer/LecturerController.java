package com.example.lecturer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LecturerController {
	
	@GetMapping("/university-info")
	public String getUniversityInfo() {
		return "South Eastern University of Sri Lanka";
	}

}
