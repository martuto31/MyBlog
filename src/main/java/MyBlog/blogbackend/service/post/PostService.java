package MyBlog.blogbackend.service.post;

import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import MyBlog.blogbackend.mapper.EntityMapper;
import MyBlog.blogbackend.repository.post.PostRepository;

import MyBlog.blogbackend.model.Tag;
import MyBlog.blogbackend.model.Post;
import MyBlog.blogbackend.model.Category;

import MyBlog.blogbackend.DTO.PostDTO;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final EntityMapper<Post, PostDTO> postMapper;

    @Autowired
    public PostService(
            PostRepository postRepository,
            EntityMapper<Post, PostDTO> postMapper) {

        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public Post createPost(PostDTO postDTO) {
        Post post = postMapper.convertToEntity(postDTO, Post.class);

        return postRepository.save(post);
    }

    public Post editPost(
            Long postId,
            String content,
            String title,
            Set<Category> categories,
            Set<Tag> tags) throws Exception {

        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isEmpty()) {
            throw new Exception("Post not found.");
        }

        Post post = postOptional.get();

        if (content.isEmpty() || title.isEmpty() || categories.isEmpty() || tags.isEmpty()) {
            throw new Exception("Content || title || categories || tags is missing.");
        }

        post.setContent(content);
        post.setTitle(title);
        post.setTags(tags);
        post.setCategories(categories);

        return postRepository.save(post);
    }

    public void deletePost(Long postId) throws Exception {
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isEmpty()) {
            throw new Exception("Post with ID " + postId + " not found.");
        }

        postRepository.deleteById(postId);
    }

    public Optional<PostDTO> getPostById(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);

        return postOptional.map(post -> postMapper.convertToDto(post, PostDTO.class));
    }

    public List<PostDTO> getAllPosts() throws Exception {
        List<Post> posts = postRepository.findAll();

        if (posts.isEmpty()) {
            throw new Exception("No posts found.");
        }

        return posts.stream()
                .map(post -> postMapper.convertToDto(post, PostDTO.class))
                .collect(Collectors.toList());
    }

}
