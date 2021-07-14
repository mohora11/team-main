package org.team.service.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.team.domain.product.ProductVO;

public interface WebtoonService {

	public List<ProductVO> getList();
	
	public ProductVO get(Long id);
}
