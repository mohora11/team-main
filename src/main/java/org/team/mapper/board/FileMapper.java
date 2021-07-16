package org.team.mapper.board;

import org.team.domain.board.FileVO;
import org.team.domain.member.MemberVO;

public interface FileMapper {
	
	public int insert(FileVO vo);

	public void deleteByBno(Long bno);

	public void removeByUserid(MemberVO vo);  

}
