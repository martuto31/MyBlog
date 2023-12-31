package MyBlog.blogbackend.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "comment_tags",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public Comment() { }

    public Comment(
            String content,
            LocalDateTime createdAt,
            Post post,
            User user,
            Set<Tag> tags) {

        this.content = content;
        this.createdAt = createdAt;
        this.post = post;
        this.user = user;
        this.tags = tags;
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

    public Set<Tag> getTags() { return tags; }

    public void setTags(Set<Tag> tags) { this.tags = tags; }

}
