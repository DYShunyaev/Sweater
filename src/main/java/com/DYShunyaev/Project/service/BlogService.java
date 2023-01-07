package com.DYShunyaev.Project.service;

import com.DYShunyaev.Project.models.Blog;
import com.DYShunyaev.Project.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Optional<Blog> getBlogName(long id) {
        return blogRepository.findById(id);
    }

    public void saveNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public List<Blog> findByClientId(long client_id) {
        return blogRepository.findByClientId(client_id);
    }

    public void deleteEntry(long id) {
        blogRepository.deleteById(id);
    }
}
