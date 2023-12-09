package com.example.task1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public class HashMapResponseController {
	
	@GetMapping("/response")
	public ResponseEntity<Map<String,String>> getResponse(){
		Map<String,String> message=new HashMap<>();
		message.put("Mayank", "Development");
		message.put("Siya", "Testing");
		return  ResponseEntity.ok(message);
	}

}
