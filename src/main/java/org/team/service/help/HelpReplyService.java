package org.team.service.help;

import java.util.List;

import org.team.domain.help.HelpReplyVO;

public interface HelpReplyService {
	
	public int register(HelpReplyVO vo);
	
	public HelpReplyVO get(Long rno1);
	
	public int modify(HelpReplyVO vo);
	
	public int remove(Long rno1);
	
	public List<HelpReplyVO> getList(Long hno);
}
