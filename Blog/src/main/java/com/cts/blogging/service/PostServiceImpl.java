package com.cts.blogging.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.blogging.dto.PostDto;
import com.cts.blogging.exception.PostNotFound;
import com.cts.blogging.feign.AuthFeign;
import com.cts.blogging.model.PostModel;
import com.cts.blogging.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;

	@Override
	public PostModel createPost(PostDto dto) {
		PostModel model = mapPostDtoToModel(dto);

		return repository.save(model);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<PostModel> postModels = repository.findAll();
		return postModels.stream().map(this::mapPostToDto).toList();
	}

	@Override
	public PostDto getPostById(int id) {
		PostModel postModel = repository.findById(id).orElseThrow(() -> new PostNotFound("Post Not Found"));
		return mapPostToDto(postModel);
	}

	@Override
	public PostModel mapPostDtoToModel(PostDto dto) {
		PostModel postModel = new PostModel();
		postModel.setTitle(dto.getTitle());
		postModel.setContent(dto.getContent());
		postModel.setUserName(dto.getUsername());
		postModel.setCreatedOn(Instant.now());
		postModel.setUpdatedOn(Instant.now());
		return postModel;
	}

	@Override
	public PostDto mapPostToDto(PostModel model) {
		PostDto postDto = new PostDto();
		postDto.setTitle(model.getTitle());
		postDto.setContent(model.getContent());
		postDto.setUsername(model.getUserName());
		postDto.setId(model.getId());
		return postDto;
	}

}
