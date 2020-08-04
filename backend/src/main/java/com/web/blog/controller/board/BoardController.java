package com.web.blog.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.blog.model.board.Board;
import com.web.blog.service.board.BoardService;

import io.swagger.models.Model;

@RestController
@RequestMapping("board")
@CrossOrigin(origins = { "http://localhost:3000" })
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoardService boardService;

	// 모든 게시글 조회
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Board>> getAllboards() {
		List<Board> board = boardService.findAll();
		return new ResponseEntity<List<Board>>(board, HttpStatus.OK);
	}

	//게시글 번호로 조회
	@GetMapping(value="/{bid}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Board> getboard(@PathVariable("bid") int bid){
		Board board = boardService.findByBid(bid);
//		System.out.println(bid);
//		System.out.println(board.toString());
		return new ResponseEntity<Board>(board,HttpStatus.OK);
	}

	// 게시글 번호로 삭제
	@DeleteMapping(value = "delete/{bid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteBoard(@PathVariable("bid") int bid) {
		boardService.deleteByBid(bid);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 게시글 번호로 게시글 수정
	@PutMapping(value = "modify/{bid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Board> updateBoard(@PathVariable("bid") int bid, Board board) {
		boardService.modify(bid, board);
		return new ResponseEntity<Board>(board, HttpStatus.OK);

	}

	// 게시글 등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ResponseEntity<Board> save(HttpServletRequest req, Board board) {
		return new ResponseEntity<Board>(boardService.save(board), HttpStatus.OK);
	}
	
	//검색
	@GetMapping("/search")
	public ResponseEntity<List<Board>> search(@RequestParam(value="keyword") String keyword, Model model) {
	    List<Board> board = boardService.searchBoard(keyword);

	    return new ResponseEntity<List<Board>>(board, HttpStatus.OK);

	}

}
