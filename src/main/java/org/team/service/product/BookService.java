package org.team.service.product;

import java.util.List;

import org.team.domain.product.ProductVO;

public interface BookService {

	public List<ProductVO> getList();
	
	public ProductVO get(Long id);
}
