package org.team.mapper.help;

import java.util.List;

import org.team.domain.help.HelpCriteria;
import org.team.domain.help.HelpVO;
import org.team.domain.member.MemberVO;

public interface HelpMapper {

	public List<HelpVO> getList();
	
	public List<HelpVO> getListWithPaging(HelpCriteria cri);
	

	public int insert(HelpVO board);	
	
	public int insertSelectKey(HelpVO board);
	
	public HelpVO read(long hno); 
	
	public int delete(long hno);
	
	public int update(HelpVO board);

	public int getTotalCount(HelpCriteria cri);

	public void removeByUserid(MemberVO vo);
}
