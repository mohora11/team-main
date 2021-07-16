package org.team.service.member;

import org.team.domain.member.MemberVO;

public interface MemberService {

	boolean insert(MemberVO vo);

	MemberVO read(String name);


}
