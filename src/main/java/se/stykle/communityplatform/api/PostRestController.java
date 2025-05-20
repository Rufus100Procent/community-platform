package se.stykle.communityplatform.api;

import org.springframework.web.bind.annotation.*;
import se.stykle.communityplatform.model.Post;
import se.stykle.communityplatform.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v0/post")
public class PostRestController {

    private  final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post creatingPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }
}
