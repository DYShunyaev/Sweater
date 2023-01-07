package com.DYShunyaev.Project.controller;

import com.DYShunyaev.Project.models.Blog;
import com.DYShunyaev.Project.models.Client;
import com.DYShunyaev.Project.service.BlogService;
import com.DYShunyaev.Project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    private final BlogService blogService;
    private final ClientService clientService;

    @Autowired
    public BlogController(BlogService blogService, ClientService clientService) {
        this.blogService = blogService;
        this.clientService = clientService;
    }

    @RequestMapping("/blog/{id}")
    public String blog1(@PathVariable(value = "id", required = false) long id,
                        Model model, Model modelBlog, Model modelList) {
        if (!clientService.existById(id)){
            return "mainPage";
        }
        Client client = clientService.showById(id).orElseThrow();
        model.addAttribute("clientView", client);

        Blog blog = new Blog();
        modelBlog.addAttribute("blog", blog);

        List<Blog> blogList = blogService.findByClientId(id);
        modelList.addAttribute("findByClientId", blogList);

        return "blog";
    }

    @PostMapping("/saveNewBlog/{id}")
    public String saveNewBlog(@RequestParam(name = "blogName") String blogName,
                              @RequestParam(name = "blogText") String blogText,
                              @PathVariable(value = "id") long id) {
        Blog blog = new Blog(blogName, blogText);
        blog.setClient(clientService.showById(id).orElseThrow());
        blogService.saveNewBlog(blog);

        return "redirect:/blog/" + id;
    }

    @RequestMapping("deleteEntry/{client_id}/{id}")
    public String deleteEntryBlog(@PathVariable(value = "id") long id,
                                  @PathVariable(value = "client_id") long client_id) {
        blogService.deleteEntry(id);

        return "redirect:/blog/" + client_id;
    }

}
