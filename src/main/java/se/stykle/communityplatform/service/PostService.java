package se.stykle.communityplatform.service;

import org.springframework.stereotype.Service;
import se.stykle.communityplatform.model.Post;
import se.stykle.communityplatform.utils.TemporaryDatabaseStorage;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    public Post createPost (Post post) {
        post.setId(1L);
        post.setContent(post.getContent());
        post.setAuthor(post.getAuthor());
        post.setVisibleTo(post.getVisibleTo());
        post.setCreatedAt(OffsetDateTime.now());
        TemporaryDatabaseStorage.listOfPost.add(post);
        return post;

    }

    public List<Post> getAllPost() {
        return TemporaryDatabaseStorage.listOfPost;
    }
}
