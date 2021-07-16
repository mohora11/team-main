package org.team.mapper;

import org.team.domain.FileVO;


public interface FileMapper {
	
	public int insert(FileVO vo);

	public void deleteByBno(Long bno);

	

}
