package org.team.service.help;

import java.util.List;

import org.team.domain.help.HReplyVO;

public interface HReplyService {
	
	public int register(HReplyVO vo);
	
	public HReplyVO get(Long hno);
	 
	public int modify(HReplyVO vo);
	
	public int remove(Long hrno);
	
	public List<HReplyVO> getList(Long bno);

}
