package org.team.service.member;

import java.lang.reflect.Member;

import org.team.domain.product.member.MemberVO;

public interface MemberService {
	
	boolean insert(MemberVO vo);

	Member memberSearch(Member member);

}
