package MyBlog.blogbackend.DTO;

import java.util.Set;

import MyBlog.blogbackend.model.Post;

public class CategoryDTO {

    private Long id;
    private String name;
    private Set<Post> posts;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, Set<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Post> getPosts() { return posts; }

    public void setPosts(Set<Post> posts) { this.posts = posts; }

}
