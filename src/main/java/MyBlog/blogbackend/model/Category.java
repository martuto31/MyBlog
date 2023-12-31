package MyBlog.blogbackend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Post> posts = new HashSet<>();

    public Category() { }

    public Category(
            String name,
            Set<Post> posts) {

        this.name = name;
        this.posts = posts;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Post> getPosts() { return posts; }

    public void setPosts(Set<Post> posts) { this.posts = posts; }

}
