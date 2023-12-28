package MyBlog.blogbackend.DTO;

import MyBlog.blogbackend.model.Post;
import MyBlog.blogbackend.model.User;

import java.time.LocalDateTime;
import java.util.Set;

public class CommentDTO {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Post post;
    private User user;
    private Set<Long> tagIds;

    public CommentDTO() {
    }

    public CommentDTO(
            Long id,
            String content,
            LocalDateTime createdAt,
            Post post,
            User user,
            Set<Long> tagIds) {

        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.post = post;
        this.user = user;
        this.tagIds = tagIds;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Post getPost() { return post; }

    public void setPost(Post post) { this.post = post; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Set<Long> getTagIds() { return tagIds; }

    public void setTagIds(Set<Long> tagIds) { this.tagIds = tagIds; }

}
