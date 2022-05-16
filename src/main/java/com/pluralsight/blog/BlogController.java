package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    //init the posts repo
    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String listPosts( ModelMap modelMap){
//store the posts in a list posts from the post repo
        List<Post>posts = postRepository.getAllPosts();
        //display the list
        modelMap.put("posts",posts);
        return "home";
    }


}
