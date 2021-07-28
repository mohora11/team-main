package org.team.service.help;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.team.domain.help.HBoardVO;
import org.team.domain.help.HBoardCriteria;

public interface HBoardService {
	
	public void register(HBoardVO board);
	
	public HBoardVO get(Long hno);
	
	public boolean modify(HBoardVO board);
	
	public boolean remove(Long hno);
	
	public List<HBoardVO> getList(HBoardCriteria cri);

	public int getTotal(HBoardCriteria cri);
	
	public void register(HBoardVO board, MultipartFile file);

	public boolean modify(HBoardVO board, MultipartFile file);
	
	
}
