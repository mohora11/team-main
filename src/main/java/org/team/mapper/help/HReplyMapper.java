package org.team.mapper.help;

import java.util.List;

import org.team.domain.help.HReplyVO;
import org.team.domain.member.MemberVO;

public interface HReplyMapper {
	
	public int insert(HReplyVO vo);
	
	public int insertSelectKey(HReplyVO vo);
	
	public HReplyVO read(Long hrno);
	
	public int delete(Long hrno);
	
	public int update(HReplyVO vo);
	 
	public List<HReplyVO> getList(Long hno);
	
	public int getCountByHno(Long hno);
	
	public int deleteByHno(Long hno);

	public void removeByUserid(MemberVO vo);

	public void removeByHnoByUserid(MemberVO vo);
}
