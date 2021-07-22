package org.team.domain.help;

import org.team.domain.member.Criteria;

import lombok.Getter;

@Getter
public class HelpPageDTO {

	private HelpCriteria cri;
	
	private int startPage; 
	private int endPage; 
	
	private boolean prev; 
	private boolean next; 
	
	private int total; 
	
	public HelpPageDTO(HelpCriteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		int current = cri.getPageNum();
		int numPerPage = cri.getAmount();
		
		// 현재 페이지가 1~10 이면
		// 시작은 1, 마지막은 10
		this.endPage = ((current-1) / 10 + 1) * 10;
		this.startPage = endPage - 9; // 가령 1--10이면 10에서 9를 빼면 1이니까
		
		int realEnd = total / numPerPage;
		
		// 가장 마지막 페이지
		if (total % numPerPage != 0) {
			realEnd = realEnd + 1;
		}
		
		// '마지막 페이지' 와 '가장 마지막 페이지' 비교 했을 때 적은 숫자
		this.endPage = Math.min(endPage, realEnd);
		
		// 이전, 다음 버튼 표시 여부
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
