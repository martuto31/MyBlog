package MyBlog.blogbackend.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();

    @ManyToMany(mappedBy = "tags")
    private Set<Comment> comments = new HashSet<>();

    public Tag() { }

    public Tag(
            String name,
            Set<Post> posts,
            Set<Comment> comments) {

        this.name = name;
        this.posts = posts;
        this.comments = comments;
    }

}
