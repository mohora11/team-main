package org.team.service.help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.help.HReplyVO;
import org.team.mapper.help.HReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
public class HReplyServiceImpl implements HReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private HReplyMapper mapper;
	@Override
	public int register(HReplyVO vo) {
		
		return mapper.insert(vo);
		
	}

	@Override
	public HReplyVO get(Long hrno) {
		
		return mapper.read(hrno);
	}

	@Override
	public int modify(HReplyVO vo) {
		
		return mapper.update(vo);
	}
 
	@Override
	public int remove(Long hrno) {
		
		return mapper.delete(hrno);
	}

	@Override
	public List<HReplyVO> getList(Long hno) {
		
		return mapper.getList(hno);
	}
	
}
