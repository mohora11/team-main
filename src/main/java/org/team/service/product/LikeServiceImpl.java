package org.team.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.ProductLikeVO;
import org.team.mapper.product.LikeMapper;

import lombok.Setter;

@Service
public class LikeServiceImpl implements LikeService {

	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;

	@Override
	public int like(ProductLikeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dislike(ProductLikeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
