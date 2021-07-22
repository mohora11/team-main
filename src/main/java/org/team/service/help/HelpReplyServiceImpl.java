package org.team.service.help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.help.HelpReplyVO;
import org.team.domain.help.HelpVO;
import org.team.mapper.help.HelpReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
public class HelpReplyServiceImpl implements HelpReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private HelpReplyMapper mapper;
	@Override
	public int register(HelpReplyVO vo) {
		
		return mapper.insert(vo);
		
	}

	@Override
	public HelpReplyVO get(Long rno1) {
		
		return mapper.read(rno1);
	}

	@Override
	public int modify(HelpReplyVO vo) {
		
		return mapper.update(vo);
	}
 
	@Override
	public int remove(Long rno1) {
		
		return mapper.delete(rno1);
	}

	@Override
	public List<HelpReplyVO> getList(Long hno) {
		
		return mapper.getList(hno);
	}
	
}
