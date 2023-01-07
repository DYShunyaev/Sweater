package com.DYShunyaev.Project.repository;

import com.DYShunyaev.Project.models.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    List<Blog> findByClientId(long client_id);
}
