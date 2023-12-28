package MyBlog.blogbackend.DTO;

import MyBlog.blogbackend.model.Category;
import MyBlog.blogbackend.model.Comment;
import MyBlog.blogbackend.model.Tag;
import MyBlog.blogbackend.model.User;

import java.time.LocalDateTime;
import java.util.Set;

public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private User user;
    private Set<Comment> comments;
    private Set<Category> categories;
    private Set<Tag> tags;

    public PostDTO() {
    }

    public PostDTO(
            Long id,
            String title,
            String content,
            LocalDateTime createdAt,
            User user,
            Set<Comment> comments,
            Set<Category> categories,
            Set<Tag> tags) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
        this.comments = comments;
        this.categories = categories;
        this.tags = tags;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Set<Comment> getComments() { return comments; }

    public void setComments(Set<Comment> comments) { this.comments = comments; }

    public Set<Category> getCategories() { return categories; }

    public void setCategories(Set<Category> categories) { this.categories = categories; }

    public Set<Tag> getTags() { return tags; }

    public void setTags(Set<Tag> tags) { this.tags = tags; }
}
