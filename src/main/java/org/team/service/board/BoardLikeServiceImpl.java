package org.team.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.board.BoardLikeVO;
import org.team.mapper.board.BoardLikeMapper;

import lombok.Setter;

@Service
public class BoardLikeServiceImpl implements BoardLikeService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardLikeMapper mapper;

	@Override
	public int like(BoardLikeVO vo) {
		return mapper.like(vo);
	}
	
	@Override
	public void plusCnt(BoardLikeVO vo) {
		mapper.plusCnt(vo);
	}
	
	@Override
	public int cancelLike(BoardLikeVO vo) {
		return mapper.cancelLike(vo);
	}
	
	@Override
	public void minusCnt(BoardLikeVO vo) {
		mapper.minusCnt(vo);
	}
	
	@Override
	public int dislike(BoardLikeVO vo) {
		return mapper.dislike(vo);
	}
	
	@Override
	public void displusCnt(BoardLikeVO vo) {
		mapper.displusCnt(vo);
	}
	
	@Override
	public int cancelDislike(BoardLikeVO vo) {
		return mapper.cancelDislike(vo);
	}
	
	@Override
	public void disminusCnt(BoardLikeVO vo) {
		mapper.disminusCnt(vo);
	}
	
	@Override
	public BoardLikeVO get(String bno, String userid) {
		return mapper.read(bno, userid);
	}
	
	@Override
	public BoardLikeVO getDislike(String bno, String userid) {
		return mapper.read1(bno, userid);
	}
}
