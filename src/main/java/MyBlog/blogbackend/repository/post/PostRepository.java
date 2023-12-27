package MyBlog.blogbackend.repository.post;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import MyBlog.blogbackend.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    // TODO: Add pagination

    @Query("SELECT p FROM Post p WHERE p.title = :title")
    Post findByTitle(String title);

    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    List<Post> findAllByDateDesc();

    @Query("SELECT p FROM Post p ORDER BY p.createdAt ASC")
    List<Post> findAllByDateAsc();

}
