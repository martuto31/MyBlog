package MyBlog.blogbackend.DTO;

import java.util.HashSet;
import java.util.Set;

import MyBlog.blogbackend.model.Comment;
import MyBlog.blogbackend.model.Post;

public class UserDTO {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Comment> comments = new HashSet<>();
    private Set<Post> posts = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(
            Long id,
            String email,
            String username,
            String password,
            String firstName,
            String lastName,
            Set<Comment> comments,
            Set<Post> posts) {

        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.comments = comments;
        this.posts = posts;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {  this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Set<Comment> getComments() { return comments; }

    public void setComments(Set<Comment> comments) { this.comments = comments; }

    public Set<Post> getPosts() { return posts; }

    public void setPosts(Set<Post> posts) { this.posts = posts; }

}
