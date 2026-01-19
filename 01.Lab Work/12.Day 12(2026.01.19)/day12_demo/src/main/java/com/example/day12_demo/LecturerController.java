package com.example.day12_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all-lecturers")
public class LecturerController {
	
	//Defing Local Variable
	private List<String>  lectrers = new ArrayList<String>();
	
	//END POINT1
	@GetMapping("/university-info")
	public String getUniversityInfo() {
		return "South Eastern University of Sri Lanka";
	}
	
	//END POINT 2
	@GetMapping("/lectureId/{id}")
	public String updateLecurerId(@PathVariable("id") int lectuerId) {
		return "Successfully update lecturer Id: "+lectuerId;
	}
	
	//END POINT 3
	@GetMapping("/lectureName/{name}")
	public String updateLecurerName(@PathVariable("name") String lecturerName) {
		return "Successfully update lecturer name: " + lecturerName;
	}
	
	//END POINT 4
	@PostMapping("/lecturer")
	public String addLecturer(@RequestParam int id,@RequestParam String department,@RequestParam String name) {
		String lecturer = id+"|"+name+"|"+department;
		lectrers.add(lecturer);
		return "Lecturer Add successfully";
	}
	
	//END POINT 5
	@PostMapping("/add-lecturer")
	public String addLecturer2(@RequestBody Map<String,Object>body) {
		int id =(Integer)body.get("id");
		String name =(String)body.get("name");
		String department =(String)body.get("department");
		String lecturer = id+"|"+name+"|"+department;
		lectrers.add(lecturer);
		return "Lecturer Added successfully";
	}
	
	// END POINT 6 
	@GetMapping("/lecturers")
	public List<String> getAllLecturers() {
	    return lectrers;
	}
	
	// END POINT 7 
	@PutMapping("/update-lecturer/{id}")
	public String updateLecturer(
	        @PathVariable int id,
	        @RequestParam String name,
	        @RequestParam String department) {

	    for (int i = 0; i < lectrers.size(); i++) {
	        String[] data = lectrers.get(i).split("\\|");
	        int lecturerId = Integer.parseInt(data[0]);

	        if (lecturerId == id) {
	            lectrers.set(i, id + "|" + name + "|" + department);
	            return "Lecturer updated successfully";
	        }
	    }
	    return "Lecturer not found";
	}
	
	// END POINT 8 
	@DeleteMapping("/delete-lecturer/{id}")
	public String deleteLecturer(@PathVariable int id) {

	    for (int i = 0; i < lectrers.size(); i++) {
	        String[] data = lectrers.get(i).split("\\|");
	        int lecturerId = Integer.parseInt(data[0]);

	        if (lecturerId == id) {
	            lectrers.remove(i);
	            return "Lecturer deleted successfully";
	        }
	    }
	    return "Lecturer not found";
	}
	
	// END POINT 9
	@PutMapping("/update-lecturer2")
	public String updateLecturer2(@RequestBody Map<String, Object> body) {

	    int id = (Integer) body.get("id");
	    String name = (String) body.get("name");
	    String department = (String) body.get("department");

	    for (int i = 0; i < lectrers.size(); i++) {
	        String[] data = lectrers.get(i).split("\\|");
	        int lecturerId = Integer.parseInt(data[0]);

	        if (lecturerId == id) {
	            lectrers.set(i, id + "|" + name + "|" + department);
	            return "Lecturer updated successfully";
	        }
	    }
	    return "Lecturer not found";
	}
	
	//END POINT 10
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Iterator<String> iterator = lectrers.iterator();
		while(iterator.hasNext()) {
			String l =iterator.next();
			if(l.startsWith(id+"|")) {
				iterator.remove();
				return "lecturer delete successfully";
			}
		}
		return "lecturer not found!";
	}



}


