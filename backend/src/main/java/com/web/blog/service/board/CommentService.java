package com.web.blog.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.blog.dao.board.CommentDao;
import com.web.blog.model.board.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;

	public List<Comment> findAll() {
		List<Comment> comments = new ArrayList<>();
		commentDao.selectAllComment().forEach(e -> comments.add(e));
		return comments;
	}

	public Comment findByBid(int bid) {
		return commentDao.selectCommentByBid(bid);
	}
	
	public Comment findByUid(int uid) {
		return commentDao.selectCommentByUid(uid);
	}
	
	public Comment findByCid(int cid) {
		return commentDao.selectCommentByCid(cid);
	}
	
	public void deleteByCid(int cid) {
		commentDao.delete(findByCid(cid));
	}

	public Comment save(Comment comment) {
		commentDao.save(comment);
		return comment;
	}
	
	public void modify(int cid, Comment comment) {
		commentDao.updateComment(comment.getCid(), comment.getContent());
	}
//
//
//	public List<Board> searchBoardTitle(String keyword) {
//		List<Board> board = boardDao.searchTitle(keyword);
//		
////		System.out.println(boards.isEmpty() + "z");
////		for (Board board : boards) {
////			System.out.println( board.toString());
////		}
//		
//	    if (board.isEmpty()) {
//	    	return null;
//	    }
//	   
//	    return board;
//	}
//	
//	public List<Board> searchBoardContent(String keyword) {
//		List<Board> board = boardDao.searchContent(keyword);
//		
//		if (board.isEmpty()) {
//			return null;
//		}
//		
//		return board;
//	}


}
