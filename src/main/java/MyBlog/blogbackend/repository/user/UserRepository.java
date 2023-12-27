package MyBlog.blogbackend.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import MyBlog.blogbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
