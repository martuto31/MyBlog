package MyBlog.blogbackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Comment() { }

    public Comment(String content, LocalDateTime createdAt, Post post, User user) {
        this.content = content;
        this.createdAt = createdAt;
        this.post = post;
        this.user = user;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }

    public void setString(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Post getPost() { return post; }

    public void setPost(Post post) { this.post = post; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
