package org.team.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.ProductVO;
import org.team.mapper.product.WebnovelMapper;

import lombok.Setter;

@Service
public class WebnovelServiceImpl implements WebnovelService {

	@Setter(onMethod_ = @Autowired)
	private WebnovelMapper mapper;
	
	@Override
	public List<ProductVO> getList() {
		return mapper.getList();
	}

	@Override
	public ProductVO get(Long id) {
		return mapper.get(id);
	}

}
