package com.web.blog.service.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.blog.dao.board.BoardDao;
import com.web.blog.model.board.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<Board> findAll() {
		List<Board> boards = new ArrayList<>();
		// boardDao.findAll().forEach(e -> boards.add(e));
		boardDao.selectAllBoard().forEach(e -> boards.add(e));
		return boards;
	}


	public Board findByBid(int bid) {
		return boardDao.selectBoardByBid(bid);
	}

	public void deleteByBid(int bid) {
		boardDao.delete(findByBid(bid));
	}

	public Board save(Board board) {
		boardDao.save(board);
		return board;

	}
	
	public void modify(int bid, Board board) {
		Optional<Board> e = boardDao.findByBid(bid);

		if (e.isPresent()) {
			e.get().setTitle(board.getTitle());
			e.get().setContent(board.getContent());
			boardDao.save(board);
		}
	}


	public List<Board> searchBoard(String keyword) {
		List<Board> board = boardDao.findByTitleContaining(keyword);

	    if (board.isEmpty()) return board;

	    boardDao.findByTitleContaining(keyword).forEach(e -> board.add(e));

	    return board;
	}


}