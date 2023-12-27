package MyBlog.blogbackend.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import MyBlog.blogbackend.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // TODO: Add pagination

    @Query("SELECT c FROM Comment c WHERE c.user.id = :userId")
    List<Comment> findAllByUserId(Long userId);

    @Query("SELECT c FROM Comment c WHERE c.user.id = :userId ORDER BY c.createdAt DESC")
    List<Comment> findAllByUserIdOrderByDateDesc(Long userId);

    @Query("SELECT c FROM Comment c WHERE c.post.id = :postId")
    List<Comment> findAllByPostId(Long postId);

    @Query("SELECT c FROM Comment c WHERE c.post.id = :postId ORDER BY c.createdAt DESC")
    List<Comment> findAllByPostIdOrderByDateDesc(Long postId);

}
