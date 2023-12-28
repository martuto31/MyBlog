package MyBlog.blogbackend.DTO;

import java.util.Set;

import MyBlog.blogbackend.model.Comment;
import MyBlog.blogbackend.model.Post;

public class TagDTO {

    private Long id;
    private String name;
    private Set<Post> posts;
    private Set<Comment> comments;

    public TagDTO() {
    }

    public TagDTO(
            Long id,
            String name,
            Set<Post> posts,
            Set<Comment> comments) {
        this.id = id;
        this.name = name;
        this.posts = posts;
        this.comments = comments;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Post> getPosts() { return posts; }

    public void setPosts(Set<Post> posts) { this.posts = posts; }

    public Set<Comment> getComments() { return comments; }

    public void setComments(Set<Comment> comments) { this.comments = comments; }

}
