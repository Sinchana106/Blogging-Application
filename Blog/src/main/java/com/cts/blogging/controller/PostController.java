package com.cts.blogging.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.blogging.dto.PostDto;
import com.cts.blogging.exception.TokenNotValidException;
import com.cts.blogging.feign.AuthFeign;
import com.cts.blogging.model.PostModel;
import com.cts.blogging.service.PostService;

@RestController
@RequestMapping("blog")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

	@Autowired
	private AuthFeign authFeign;
	@Autowired
	private PostService postService;
	final static Logger log = LoggerFactory.getLogger(PostController.class);
	public ResponseEntity<Boolean> validate(String token) {
		log.debug("1");
		return  authFeign.validate(token);
	}
	@PostMapping("/post")
	public ResponseEntity<PostModel> createPost(@RequestHeader(name = "Authorization") String token, @RequestBody PostDto postDto) {
		if(validate(token).getBody()) {
			log.debug("2");
			
			return new ResponseEntity(postService.createPost(postDto),HttpStatus.CREATED);
		}
		else {
			throw new TokenNotValidException("Token not valid");
		}
	}
	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> showAllPost(@RequestHeader(name = "Authorization") String token) {
		System.out.println(validate(token).getBody());
		if(validate(token).getBody()) {
			List<PostDto> dtos=postService.getAllPost();
			return new ResponseEntity(dtos,HttpStatus.OK);
		}
		else {
			throw new TokenNotValidException("Token not valid");
		}
	}
	@GetMapping("/post/{id}")
	public ResponseEntity<PostDto> showPostById(@RequestHeader(name = "Authorization") String token,@PathVariable int id) {
		if(validate(token).getBody()) {
			PostDto dto=postService.getPostById(id);
			System.out.println(dto.toString());
			return new ResponseEntity<PostDto>(dto,HttpStatus.OK);
		}
		else {
			throw new TokenNotValidException("Token not valid");
		}
	}
}
