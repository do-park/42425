package com.web.blog.service.board;

import java.util.ArrayList;
import java.util.List;

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

	public void modify(Board board) {
		boardDao.updateBoard(board.getBid(), board.getTitle(), board.getContent());
	}

	public List<Board> searchBoardTitle(String keyword) {
		List<Board> board = boardDao.searchTitle(keyword);

		if (board.isEmpty()) {
			return null;
		}
		return board;
	}

	public List<Board> searchBoardContent(String keyword) {
		List<Board> board = boardDao.searchContent(keyword);

		if (board.isEmpty()) {
			return null;
		}
		return board;
	}

	public List<Board> findByUid(int uid) {
		List<Board> boards = new ArrayList<>();
		boardDao.selectAllBoardByUid(uid).forEach(e -> boards.add(e));
		return boards;
	}
}
