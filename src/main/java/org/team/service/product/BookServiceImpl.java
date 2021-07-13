package org.team.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.ProductVO;
import org.team.mapper.product.BookMapper;

import lombok.Setter;

@Service
public class BookServiceImpl implements BookService {

	@Setter(onMethod_ = @Autowired)
	private BookMapper mapper;
	
	@Override
	public List<ProductVO> getList() {
		return mapper.getList();
	}

}
