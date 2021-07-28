package org.team.domain.help;

import org.team.domain.member.Criteria;

import lombok.Getter;

@Getter
public class HPageDTO {

	private HBoardCriteria cri;
	
	private int startPage; 
	private int endPage; 
	
	private boolean prev; 
	private boolean next; 
	
	private int total; 
	
	public HPageDTO(HBoardCriteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		int current = cri.getPageNum();
		int numPerPage = cri.getAmount();
		
		
		this.endPage = ((current-1) / 10 + 1) * 10;
		this.startPage = endPage - 9; 
		
		int realEnd = total / numPerPage;
		
		if (total % numPerPage != 0) {
			realEnd = realEnd + 1;
		}
		
		this.endPage = Math.min(endPage, realEnd);
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
