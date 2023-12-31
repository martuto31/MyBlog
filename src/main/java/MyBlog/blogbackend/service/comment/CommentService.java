package MyBlog.blogbackend.service.comment;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyBlog.blogbackend.repository.comment.CommentRepository;

import MyBlog.blogbackend.mapper.EntityMapper;

import MyBlog.blogbackend.model.Comment;

import MyBlog.blogbackend.DTO.CommentDTO;


@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final EntityMapper<Comment, CommentDTO> commentMapper;

    @Autowired
    public CommentService(
            CommentRepository commentRepository,
            EntityMapper<Comment, CommentDTO> commentMapper) {

        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = commentMapper.convertToEntity(commentDTO, Comment.class);
        Comment savedComment = commentRepository.save(comment);

        return commentMapper.convertToDto(savedComment, CommentDTO.class);
    }

    public CommentDTO editComment(Long commentId, String content) throws Exception {
        if (content.isEmpty()) {
            throw new Exception("Content is missing");
        }

        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if (commentOptional.isEmpty()) {
            throw new Exception("Comment with ID " + commentId + " not found.");
        }

        Comment comment = commentOptional.get();
        comment.setContent(content);

        Comment updatedComment = commentRepository.save(comment);

        return commentMapper.convertToDto(updatedComment, CommentDTO.class);
    }

    public void deleteComment(Long commentId) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if (commentOptional.isEmpty()) {
            throw new Exception("Comment with ID " + commentId + " not found.");
        }

        commentRepository.deleteById(commentId);
    }

    public List<CommentDTO> getAllComments() throws Exception {
        List<Comment> comments = commentRepository.findAll();

        if (comments.isEmpty()) {
            throw new Exception("No comments found.");
        }

        return comments.stream()
                .map(comment -> commentMapper.convertToDto(comment, CommentDTO.class))
                .collect(Collectors.toList());
    }

}
