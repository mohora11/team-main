package org.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.team.domain.BoardVO;
import org.team.domain.BoardCriteria;


public interface BoardMapper {
	
//	@Select("SELECT * FROM tbl_board")
	public List<BoardVO> getList();
	
	public List<org.team.domain.BoardVO> getListWithPaging(BoardCriteria cri);
	
	// INSERT INTO ble_board (title, content, writer)
	// VALUES (#{title}, #{content}, #{writer}) mybatis에서 사용하는 쿼리
	public int insert(BoardVO board);
	/*
	  	String sql = "INSERT INTO tbl_board (title, content, writer) VALUES (?, ?, ?) ";
	  	...
	  	pstmt.setString(1, board.getTitle());
	  	pstmt.setString(2, board.getContent());
	  	pstmt.setString(3, board.getWriter());
	  	
	  	pstmt.executeUpdate();
	  
	 */
	
	public int insertSelectKey(BoardVO board);
	
	public BoardVO read(long bno); //하나만 뽑아서 보는것
	
	public int delete(long bno);
	
	public int update(BoardVO board);

	public int getTotalCount(BoardCriteria cri);

	

}
