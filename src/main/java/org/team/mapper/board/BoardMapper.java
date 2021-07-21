package org.team.mapper.board;

import java.util.List;

import org.team.domain.board.BoardVO;
import org.team.domain.board.BoardCriteria;
import org.team.domain.member.MemberVO;

public interface BoardMapper {
	
//	@Select("SELECT * FROM tbl_board")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(BoardCriteria cri);
	

	public int insert(BoardVO board);	
	
	public int insertSelectKey(BoardVO board);
	
	public BoardVO read(long bno); 
	
	public int delete(long bno);
	
	public int update(BoardVO board);

	public int getTotalCount(BoardCriteria cri);

	public void removeByUserid(MemberVO vo);

}
