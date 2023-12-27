package MyBlog.blogbackend.repository.tag;

import org.springframework.data.jpa.repository.JpaRepository;

import MyBlog.blogbackend.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
