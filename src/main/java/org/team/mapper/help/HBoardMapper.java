package org.team.mapper.help;

import java.util.List;

import org.team.domain.help.HBoardVO;
import org.team.domain.help.HBoardCriteria;
import org.team.domain.member.MemberVO;

public interface HBoardMapper {
	
	public List<HBoardVO> getList();
	
	public List<HBoardVO> getListWithPaging(HBoardCriteria cri);
	

	public int insert(HBoardVO board);	
	
	public int insertSelectKey(HBoardVO board);
	
	public HBoardVO read(long hno); 
	
	public int delete(long hno);
	
	public int update(HBoardVO board);

	public int getTotalCount(HBoardCriteria cri);

	public void removeByUserid(MemberVO vo);

}
