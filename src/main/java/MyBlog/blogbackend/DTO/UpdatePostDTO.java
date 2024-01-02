package MyBlog.blogbackend.DTO;

import java.util.Set;

import MyBlog.blogbackend.model.Tag;
import MyBlog.blogbackend.model.Category;

public class UpdatePostDTO {

    private String title;
    private String content;
    private Set<Category> categories;
    private Set<Tag> tags;

    public UpdatePostDTO() { }

    public UpdatePostDTO(
            String title,
            String content,
            Set<Category> categories,
            Set<Tag> tags) {

        this.title = title;
        this.content = content;
        this.categories = categories;
        this.tags = tags;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Set<Category> getCategories() { return categories; }

    public void setCategories(Set<Category> categories) { this.categories = categories; }

    public Set<Tag> getTags() { return tags; }

    public void setTags(Set<Tag> tags) { this.tags = tags; }

}
