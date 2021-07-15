package org.team.mapper;

import org.team.domain.FileVO;
import org.team.domain.MemberVO;

public interface FileMapper {
	
	public int insert(FileVO vo);

	public void deleteByBno(Long bno);

	public void removeByUserid(MemberVO vo);  

}
