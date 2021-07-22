package org.team.mapper.help;

import java.util.List;

import org.team.domain.help.HelpReplyVO;
import org.team.domain.member.MemberVO;

public interface HelpReplyMapper {

	public int insert(HelpReplyVO vo);

	public int insertSelectKey(HelpReplyVO vo);

	public HelpReplyVO read(Long hno);

	public int delete(Long hno);

	public int update(HelpReplyVO vo);

	public List<HelpReplyVO> getList(Long hno);

	public int getCountByHno(Long hno);

	public int deleteByHno(Long hno);

	public void removeByUserid(MemberVO vo);

	public void removeByHnoByUserid(MemberVO vo);
}
