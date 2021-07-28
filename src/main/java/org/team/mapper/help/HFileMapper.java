package org.team.mapper.help;

import org.team.domain.help.HFileVO;
import org.team.domain.member.MemberVO;

public interface HFileMapper {
	
	public int insert(HFileVO vo);

	public void deleteByHno(Long hno);

	public void removeByUserid(MemberVO vo);  

}
