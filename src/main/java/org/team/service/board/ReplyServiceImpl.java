package org.team.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.board.ReplyVO;
import org.team.mapper.board.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	@Override
	public int register(ReplyVO vo) {
		
		return mapper.insert(vo);
		
	}

	@Override
	public ReplyVO get(Long rno) {
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.update(vo);
	}
 
	@Override
	public int remove(Long rno) {
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		
		return mapper.getList(bno);
	}
	
}
