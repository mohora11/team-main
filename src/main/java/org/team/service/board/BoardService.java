package org.team.service.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.team.domain.board.BoardVO;
import org.team.domain.board.BoardCriteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList(BoardCriteria cri);

	public int getTotal(BoardCriteria cri);
	
	public void register(BoardVO board, MultipartFile file);

	public boolean modify(BoardVO board, MultipartFile file);
	
	
}
