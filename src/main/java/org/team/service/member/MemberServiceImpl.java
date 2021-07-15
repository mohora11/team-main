package org.team.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.member.MemberVO;
import org.team.mapper.member.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
   @Override
   public boolean insert(MemberVO vo) {
	  int cnt = mapper.insert(vo);
	 
	  return cnt == 1;
   }
}
