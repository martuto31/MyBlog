package MyBlog.blogbackend.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;

import MyBlog.blogbackend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
