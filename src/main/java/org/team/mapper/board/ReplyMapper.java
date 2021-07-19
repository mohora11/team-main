package org.team.mapper.board;

import java.util.List;

import org.team.domain.board.ReplyVO;
import org.team.domain.member.MemberVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public int insertSelectKey(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	 
	public List<ReplyVO> getList(Long bno);
	
	public int getCountByBno(Long bno);
	
	public int deleteByBno(Long bno);

	public void removeByUserid(MemberVO vo);

	public void removeByBnoByUserid(MemberVO vo);
}
