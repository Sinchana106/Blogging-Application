package com.cts.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.blogging.model.PostModel;
@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {

}
