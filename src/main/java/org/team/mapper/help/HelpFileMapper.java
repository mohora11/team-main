package org.team.mapper.help;

import org.team.domain.help.HelpFileVO;
import org.team.domain.member.MemberVO;

public interface HelpFileMapper {

	public int insert(HelpFileVO vo);
	
	public void deleteByHno(Long hno);
	
	public void removeByUserid(MemberVO vo);
}
