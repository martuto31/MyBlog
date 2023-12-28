package MyBlog.blogbackend.DTO;

import java.time.LocalDateTime;
import java.util.Set;

public class CommentDTO {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Long postId;
    private Long userId;
    private Set<Long> tagIds;

    public CommentDTO() {
    }

    public CommentDTO(
            Long id,
            String content,
            LocalDateTime createdAt,
            Long postId,
            Long userId,
            Set<Long> tagIds) {

        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.postId = postId;
        this.userId = userId;
        this.tagIds = tagIds;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getPostId() { return postId; }

    public void setPostId(Long postId) { this.postId = postId; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Set<Long> getTagIds() { return tagIds; }

    public void setTagIds(Set<Long> tagIds) { this.tagIds = tagIds; }

}
