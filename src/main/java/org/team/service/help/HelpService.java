package org.team.service.help;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.team.domain.help.HelpCriteria;
import org.team.domain.help.HelpVO;

public interface HelpService {
	
	public void register(HelpVO board);
	
	public HelpVO get(Long hno);
	
	public boolean modify(HelpVO board);
	
	public boolean remove(Long hno);
	
	public List<HelpVO> getList(HelpCriteria cri);
	
	public int getTotal(HelpCriteria cri);
	
	public void register(HelpVO board, MultipartFile file);
	
	public boolean modify(HelpVO board, MultipartFile file);
}
