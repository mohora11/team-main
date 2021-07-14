package org.team.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.ProductVO;
import org.team.mapper.main.MainMapper;

import lombok.Setter;

@Service
public class MainServiceImpl implements MainService {

	@Setter(onMethod_ = @Autowired)
	private MainMapper mapper;
	
	@Override
	public List<ProductVO> getList() {
		return mapper.getList();
	}

}
