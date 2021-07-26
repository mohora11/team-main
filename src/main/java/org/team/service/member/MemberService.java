package org.team.service.member;

import java.util.List;

import org.team.domain.member.MemberVO;
import org.team.domain.product.ProductVO;

public interface MemberService {

	boolean insert(MemberVO vo);

	MemberVO read(String name);
	
	boolean modify(MemberVO vo);

	boolean remove(MemberVO vo);

	boolean remove(MemberVO vo, String oldPassword);

	boolean modify(MemberVO vo, String oldPassword);

	public List<ProductVO> getLikes(String userid);
	public List<ProductVO> getWebtoonLikes(String userid);
	public List<ProductVO> getWebnovelLikes(String userid);
	public List<ProductVO> getBookLikes(String userid);

}
