package com.himmu.blog.service.Imple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.himmu.blog.Expections.ResourseNotFoundExceptions;
import com.himmu.blog.Repositories.CommentRepositories;
import com.himmu.blog.Repositories.PostRepositories;
import com.himmu.blog.dto.CommentDTO;
import com.himmu.blog.entities.Comment;
import com.himmu.blog.entities.Post;
import com.himmu.blog.service.CommentService;

@Service
public class CommentServiceImple implements CommentService {
    
	@Autowired
	private CommentRepositories commentRepositories;
	
	@Autowired
	private PostRepositories postrepositories;
	
	
	@Override
	public CommentDTO createCommect(CommentDTO commentdto , Integer postId) {
		
		Post post = postrepositories.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("post" , "postId" , postId));
		
		Comment comment = dtoToComment(commentdto);
		comment.setPost(post);
		Comment savecomment = commentRepositories.save(comment);
		return commentToDto(savecomment);
	}

	@Override
	public void deletComment(Integer commentId) {
		
		Comment comment = commentRepositories.findById(commentId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("comment" , "commentId" , commentId));
		commentRepositories.delete(comment);
	}

	
	
	
	
	// Conversion Convert CommentDTOs to Comment and Vice-Versa
	public Comment dtoToComment(CommentDTO commentdto) {
		Comment c = new Comment();
		c.setCommentContent(commentdto.getCommentContent());
		return c;
	}
	
	public CommentDTO commentToDto(Comment comment) {
		CommentDTO c = new CommentDTO();
		c.setCommentContent(comment.getCommentContent());
		return c;
	}

}
