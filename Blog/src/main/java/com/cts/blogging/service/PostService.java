package com.cts.blogging.service;

import java.util.List;

import com.cts.blogging.dto.PostDto;
import com.cts.blogging.model.PostModel;

public interface PostService {

	public PostModel createPost(PostDto dto) ;
	public List<PostDto> getAllPost();
	public PostDto getPostById(int id);
	public PostModel mapPostDtoToModel(PostDto dto);
	public PostDto mapPostToDto(PostModel model);
	
}
