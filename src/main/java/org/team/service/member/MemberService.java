package org.team.service.member;

import java.util.List;

import org.team.domain.member.MemberVO;

public interface MemberService {

	boolean insert(MemberVO vo);

	MemberVO read(String name);
	
	boolean modify(MemberVO vo);

	boolean remove(MemberVO vo);

	boolean remove(MemberVO vo, String oldPassword);

	boolean modify(MemberVO vo, String oldPassword);
	
	List<MemberVO> read2(MemberVO vo);

	List<MemberVO> read3(MemberVO vo);




}
