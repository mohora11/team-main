package org.team.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team.domain.member.AuthVO;
import org.team.domain.member.MemberVO;
import org.team.mapper.member.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder encoder;
	
	@Override
	@Transactional
	public boolean insert(MemberVO vo) {

		// 패스워드 암호화
		vo.setUserpw(encoder.encode(vo.getUserpw()));
		int cnt = mapper.insert(vo);
		
		// 권한 입력
		AuthVO avo = new AuthVO();
		avo.setUserid(vo.getUserid());
		avo.setAuth("ROLE_USER");
		mapper.insertAuth(avo);
		
		return cnt == 1;
	}
	
	@Override
	public List<MemberVO> read2(MemberVO vo) {
		
		return mapper.read2(vo);
	}
	
	@Override
	public List<MemberVO> read3(MemberVO vo) {
		
		return mapper.read3(vo);
	}
	
	@Override
	public MemberVO read(String name) {

		return mapper.read(name);
	}
	
	@Override
	public boolean modify(MemberVO vo, String oldPassword) {
		MemberVO old = mapper.read(vo.getUserid());
		
		if(encoder.matches(oldPassword, old.getUserpw())) {
			return modify(vo);
		}
		return false;
	}
	@Override
	public boolean modify(MemberVO vo) {
		
		vo.setUserpw(encoder.encode(vo.getUserpw()));
		
		int cnt = mapper.update(vo);
		
		return cnt == 1;
	}
	@Override
	public boolean remove(MemberVO vo, String oldPassword) {
		MemberVO old = mapper.read(vo.getUserid());
		if(encoder.matches(oldPassword, old.getUserpw())) {
		
			return remove(vo);
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean remove(MemberVO vo) {
		// 권한삭제tbl_member_auth
		mapper.removeAuth(vo);
		
		// 회원삭제(tbl_member)
		int cnt = mapper.remove(vo);
		return cnt == 1;
}
}
