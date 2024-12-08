package com.example.jwt_token_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_token_app.jwt.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("home")
public class HomeController {

	@Autowired
	private JwtUtils jwtUtils;



	@GetMapping("")
	public ResponseEntity<?> home(){
		String token = jwtUtils.generateToken("rohan");
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}

	@GetMapping("isValid")
	public ResponseEntity<?> isValid(HttpServletRequest request){

		String authHeader = request.getHeader("Authorization");
		String token = null;
		if(authHeader != null && authHeader.startsWith("Bearer ")){
			token = authHeader.substring(7);
		}

		if(jwtUtils.validateToken(token)) {
			return new ResponseEntity<String>("Token Valid", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Token not valid", HttpStatus.BAD_REQUEST);	
	}


}